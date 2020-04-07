package com.tj.ex3insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class InsertOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하고자 하는 부서번호는 ? ");
		int deptno = sc.nextInt();
		System.out.print("입력하고자 하는 부서이름은 ? ");
		String dname = sc.next(); // 부서이름에는 space 사용불가
		System.out.print("입력하고자 하는 부서위치는 ? ");
		sc.nextLine(); // 버퍼를 지우는 용도
		String loc = sc.nextLine();
		String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"', '"+loc+"')";
		sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", 
													deptno, dname, loc);
		Connection conn = null;
		Statement  stmt = null;
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url,"scott","tiger");//2
			stmt = conn.createStatement();//3
			int result = stmt.executeUpdate(sql);//4+5
			System.out.println(result>0? "입력성공":"입력실패");//6
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
	}
}







