<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>예외처리</h2>
	<c:catch var="error"> <!-- catch절에서 예외가 발생할 경우 예외타입과 예외 메세지를 error에 저장 -->
		<h2>테스트</h2>
		<%=8/0 %>
		<p>예외가 발생되면 즉시 catch절을 빠져나감. 지금 이것이 출력되었다면 예외발생안됨</p>
	</c:catch>
	예외타입과 메세지 : <c:out value="${error }" default="예외발생 안 됨"/>
</body>
</html>















