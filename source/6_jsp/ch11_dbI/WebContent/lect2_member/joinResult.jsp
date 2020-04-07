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
<%if(request.getParameter("result").equals("success")) {%>
	<h2>회원가입이 정상처리되었습니다</h2>
	<hr>
	<button onclick="location.href='login.jsp'">로그인</button>
<%}else { %>
	<h2>회원가입이 처리되지 않았습니다.</h2>
	<button onclick="location.href='join.jsp'">회원가입</button>
	<button onclick="location.href='login.jsp'">로그인</button>
<%} %>
</body>
</html>












