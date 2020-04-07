<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/ch15_el/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>1부터 ${param.su }까지 누적합은 ${requestScope.sum }입니다</h2>
	<h2>1부터 ${param.su }까지 누적합은 ${sum }입니다</h2>
</body>
</html>