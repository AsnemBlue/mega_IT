<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="visitNum" value="${param.visitNum }"/>
	<c:if test="${visitNum eq 0 }">
		<h2>첫방문 감사합니다</h2>
	</c:if>
	<c:if test="${visitNum eq 1 }">
		<h2>두번째 방문 감사합니다</h2>
	</c:if>
	<c:if test="${visitNum<5 && visitNum>=0 }">
		<h2>몇번 오셨군요. 감사합니다</h2>
	</c:if>
	<c:if test="${visitNum>5 }">
		<h2>많이 뵙네요. 감사합니다</h2>
	</c:if>
	<c:if test="${visitNum < 0 }">
		<h2>제대로 된 방문 횟수를 받지 못했습니다. 죄송합니다</h2>
	</c:if>
</body>
</html>
















