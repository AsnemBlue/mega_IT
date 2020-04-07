package com.tj.ex2selectWhere;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("출력을 원하는 부서번호는 ? ");
		int deptno = sc.nextInt();
		String query = "SELECT * FROM EMP where deptno="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott","tiger");//2
			stmt = conn.createStatement(); //3
			rs   = stmt.executeQuery(query); // 4+5
			if(rs.next()) {// 결과가 1행이상
				do {
					// rs받아서 출력 (사번, 이름, 부서번호)
					int    empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					int deptnum   = rs.getInt("deptno");
					System.out.println(empno+"\t"+ename+"\t"+deptnum);
				}while(rs.next());
			}else { // 결과가 0행
				System.out.println("해당 부서번호의 사원은 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try { //7.연결해제
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {  }
		}
	}
}








