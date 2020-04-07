<%@page import="com.tj.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.tj.dto.MemberDto"/>
	<jsp:setProperty name="dto" property="*" />
	<%
		MemberDao memberDao = MemberDao.getInstance();
		int result = memberDao.insertMember(dto);
		if(result>0){
			out.println("<h2>회원가입 성공</h2>");
		}else{
			out.println("<h2>회원가입 실패</h2>");
		}
	%>
	<jsp:include page="memberList.jsp"/>
</body>
</html>















