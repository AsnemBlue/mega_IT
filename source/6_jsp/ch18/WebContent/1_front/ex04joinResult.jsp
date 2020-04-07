<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<c:set var="SUCCESS" value="1"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${joinResult eq SUCCESS }">
		<script>alert('회원가입이 완료되었습니다');</script>
		<h2>회원가입이 완료되었습니다</h2>
	</c:if>
	<c:if test="${joinResult == 0 }">
		<script>alert('회원가입이 실패되었습니다');</script>
		<h2>회원가입이 실패되었습니다</h2>
	</c:if>
</body>
</html>












