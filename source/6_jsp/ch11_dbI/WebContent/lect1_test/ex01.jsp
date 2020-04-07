<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String driverMysql = "com.mysql.jdbc.Driver";
	String urlMysql    = "jdbc:mysql://127.0.0.1:3306/kimdb";
	String uidMysql    = "root";
	String upwMysql    = "mysql";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid    = "scott";
	String upw    = "tiger";	
%>
<%
	Connection conn = null;
	Statement  stmt = null;
	ResultSet  rs   = null;
	String sql = "SELECT * FROM EMP";
	try{
		Class.forName(driver); //1단계 : 드라이버 로드
		conn = DriverManager.getConnection(url, uid, upw); // 2단계 : DB연결객체
		stmt = conn.createStatement();   // 3단계 : SQL전송객체
		rs   = stmt.executeQuery(sql);   // 4단계(SQL전송) + 5단계(SQL전공결과 받기)
		while(rs.next()){                // 6단계 : 결과받아 적당한 로직 수행
			int empno = rs.getInt(1); // 1번째 필드
			String ename = rs.getString("ename"); // ename 필드
			String job = rs.getString("job");
			int mgr    = rs.getInt("mgr");
			Date hiredate = rs.getDate("hiredate");
			//Timestamp hire = rs.getTimestamp("hiredate");
			int sal = rs.getInt("sal");
			int comm = rs.getInt("comm");
			int deptno = rs.getInt("deptno");
			out.println("<p>"+empno+"(사번) "+ename+"(이름) "+job+"(직책) "+mgr+"(상사사번)" 
					+hiredate +"(입사일) "+sal+"(급여) "+comm+"(상여) "+deptno+"(부서번호)</p>");
		}
	}catch(Exception e){
		System.out.println("에러 메세지 : "+ e.getMessage());
	}finally{  // 7단계 : 연결 해제
		try{
			if(rs!=null)   rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			System.out.println("에러 메세지 : "+ e.getMessage());
		}
	}
%>
</body>
</html>