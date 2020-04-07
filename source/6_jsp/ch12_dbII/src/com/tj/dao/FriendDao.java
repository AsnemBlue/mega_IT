package com.tj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tj.dto.FriendDto;

public class FriendDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid    = "scott";
	private String upw    = "tiger";
	private static FriendDao instance= new FriendDao(); // MemberDao객체를 가르키는 변수
	public static FriendDao getInstance() {
		return instance;
	}	
	private FriendDao() {
		try {
			Class.forName(driver); // 1단계
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<FriendDto> selectAll(){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT * FROM FRIEND";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				int no = rs.getInt("no");
//				String name = rs.getString("name");
//				String tel = rs.getString("tel");
//				dtos.add(new FriendDto(no, name, tel));
//			}
			while(rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}
		return dtos;
	}
	public int insertFriend(FriendDto dto) {
		int result = 0;
		// 2~7단계
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			result = pstmt.executeUpdate();
			System.out.println(result>0? "친구추가성공":dto.toString()+"친구추가실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(dto.toString()+"친구추가실패");
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {  }
		}
		return result;
	}
	// 무료하신 분들의 위한 검색버튼에 추가 내용
	public ArrayList<FriendDto> selectNameTel(String name, String tel){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND TEL LIKE '%'||?||'%'";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				int no = rs.getInt("no");
//				String name = rs.getString("name");
//				String tel = rs.getString("tel");
//				dtos.add(new FriendDto(no, name, tel));
//			}
			while(rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}
		return dtos;
	}
}
