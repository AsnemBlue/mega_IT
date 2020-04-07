package com.tj.ex5delete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DeleteOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제하고자 하는 부서번호는 ? ");
		int deptno = sc.nextInt();
		String deleteSQL = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		deleteSQL = String.format("DELETE FROM DEPT WHERE DEPTNO=%d", deptno);
		Connection conn = null;
		Statement  stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(deleteSQL);
			System.out.println(result>0? deptno+"부서 삭제 성공" : deptno+"부서삭제실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) { }
		}
	}
}
