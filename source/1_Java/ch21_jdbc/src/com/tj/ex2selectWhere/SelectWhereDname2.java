package com.tj.ex2selectWhere;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class SelectWhereDname2 {
	public static void main(String[] args) {
		// 1.사용자로부터 부서이름받아
		// 2-1. 해당부서이름이 있을 경우, 부서정보출력, 해당부서사원(이름,입사일,부서번호,위치)
		// 2-2. 해당부서이름이 없을 경우 없다고 출력
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서이름은 ?");
		String dname = sc.nextLine();
		String sql1 = "SELECT * FROM DEPT WHERE DNAME='"+dname+"'";
		String sql2 = "SELECT ename, hiredate, e.deptno,loc FROM EMP E, DEPT D" + 
				" WHERE E.DEPTNO=D.DEPTNO AND DNAME='"+dname+"'"; 
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs = null;
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url,"scott","tiger");//2
			stmt = conn.createStatement(); //3
			rs = stmt.executeQuery(sql1); // 4+5
			if(rs.next()) { // 6
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("입력하신 부서 번호 : "+deptno);
				System.out.println("입력하신 부서 이름 : "+dname);
				System.out.println("입력하신 부서 위치 : "+loc);
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					do {
						String ename = rs.getString("ename");
						String hiredate = rs.getString("hiredate");
						loc      = rs.getString("loc");
						System.out.println(ename+"\t"+hiredate+"\t"+loc);
					}while(rs.next());
				}else {
					System.out.println("해당부서 사원은 없습니다.");
				}
			}else {
				System.out.println("유효하지 않는 부서이름입니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"드라이버 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"SQL 오류");
		}finally {
			try { //7.연결해제
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {  }
		}
	}
}
