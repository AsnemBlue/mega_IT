package com.tj.ex6preparedstatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStatementUpdateSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 부서번호를 입력받아 있는 부서번호이며 수정작업(부서이름, 부서위치를 받아 수정)
		//                    없는 부서번호이면 없다고 출력
		String seleteSQL ="SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String updateSQL = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 부서번호는 ? ");
		int deptno = sc.nextInt();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			Class.forName(driver);//1단계
			conn = DriverManager.getConnection(url,"scott","tiger");//2단계
			pstmt = conn.prepareStatement(seleteSQL); //3단계
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();  // 4단계 + 5단계
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt==1) {//있는 부서번호인 경우 수정작업(부서이름, 부서위치를 받아 수정)
				System.out.print("수저할 부서이름은 ? ");
				String dname = sc.next();
				System.out.print("수정할 부서위치는 ? ");
				String loc = sc.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(updateSQL); // 3단계
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate(); // 4단계 + 5단계
				System.out.println(result>0? "수정성공":"수정실패");
			}else {
				System.out.println("존재하지 않는 부서번호입니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {  // 7단계
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { }
		}
	}
}
