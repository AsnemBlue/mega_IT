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
	<h1>쿠키들 리스트</h1>
	<%
		Cookie[] cookies = request.getCookies();
		for(int idx=0 ; idx<cookies.length ; idx++){
			String name = cookies[idx].getName(); // idx번째 쿠키의 이름
			String value = cookies[idx].getValue(); // idx번째 쿠키 값
			out.print("<h2>"+idx+"번째 쿠키이름:"+name+", 값:"+value+"</h2>");
		}
	%>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키생성</a><br>
	<a href="ex02_cookieslist.jsp">쿠키값들 리스트 확인</a> <br>
	<a href="ex03_thatCookie.jsp">특정 쿠키(이름이 cookieName) 찾기</a> <br>
	<a href="ex04_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>













