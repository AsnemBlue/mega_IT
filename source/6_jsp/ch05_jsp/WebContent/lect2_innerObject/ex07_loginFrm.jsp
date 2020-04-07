<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<style>
		td{text-align: center; padding:5px;}
		#msg {text-align:center; color:red;}
</style>
</head>
<body>
<%
	String msg = request.getParameter("msg");
	if(msg!=null){
%>		
		<script>alert('아이디와 비번을 확인하세요');</script>
<%	}%>
	<form action="ex07_loginCertification.jsp" method="post">
		<table>
			<tr><th>아이디</th><td><input type="text" name="id" autofocus="autofocus"></td></tr>
			<tr><th>패스워드</th><td><input type="password" name="pw"></td></tr>
			<tr><td colspan="2"><input type="submit" value="로그인"></td></tr>
		</table>
	</form>
	<div id="msg">
	<%
		if(msg!=null){
			out.print("아이디와 비번을 확인하세요");
		} 
	%>
	</div>

</body>
</html>