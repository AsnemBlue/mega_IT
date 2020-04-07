<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>home.jsp입니다</h2>
	<h2>${greeting }</h2>
	<h2><a href="${conPath }/main">MAIN 요청</a></h2>
	<hr>
	<img src="${conPath }/img/flower.jpg" alt="이미지">
</body>
</html>















