<%@page import="com.tj.ex.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%MemberInfo mi = new MemberInfo("홍길동","aaa","111");%>
	<h2>회원 정보(getter이용)</h2>
	<h3>이름 : <%=mi.getName() %></h3>
	<h3>ID : <%=mi.getId() %></h3>
	<h3>PW : <%=mi.getPw() %></h3>
	<h2>회원 정보(el 이룔)</h2>
	<h3>이름 : ${mi.name }</h3>
	<h3>ID : ${mi.id }</h3>
	<h3>PW : ${mi.pw }</h3>
</body>
</html>














