<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.member.MemberDto"%>
<%@page import="com.tj.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<h1>테스트 페이지</h1>
	<%
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmId("zzz");
		if(result==MemberDao.MEMBER_EXISTENT){
			out.println("<h3>1.confirmId테스트 : zzz는 있는(중복된) id</h3>");
		}else{
			out.println("<h3>1.confirmId테스트 :zzz는 없는(사용가능한) id</h3>");
		}
		out.println("<hr><h3>2. insertMember테스트</h3>");
		// id, pw, name, email, Timestamp birth, Date rdate, address
		MemberDto dto = new MemberDto("bbb","111","박길동",null, 
				Timestamp.valueOf("1990-02-13 12:21:00"), null, "서울");
		/* result = mDao.insertMember(dto);
		if(result==MemberDao.SUCCESS){
			out.println("가입 성공한 멤버 : "+dto.toString());
		}else{
			out.print("가입 실패");
		} */
		out.println("<hr>3.로그인 loginCheck");
		result = mDao.loginCheck("aaa", "111");
		if(result == MemberDao.LOGIN_SUCCESS){
			out.println("aaa/111 로그인 성공");
		}else if(result == MemberDao.LOGIN_FAIL_PW){
			out.println("aaa/111 비밀번호 오류");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
			out.println("aaa/111 아이디 오류");
		}
		out.println("<br>");
		result = mDao.loginCheck("sdsd", "222");
		if(result == MemberDao.LOGIN_SUCCESS){
			out.println("sdsd/222 로그인 성공");
		}else if(result == MemberDao.LOGIN_FAIL_PW){
			out.println("sdsd/222 비밀번호 오류");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
			out.println("sdsd/222 아이디 오류");
		}
		out.println("<hr>4. id로 dto가져오기");
		dto = mDao.getMember("aaa");
		out.println("aaa아이디인 사람의 정보 : "+dto);
		out.println("<hr>5. 회원정보 수정하기 aaa회원 정보 수정");
		dto = new MemberDto("aaa","xxx","xxx","xxx", 
				Timestamp.valueOf("1990-02-13 12:21:00"), null, "xxx");
		result = mDao.updateMember(dto);
		if(result==MemberDao.SUCCESS){
			out.println("수정 후 데이터 : "+mDao.getMember("aaa"));
		}else{
			out.println("수정 실패"+dto);
		}
	%>
</body>
</html>













