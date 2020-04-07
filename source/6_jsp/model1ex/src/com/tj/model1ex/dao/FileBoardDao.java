package com.tj.model1ex.dao;
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

import com.tj.model1ex.dto.FileBoardDto;
public class FileBoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	private static FileBoardDao instance = new FileBoardDao();
	public static FileBoardDao getInstance() {
		return instance;
	}
	private FileBoardDao() {}
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
	// 글목록
	public ArrayList<FileBoardDto> listFileBoard(int startRow, int endRow){
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM " + 
				"        (SELECT F.*, CNAME, cemail FROM FILEBOARD F, CUSTOMER C" + 
				"            WHERE F.CID=C.CID ORDER BY fREF DESC, fRE_STEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    fnum     = rs.getInt("fnum");
				String cid      = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename= rs.getString("ffilename");
				String fpw      = rs.getString("fpw");
				int    fhit     = rs.getInt("fhit");
				int    fref     = rs.getInt("fref");
				int    fre_step = rs.getInt("fre_step");
				int    fre_level= rs.getInt("fre_level");
				String fip      = rs.getString("fip");
				Date   frdate   = rs.getDate("frdate");
				String cname    = rs.getString("cname");
				String cemail   = rs.getString("cemail");
				dtos.add(new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, 
				  fpw, fhit, fref, fre_step, fre_level, fip, frdate, cname, cemail));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 등록된 글갯수 가져오기
	public int getFileBoardTotCnt() {
		int totCnt = 0;
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totCnt = rs.getInt(1);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
	// 원글쓰기
	public int insertFileBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD "
					+ "(fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, "
					+ "fREF, fRE_STEP, fRE_LEVEL, fIP) VALUES "
			+ "(FILEBOARD_SEQ.NEXTVAL, ?,?,?,?,? , FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setString(6, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글쓰기성공":"글쓰기실패");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("글쓰기 예외 : "+dto.toString());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 답변글 저장전에 수행될 step ⓐ
	private void preReplyStepA(int fref, int fre_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fRE_STEP = fRE_STEP+1" + 
				"            WHERE fREF = ? AND fRE_STEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fref);
			pstmt.setInt(2, fre_step);
			int result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "기존답변글들 밑으로":"답변 처음이네");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 답변글쓰기
	public int reply(FileBoardDto dto) {
		int result = FAIL;
		preReplyStepA(dto.getFref(), dto.getFre_step());
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD "
				+ "(fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, "
				+ "fREF, fRE_STEP, fRE_LEVEL, fIP) VALUES "
			+ "(FILEBOARD_SEQ.NEXTVAL, ?,?,?,?,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFref());
			pstmt.setInt(7, dto.getFre_step()+1);
			pstmt.setInt(8, dto.getFre_level()+1);
			pstmt.setString(9, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "답글 성공":"답글 실패");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("답글 예외 : "+dto.toString());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 글 상세보기(글번호로 dto가져오기)
	public FileBoardDto getFileBoard(int fnum) {
		FileBoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, cNAME, cEMAIL FROM FILEBOARD F, CUSTOMER C " + 
				"        WHERE F.cID=C.cID AND fNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String cid      = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename= rs.getString("ffilename");
				String fpw      = rs.getString("fpw");
				int    fhit     = rs.getInt("fhit");
				int    fref     = rs.getInt("fref");
				int    fre_step = rs.getInt("fre_step");
				int    fre_level= rs.getInt("fre_level");
				String fip      = rs.getString("fip");
				Date   frdate   = rs.getDate("frdate");
				String cname    = rs.getString("cname");
				String cemail   = rs.getString("cemail");
				dto = new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, fpw,
						fhit, fref, fre_step, fre_level, fip, frdate, cname, cemail);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 조회수 올리기
	public void hitUp(int fnum) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}//close()
		}//try-catch-finally
	}
	// 글수정
	public int updateFileBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSUBJECT = ?," + 
				"                    fCONTENT = ?," + 
				"                    fFILENAME = ?," + 
				"                    fPW = ?," + 
				"                    fIP = ?" + 
				"        WHERE fNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글수정 성공":"글수정 실패");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("글수정 예외 : "+dto.toString());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 글삭제
	public int deleteFileBoard(int fnum, String fpw) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE fNUM=? AND fPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글삭제 성공":"글삭제 실패");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}