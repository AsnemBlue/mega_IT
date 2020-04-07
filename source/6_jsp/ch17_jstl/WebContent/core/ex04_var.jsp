<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>변수선언</h2>
	<c:set var="varName" value="varValue"/><!-- 변수 선언 -->
	varName : ${varName }<br>
	varName : <c:out value="${varName }"/><!-- 출력태그 --><br>
	<c:set var="varName" value="<varValue>"/>
	varName : ${varName }<br>
	varName : <c:out value="${varName}" escapeXml="true"/><!--escapeXml="true" 특수문자로 인식-->
	<c:remove var="varName"/> <!-- 변수 삭제 -->
	varName : ${empty varName? "삭제됨":"남아있음" }<br>
	varName : ${varName }<br>
	varName : <c:out value="${varName }" default="없어졌어"></c:out>
</body>
</html>
















