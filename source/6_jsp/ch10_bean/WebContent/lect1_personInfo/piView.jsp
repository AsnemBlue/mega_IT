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
	<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request"/>
	<h2>입력된 개인정보</h2>
	<p>이름 : <jsp:getProperty name="pi" property="name"/></p>
	<p>나이 : <jsp:getProperty name="pi" property="age"/> </p>
	<p>성별 : <jsp:getProperty name="pi" property="gender"/></p>
	<p>주소 : <jsp:getProperty name="pi" property="address"/> </p>
</body>
</html>










