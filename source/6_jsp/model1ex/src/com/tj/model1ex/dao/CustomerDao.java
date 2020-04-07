package com.tj.model1ex.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.tj.model1ex.dto.CustomerDto;
public class CustomerDao {
	public static final int SUCCESS = 1; // 회원가입, 정보수정 할 때
	public static final int FAIL = 0;    // 회원가입, 정보수정 할 때
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공
	public static final int LOGIN_FAIL = 0; // 로그인 오류(ID오류)
	public static final int CUSTOMER_EXISTENT = 0; // 있는(중복된) ID
	public static final int CUSTOMER_NONEXISTENT = 1; // 없는(사용가능한) ID
	
	private static CustomerDao instance = new CustomerDao();
	public static CustomerDao getInstance() {
		return instance;
	}
	private CustomerDao() {}
	// conn객체 가져오는 함수
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
	// 1. 회원가입시 id 중복체크 (매개변수 :cid)
	public int confirmId(String cid) {
		int result = CUSTOMER_EXISTENT; // 초기화
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 중복된 ID(있는 ID)
				System.out.println("있다");
				result = CUSTOMER_EXISTENT;
			}else { // 사용가능한 ID(없는 ID)
				System.out.println("없다");
				result = CUSTOMER_NONEXISTENT;
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (Exception e) { }
		}
		return result;
	}
	// 2. 회원가입 (매개변수 :dto)
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER) " + 
				"    VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCgender());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원가입 성공":"회원가입 실패"+dto.toString());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 "+dto.toString());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) { }
		}
		return result;
	}
	// 3. 로그인 처리 (매개변수 : id, pw)
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=? and CPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {//유효한 id를 입력한 경우 - pw가 맞는지 체크
				result = LOGIN_SUCCESS;
			}else { // 유효하지 않는 id를 입력한 경우
				result = LOGIN_FAIL;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) { }
		}
		return result;
	}
	// 4. id로 DTO가져오기 (매개변수 : id)
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cpw = rs.getString("cpw");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				String cemail = rs.getString("cemail");
				String caddress = rs.getString("caddress");
				Date   cbirth = rs.getDate("cbirth");
				String cgender = rs.getString("cgender");
				Timestamp crdate = rs.getTimestamp("crdate");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cbirth, cgender, crdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) { }
		}
		return dto;
	}
	// 5. 회원정보 수정 (매개변수 : dto)
	public int updateCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPW=?," + 
				"                CNAME=?," + 
				"                CTEL = ?," + 
				"                CEMAIL=?," + 
				"                CADDRESS=?," + 
				"                CBIRTH=?," + 
				"                CGENDER = ?" + 
				"        WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setDate(6, dto.getCbirth());
			pstmt.setString(7, dto.getCgender());
			pstmt.setString(8, dto.getCid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "정보수정 성공":"정보수정 실패"+dto.toString());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("정보수정 실패 "+dto.toString());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) { }
		}
		return result;
	}
	// 회원목록 (startRow~endRow)
	public ArrayList<CustomerDto> listCustomer(int startRow, int endRow){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM "
									+ "(SELECT * FROM CUSTOMER ORDER BY CID) A) "
					+ "WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String cid = rs.getString("cid");
				String cpw = rs.getString("cpw");
				String cname = rs.getString("cname");
				String ctel  = rs.getString("ctel");
				String cemail= rs.getString("cemail");
				String caddress=rs.getString("caddress");
				Date   cbirth = rs.getDate("cbirth");
				String cgender= rs.getString("cgender");
				Timestamp crdate=rs.getTimestamp("crdate");
				dtos.add(new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, 
						cbirth, cgender, crdate));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) { }
		}
		return dtos;
	}
	//등록된 회원 수 가져오기(paging처리할시 pageCnt 계산할 때 필요)
	public int getCustomerTotCnt() {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) TOTCNT FROM CUSTOMER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totCnt = rs.getInt("totcnt");
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) { }
		}
		return totCnt;
	}
}

















