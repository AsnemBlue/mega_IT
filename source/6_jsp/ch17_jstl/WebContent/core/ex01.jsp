<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>core 라이브러리</h2>
	<c:forEach begin="1" end="3" step="1">
		<p>안녕하세요</p>
	</c:forEach>
	<h2>fmt(formatting)라이브러리</h2>
	<fmt:formatNumber value="3.141592" pattern="#.000"/>
	<h2>그 외 라이브러리(function라이브러리)</h2>
	${fn:toUpperCase(param.id) }
	<!-- fn라이브러리는 EL과 함께 사용할 수 있다 -->
</body>
</html>












