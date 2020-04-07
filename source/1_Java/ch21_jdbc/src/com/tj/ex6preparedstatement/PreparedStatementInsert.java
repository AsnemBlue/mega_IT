package com.tj.ex6preparedstatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PreparedStatementInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 부서번호 ? ");
		String deptno = sc.next();
		System.out.print("부서이름은 ?");
		String dname = sc.next();
		System.out.print("위치는 ? ");
		String loc = sc.next();
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url,"scott","tiger"); //2
			//stmt = conn.createStatement(); - SQL전송할 객체(stmt) 생성
			//int result = stmt.excuteUpdate(sql);  - SQL 전송 + 결과받기
			pstmt = conn.prepareStatement(sql); // SQL전송할 객체(pstmt) 생성
			pstmt.setString(1, deptno); // sql에 첫번째 ? 처리
			pstmt.setString(2, dname);  // sql에 두번째 ? 처리
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0? "성공":"실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}









