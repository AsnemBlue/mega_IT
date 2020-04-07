<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	body { background-color: #ffffaa; }
	footer {height:80px;background-color: #003300;}
	footer #footer_conts, footer #footer_conts a {
		color:white;
		font-weight: blod;
		font-size:0.9em;
		text-align: center;
	}
	footer #footer_conts p:first-child {
		font-weight: bold; height: 30px; line-height: 30px;
	}
</style>
</head>
<body>
	<footer>
		<div id="footer_conts">
			<p>(주)더조은803</p> 
			<p>서울특별시 종로구 수표로  육의전빌딩 8,9F | <b><a href="${conPath }/adminloginView.do">관리자 모드</a></b></p>
			<p>Copyright© 2020 tj . All rights reserved.</p>
		</div>
	</footer>
</body>
</html>