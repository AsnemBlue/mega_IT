<%@page import="java.util.Arrays, java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/ex3.css" rel="stylesheet">
</head>
<body>
	<%
	int[] iArr = {10,20,30};
	out.println(Arrays.toString(iArr));
	System.out.println(Arrays.toString(iArr));
	%>
	<hr>
	<%@ include file="../member/footer.jsp" %>
	<hr>
	<% Date now = new Date(System.currentTimeMillis()); %>
	현재는 <%=now %>입니다
</body>
</html>










