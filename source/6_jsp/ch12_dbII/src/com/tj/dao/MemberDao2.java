package com.tj.dao;
// 회원들 리스트(select * from member결과), 회원가입 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.dto.MemberDto;

public class MemberDao2 {
	private DataSource dataSource;
	private static MemberDao2 instance= new MemberDao2();
	public static MemberDao2 getInstance() {
		return instance;
	}	
	private MemberDao2() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public ArrayList<MemberDto> selectAll(){ // 회원들리스트 가져오는 메소드
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		// 2~7단계
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				String id = rs.getString("id");
//				String name = rs.getString("name");
//				String pw = rs.getString("pw");
//				String phone1 = rs.getString("phone1");
//				String phone2 = rs.getString("phone2");
//				String phone3 = rs.getString("phone3");
//				String gender = rs.getString("gender");
//				dtos.add(new MemberDto(id, name, pw, phone1, phone2, phone3, gender));
//			}
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPw(rs.getString("pw"));
				dto.setPhone1(rs.getString("phone1"));
				dto.setPhone2(rs.getString("phone2"));
				dto.setPhone3(rs.getString("phone3"));
				dto.setGender(rs.getString("gender"));
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
	public int insertMember(MemberDto dto) {
		int result = 0;
		// 2~7단계
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?)";
								//id, name, pw, phone들, gender
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			result = pstmt.executeUpdate();
			System.out.println(result>0? "회원가입성공":dto.toString()+"회원가입실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(dto.toString()+"회원가입실패");
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {  }
		}
		return result;
	}
}