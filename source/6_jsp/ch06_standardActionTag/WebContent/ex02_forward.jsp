<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex02_forward.jsp파일입니다</h1>
	<%String n = request.getParameter("n");%>
	<h3>n = <%=n %></h3>
</body>
</html>