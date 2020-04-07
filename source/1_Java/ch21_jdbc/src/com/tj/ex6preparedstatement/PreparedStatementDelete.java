package com.tj.ex6preparedstatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class PreparedStatementDelete {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 부서번호를 입력받아 있는 부서번호이며 수정작업(부서이름, 부서위치를 받아 수정)
		//                    없는 부서번호이면 없다고 출력
		// select(stmt객체이용) -> update(pstmt객체이용)
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 부서번호는 ?");
		int deptno = sc.nextInt();
		String selectSql = "SELECT COUNT(*) \"CNT\" FROM DEPT WHERE DEPTNO="+deptno;
		String updateSql = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		Connection        conn  = null;
		Statement         stmt  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql);
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt==1) {// 있는 부서번호이며 수정작업(부서이름, 부서위치를 받아 수정)
				System.out.print("수정할 부서이름?");
				String dname = sc.next();
				System.out.print("수정할 부서위치?");
				String loc = sc.next();
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0? "수정성공":"수정실패");
			}else {
				System.out.println("존재하지 않는 부서번호라 수정 불가");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}










