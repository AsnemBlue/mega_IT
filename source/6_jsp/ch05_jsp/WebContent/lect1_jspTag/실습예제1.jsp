<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String color = request.getParameter("color");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{background-color: <%=color%>;}
</style>
</head>
<body>
	<h2>배경색은 <%=color %>입니다</h2>
</body>
</html>