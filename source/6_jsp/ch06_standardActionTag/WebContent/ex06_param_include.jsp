<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex06_param파일입니다.</h1>
	<hr>
	<jsp:include page="ex05.jsp">
		<jsp:param value="aaa" name="id"/>
		<jsp:param value="111" name="pw"/>
		<jsp:param value="xxx" name="ex04"/>
	</jsp:include>
	<hr>
	<h1>다시 ex06_param파일입니다.</h1>
</body>
</html>







