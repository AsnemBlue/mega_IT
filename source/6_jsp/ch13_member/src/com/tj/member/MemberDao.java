package com.tj.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class MemberDao {
	public static final int SUCCESS = 1; // 회원가입, 정보수정 할 때
	public static final int FAIL = 0;    // 회원가입, 정보수정 할 때
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공
	public static final int LOGIN_FAIL_ID = -1; // 로그인 오류(ID오류)
	public static final int LOGIN_FAIL_PW = 0;  // 로그인 오류(PW오류) 
	public static final int MEMBER_EXISTENT = 0; // 있는(중복된) ID
	public static final int MEMBER_NONEXISTENT = 1; // 없는(사용가능한) ID
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	private MemberDao() {}
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
	// 1. 회원가입시 id 중복체크 (매개변수 :id)
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT; // 초기화
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 중복된 ID(있는 ID)
				System.out.println("있다");
				result = MEMBER_EXISTENT;
			}else { // 사용가능한 ID(없는 ID)
				System.out.println("없다");
				result = MEMBER_NONEXISTENT;
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
	public int insertMember(MemberDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, EMAIL, BIRTH, RDATE, ADDRESS) " + 
						"    VALUES (?,?,?,?,?,SYSDATE,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setTimestamp(5, dto.getBirth());
			pstmt.setString(6, dto.getAddress());
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
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {//유효한 id를 입력한 경우 - pw가 맞는지 체크
				String dbPw = rs.getString("pw");
				if(dbPw.equals(pw)) { // 로그인 성공
					result = LOGIN_SUCCESS;
				}else { // pw오류
					result = LOGIN_FAIL_PW;
				}
			}else { // 유효하지 않는 id를 입력한 경우
				result = LOGIN_FAIL_ID;
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
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
//				dto = new MemberDto();
//				dto.setId(id);
//				dto.setPw(rs.getString("pw"));
//				dto.setName(rs.getString("name"));
//				dto.setEmail(rs.getString("email"));
//				dto.setBirth(rs.getTimestamp("birth"));
//				dto.setRdate(rs.getDate("rdate"));
//				dto.setAddress(rs.getString("address"));
				String pw       = rs.getString("pw");
				String name     = rs.getString("name");
				String email    = rs.getString("email");
				Timestamp birth = rs.getTimestamp("birth");
				Date rdate      = rs.getDate("rdate");
				String address  = rs.getString("address");
				dto = new MemberDto(id, pw, name, email, birth, rdate, address);
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
	public int updateMember(MemberDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PW = ?," + 
				"                NAME = ?," + 
				"                EMAIL = ?," + 
				"                BIRTH = ?," + 
				"                ADDRESS = ?" + 
				"        WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setTimestamp(4, dto.getBirth());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getId());
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
}