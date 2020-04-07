package com.tj.ex1selectAll;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		String query = "SELECT * FROM PERSONAL";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);// 1단계 드라이버
			conn = DriverManager.getConnection(url, "root","mysql");//2단계 DB연결
			stmt = conn.createStatement(); // 3단계 SQL전송 객체
			rs = stmt.executeQuery(query); // 4단계SQL전송 5단계 SQL결과받기
			System.out.println("사번\t이름\t직책\t상사사번\t입사일\t급여\t상여\t부서번호");
			System.out.println("---------------------------------------------------");
			while(rs.next()) {// 6단계 원하는 로직 수행
				int    pno   = rs.getInt("pno");
				String pname = rs.getString("pname");
				String job   = rs.getString("job");
				int manager  = rs.getInt("manager");
				Date statedate = rs.getDate("startdate");
				int pay        = rs.getInt("pay");
				int bonus      = rs.getInt("bonus");
				int dno        = rs.getInt("dno");
				System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"+
							statedate+"\t"+pay+"\t"+bonus+"\t"+dno);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 7단계 연결해제
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}











