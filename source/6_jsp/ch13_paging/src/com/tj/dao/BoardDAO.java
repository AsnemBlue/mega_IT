package com.tj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.dto.BoardDTO;

public class BoardDAO {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BoardDAO instance;
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		
		return instance;
	}
	private BoardDAO () {
		
	}
	
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
	
	// 글 갯수 가져오는 메소드 getBoardTotalCnt()
	public int getBoardTotalCnt() {
		int totCnt = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOARD";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			totCnt = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return totCnt;
	}
	
	// 글 목록 출력할때 쓸 listBoard()
	public ArrayList<BoardDTO> listBoard() {
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int 		num 	 = rs.getInt("num");
				String 		writer	 = rs.getString("writer");
				String 		subject	 = rs.getString("subject");
				String 		content	 = rs.getString("content");
				String 		email	 = rs.getString("email");
				int 		hit		 = rs.getInt("hit");
				String 		pw		 = rs.getString("pw");
				int 		ref		 = rs.getInt("ref");
				int 		re_step = rs.getInt("re_step");
				int 		re_level = rs.getInt("re_level");
				String 		ip		 = rs.getString("ip");
				Timestamp 	rDate	 = rs.getTimestamp("rDate");
				
				dtos.add(new BoardDTO(num, writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rDate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return dtos;
	}
	
	// 글 목록 출력할때 쓸 listBoard(int startRow, int endRow)
	public ArrayList<BoardDTO> listBoard(int startRow, int endRow) {
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A) " + 
				"    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int 		num 	 = rs.getInt("num");
				String 		writer	 = rs.getString("writer");
				String 		subject	 = rs.getString("subject");
				String 		content	 = rs.getString("content");
				String 		email	 = rs.getString("email");
				int 		hit		 = rs.getInt("hit");
				String 		pw		 = rs.getString("pw");
				int 		ref		 = rs.getInt("ref");
				int 		re_step = rs.getInt("re_step");
				int 		re_level = rs.getInt("re_level");
				String 		ip		 = rs.getString("ip");
				Timestamp 	rDate	 = rs.getTimestamp("rDate");
				
				dtos.add(new BoardDTO(num, writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rDate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return dtos;
	}
	
	// 글 쓰기 insertBoard(dto)
	public int insertBoard(BoardDTO dto) {
		int result  = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP) " + 
				"        VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), ?, ?, ?, " + 
				"                ?, ?, (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
	}
	
	// 글 번호로 글 dto 가져오기 getBoardOneLine(int num)
	public BoardDTO getBoardOneLine(int num) {
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		String sql = "SELECT * FROM BOARD WHERE NUM = " + num;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if (rs.next()) {
				String 		writer	 = rs.getString("writer");
				String 		subject	 = rs.getString("subject");
				String 		content	 = rs.getString("content");
				String 		email	 = rs.getString("email");
				int 		hit		 = rs.getInt("hit");
				String 		pw		 = rs.getString("pw");
				int 		ref		 = rs.getInt("ref");
				int 		re_step = rs.getInt("re_step");
				int 		re_level = rs.getInt("re_level");
				String 		ip		 = rs.getString("ip");
				Timestamp 	rDate	 = rs.getTimestamp("rDate");
				
				dto = new BoardDTO(num, writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rDate);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return dto;
	}
	
	// 글 번호로 글 dto 가져오기 getBoardOneLine(String num)
	public BoardDTO getBoardOneLine(String num) {
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		String sql = "SELECT * FROM BOARD WHERE NUM = " + num;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if (rs.next()) {
				String 		writer	 = rs.getString("writer");
				String 		subject	 = rs.getString("subject");
				String 		content	 = rs.getString("content");
				String 		email	 = rs.getString("email");
				int 		hit		 = rs.getInt("hit");
				String 		pw		 = rs.getString("pw");
				int 		ref		 = rs.getInt("ref");
				int 		re_step = rs.getInt("re_step");
				int 		re_level = rs.getInt("re_level");
				String 		ip		 = rs.getString("ip");
				Timestamp 	rDate	 = rs.getTimestamp("rDate");
				
				dto = new BoardDTO(Integer.parseInt(num), writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rDate);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return dto;
	}
	
	// 조회수 올리기 hitUp(int num)
	public void hitUp(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET HIT = HIT +1 WHERE NUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	// 조회수 올리기 hitUp(String num)
	public void hitUp(String num) {
		hitUp(Integer.parseInt(num));
	}
	
	// 글 수정 updateBoard(dto)
	public int updateBoard(BoardDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET WRITER = ?, " + 
				"                SUBJECT = ?, " + 
				"                CONTENT = ?, " + 
				"                EMAIL = ?, " + 
				"                PW = ? ," +
				"                IP = ? " +
				"        WHERE NUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			pstmt.setInt(7, dto.getNum());
			
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글수정성공":"글수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
	}
	
	// 글 삭제 deleteBoard(num, pw)
	public int deleteBoard(int num, String pw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM BOARD WHERE NUM = ? AND PW = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
						
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? num+"번글삭제성공":num+"번글삭제실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	
	// 답변글 ⓐ스텝 : UPDATE BOARD SET RE_STEP = RE_STEP + 1 WHERE REF = 300 AND RE_STEP > 0
	private void preReplyStepA(int ref, int re_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET RE_STEP = RE_STEP + 1 WHERE REF = ? AND RE_STEP > ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);			
			int result = pstmt.executeUpdate();
			System.out.println(result+"개 조정함");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	// 답변글 저장
	public int reply(BoardDTO dto) {
		
		// NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP
		// 원글에대한 정보 : ref, re_step, re_level
		// 사용자로부터 입력받을 답변글 내용 : write, subject, content, email, pw
		// 시스템으로부터 가져올 ip
		int result = FAIL;
		System.out.printf("DB에 ref(%d)가 같고 re_step(%d)이상인 친구들 ++",dto.getRef(), dto.getRe_step());
		preReplyStepA(dto.getRef(), dto.getRe_step());		// step ⓐ먼저하기
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP ) " + 
				     "    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setInt(6, dto.getRef());	// 원글번호
			pstmt.setInt(7, dto.getRe_step()+1);
			pstmt.setInt(8, dto.getRe_level()+1);
			pstmt.setString(9, dto.getIp());
			
			result = pstmt.executeUpdate();
			//
			dto.setRe_level(dto.getRe_level()+1);
			dto.setRe_step(dto.getRe_step()+1);
			System.out.println(result == SUCCESS ? "답변글 성공"+ dto.toString() : "답변글 실패" + dto.toString());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변글 실패" + dto.toString());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return result;
	}
	
}
























