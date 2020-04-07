package com.tj.ex6preparedstatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStatementSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM EMP " + 
				"    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME=?)";
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서이름은 ? ");
		String dname = sc.next();
		try {
			Class.forName(driver);  //1단계
			conn = DriverManager.getConnection(url,"scott","tiger");//2단계
			pstmt = conn.prepareStatement(sql);//3단계
			pstmt.setString(1, dname); // 물음표 처리
			rs = pstmt.executeQuery(); // 4단계+5단계
			while(rs.next()) {         // 6단계
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				System.out.println(empno+"\t"+ename+"\t"+deptno);
			}
			System.out.println("Done");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {  // 7단계
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}









