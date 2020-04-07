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
	<!--  뷰단   -->
	<jsp:useBean class="com.tj.ex.Student" id="student" scope="request"/>
	<h2>입력된 개인정보</h2>
	<p>학번 : <jsp:getProperty name="student" property="studentNum"/></p>
	<p>이름 : <jsp:getProperty name="student" property="name"/> </p>
	<p>학년 : <jsp:getProperty name="student" property="grade"/></p>
	<p>반 : <jsp:getProperty name="student" property="className"/> </p>
	<p>점수 : <jsp:getProperty name="student" property="score"/> </p>
</body>
</html>










