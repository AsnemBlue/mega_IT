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
		// �μ���ȣ�� �Է¹޾� �ִ� �μ���ȣ�̸� �����۾�(�μ��̸�, �μ���ġ�� �޾� ����)
		//                    ���� �μ���ȣ�̸� ���ٰ� ���
		// select(stmt��ü�̿�) -> update(pstmt��ü�̿�)
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �μ���ȣ�� ?");
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
			if(cnt==1) {// �ִ� �μ���ȣ�̸� �����۾�(�μ��̸�, �μ���ġ�� �޾� ����)
				System.out.print("������ �μ��̸�?");
				String dname = sc.next();
				System.out.print("������ �μ���ġ?");
				String loc = sc.next();
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0? "��������":"��������");
			}else {
				System.out.println("�������� �ʴ� �μ���ȣ�� ���� �Ұ�");
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









