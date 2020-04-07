package com.tj.ex2selectWhere;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class SelectWhereDeptno2 {
	// 1.사용자에게 부서번호를 물어보고 
	// 2-1. 해당부서번호가 있으면 해당부서이름, 해당부서위치 출력후, 해당부서 사원을 출력.
	// 2-2. 해당부서번호가 없으면 해당부서번호가 없다고 출력
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("출력을 원하는 부서번호는 ? ");
		int deptno = sc.nextInt();
		String query1 = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		String query2 = "SELECT * FROM EMP WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott","tiger");//2
			stmt = conn.createStatement(); //3
			rs   = stmt.executeQuery(query1); // 4+5
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc   = rs.getString("loc");
				System.out.println("원하는 부서번호 : "+deptno);
				System.out.println("원하는 부서이름 : "+dname);
				System.out.println("원하는 부서위치 : "+loc);
				rs.close();
				rs = stmt.executeQuery(query2);
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						Date hiredate = rs.getDate("hiredate");
						System.out.println(empno+"\t"+ename+"\t"+hiredate);
					}while(rs.next());
				}else {
					System.out.println(deptno+"번 부서 사원은 없습니다");
				}
			}else {
				System.out.println("유효하지 않는 부서번호입니다");
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








