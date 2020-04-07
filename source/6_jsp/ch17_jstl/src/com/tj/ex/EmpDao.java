package com.tj.ex;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class EmpDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public ArrayList<EmpDto> getListEmp(){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job   = rs.getString("job");
				int    mgr   = rs.getInt("mgr");
				Date hiredate= rs.getDate("hiredate");
				int    sal   = rs.getInt("sal");
				int    comm  = rs.getInt("comm");
				int   deptno = rs.getInt("deptno");
				emps.add(new EmpDto(empno, ename, job, mgr, 
								hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return emps;
	}
	public ArrayList<EmpDto> getListEmp(String schEname, String schJob){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||?||'%' AND JOB LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schEname);
			pstmt.setString(2, schJob);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job   = rs.getString("job");
				int    mgr   = rs.getInt("mgr");
				Date hiredate= rs.getDate("hiredate");
				int    sal   = rs.getInt("sal");
				int    comm  = rs.getInt("comm");
				int   deptno = rs.getInt("deptno");
				emps.add(new EmpDto(empno, ename, job, mgr, 
								hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return emps;
	}
	public int getTotCnt() {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM EMP";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				totCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
}














