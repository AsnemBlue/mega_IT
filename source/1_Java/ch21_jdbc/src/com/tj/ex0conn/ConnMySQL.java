package com.tj.ex0conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0
		//String driver = "com.mysql.jdbc.Driver"; // 5.X버전 mysql일 경우
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		//String url = "jdbc:mysql://127.0.0.1:3306/kimdb"; // 5.X버전 mysql일 경우
		Connection conn = null;
		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "root","mysql"); //(2)
			System.out.println("MySQL 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {System.out.println(e.getMessage());}
		}
	}
}
