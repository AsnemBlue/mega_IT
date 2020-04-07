<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.tj.ex.MemberInfo" scope="page"/>
	<jsp:setProperty name="member" property="*" />
	<h2>bean 태그를 이용한 정보 출력</h2>
	<h3>이름 <jsp:getProperty name="member" property="name" /></h3>
	<h3>ID <jsp:getProperty name="member" property="id" /></h3>
	<h3>PW <jsp:getProperty name="member" property="pw" /></h3>
	<h2>getter를 이용한 정보 출력</h2>
	<h2>이름 : <%=member.getName() %></h2>
	<h2>ID  : <%=member.getId() %></h2>
	<h2>PW : <%=member.getPw() %></h2>
	<h2>el 표기법을 이용한 정보 출력</h2>
	<h3>이름 : ${member.name }</h3>
	<h3>ID : ${member.id }</h3>
	<h3>PW : ${member.pw }</h3>
</body>
</html>
















