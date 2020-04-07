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
<%
	if(1+2==3){
		out.print("1+2는 3입니다<br>");
	}else{
		out.print("1+2는 3이 아닙니다<br>");
	}
%>
	<c:if test="${1+2 eq 3 }">
		1+2는 3입니다<br>
	</c:if>
	<c:if test="${1+2 != 3 }" var="result" scope="page">
		1+2는 3이 아닙니다<br>
	</c:if>
	두번째 if문 조건에 대한 결과는 ${result }입니다
</body>
</html>
















