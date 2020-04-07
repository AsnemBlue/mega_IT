package com.tj.ex3insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class InsertOracle2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하고자 하는 부서번호는? ");
		int deptno = scanner.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs = null;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott","tiger");//2
			stmt = conn.createStatement(); //3
			rs = stmt.executeQuery(selectSQL); // 4+5
			if(!rs.next()) { // 중복된 부서번호가 아니면 추가작업(부서이름,위치받아 insert)
				System.out.print("입력할 부서이름은 ? ");
				String dname = scanner.next();
				System.out.print("입력할 부서위치는 ? ");
				String loc = scanner.next();
				String insertSQL =String.format("INSERT INTO DEPT VALUES (%d, '%s','%s')", 
																	deptno, dname, loc);
				insertSQL = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"','"+loc+"')";
				int result = stmt.executeUpdate(insertSQL);
				System.out.println(result>0 ? "부서입력성공":"부서입력실패");
				
			}else { // 중복된 부서번호를 입력한 경우
				System.out.println("중복된 부서번호가 존재합니다. 다른부서번호 써요");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {}
		}
		
		
	}
}
