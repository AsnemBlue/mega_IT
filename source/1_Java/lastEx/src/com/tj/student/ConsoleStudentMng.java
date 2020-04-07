package com.tj.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class ConsoleStudentMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		String fn = "";
		ArrayList<StudentDTO> students = new ArrayList<StudentDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement         stmt  = null;
		ResultSet         rs    = null;
		String sName, mName; int score;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		do {
			System.out.print("1:입력, 2:학과별출력, 3:전체출력, 그외:종료");
			fn = sc.next();
			switch(fn) {
			case "1" : // 입력작업(이름,학과명,점수를 받아 insert)
				String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES" + 
						"    (TO_CHAR(SYSDATE, 'YYYY')" + 
						"    ||(SELECT mNO FROM MAJOR WHERE mNAME = ?)" + 
						"    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000'))," + 
						"    ?,(SELECT mNO FROM MAJOR WHERE mNAME=?), ?) ";
				System.out.print("입력할 학생 이름 ?");
				sName = sc.next();
				System.out.print("학과명 ? ");
				mName = sc.next();
				System.out.print("점수 ? ");
				score = sc.nextInt();
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");//2
					pstmt = conn.prepareStatement(sql);//3
					pstmt.setString(1, mName);
					pstmt.setString(2, sName);
					pstmt.setString(3, mName);
					pstmt.setInt(4, score);
					int result = pstmt.executeUpdate(); // 4+5
					System.out.println(result>0 ? sName+"입력 성공":"입력실패"); // 6
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try { //7
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (Exception e) {}
				}
				break;
			case "2" : // 학과별 출력(학과명을 입력받아 해당학과 학생 출력 students 이용)
				sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE" + 
						"    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND mNAME=?" + 
						"            ORDER BY SCORE DESC)";
				System.out.print("출력을 원하는 학과이름은 ? ");
				mName = sc.next();
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");//2단계
					pstmt = conn.prepareStatement(sql); // 3단계
					pstmt.setString(1, mName);
					rs = pstmt.executeQuery();
					students.clear(); //students에 있는 값을 모두 지움 size=0으로
					while(rs.next()) {
						int rank      = rs.getInt("rank");
						String nameNo = rs.getString("name_no");
						mName         = rs.getString("mName");
						score         = rs.getInt("score");
						students.add(new StudentDTO(rank, nameNo, mName, score));
					}
					if(students.size()!=0) { // 데이터가 있음
						System.out.println("등수\t이름(nameNO)\t학과\t점수");
						System.out.println("----------------------------------------------------");
						for(StudentDTO s : students) {
							System.out.println(s);
						}
					}else {
						System.out.println("해당 학과 학생이 없습니다");
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try { //7
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (Exception e) {}
				}
				
				break;
			case "3" : // 전체 출력 (students 이용)
				sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE" + 
						"    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=0" + 
						"            ORDER BY SCORE DESC)";
				try {
					conn = DriverManager.getConnection(url, "scott","tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					students.clear();
					while(rs.next()) {
						int rank      = rs.getInt("rank");
						String nameNo = rs.getString("name_no");
						mName         = rs.getString("mName");
						score         = rs.getInt("score");
						students.add(new StudentDTO(rank, nameNo, mName, score));
					}
					if(!students.isEmpty()) {
						System.out.println("등수\t이름(nameNO)\t학과\t점수");
						System.out.println("----------------------------------------------------");
						for(StudentDTO s : students) {
							System.out.println(s);
						}
					}else {
						System.out.println("학생이 없습니다.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try { //7
						if(rs   !=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (Exception e) {}
				}
				break;
			}
		}while(fn.equals("1") || fn.equals("2")||fn.equals("3"));
		System.out.println("안녕");
	}
}








