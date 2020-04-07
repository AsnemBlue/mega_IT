package com.tj.ex5delete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DeleteOracle2 {
	public static void main(String[] args) {
		// 1. 삭제할 부서번호를 입력받습니다
		// 2-1. 존재하는 부서번호일 경우 : 진짜 삭제할지 물어보고(Y/N) 
		             // 2-1-1 Y를 입력했을 경우 : 해당부서번호 삭제
					 // 2-1-2 N를 입력했을 경우 : 프로그램 끝
		// 2-2. 존재하지 않는 부서번호일 경우 : 존재하지 않는 부서번호입니다 출력
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제하고자 하는 부서번호는 ? ");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		String deleteSQL = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			if(rs.next()) {
				System.out.print(deptno+"번 정말 삭제하시겠습니까? ");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("y")) {
					int result = stmt.executeUpdate(deleteSQL);
					System.out.println(result>0? deptno+"부서 삭제 성공" : deptno+"부서삭제실패");
				}else if(answer.equalsIgnoreCase("n")) {
					System.out.println(deptno+"번 삭제하지 않겠습니다");
				}else {
					System.out.println("Y나 N을 안 누르고 뭘 하라는 건지");
				}
			}else {
				System.out.println("존재하지 않는 부서번호입니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  != null) rs.close();
				if(stmt!= null) stmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage()); 
			}// close try-catch
		}//try-catch-finally
	}//main
}//class
