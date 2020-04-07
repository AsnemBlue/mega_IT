<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!	String name, id, pw; %>
<%	request.setCharacterEncoding("utf-8");
	name = request.getParameter("name");
	id   = request.getParameter("id");
	pw   = request.getParameter("pw");
%>
	<h2>아이디는 <%=id %>이고</h2>
	<h2>패스워드는 <%=pw %>입니다</h2>
	<h2><%=name %>님 반갑습니다</h2>
</body>
</html>













