<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#logoutForm_wrap{
		width:1000px; margin: 10px auto; height: 600px; 
		border: 1px solid #D4A190;
		line-height: 600px;
		text-align: center;
		font-size: 2em; color: #A47160;
	}
</style>
</head>
<body>
	<%@include file="header.jsp" %>
	<div id="logoutForm_wrap">
	<%
		session.invalidate();
		//response.sendRedirect("main.jsp");
	%>
		로그아웃되었습니다. 잠시후 페이지 이동이 있겠습니다
	<script>
		setTimeout(function(){location.href='main.jsp';}, 10000);
	</script>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>