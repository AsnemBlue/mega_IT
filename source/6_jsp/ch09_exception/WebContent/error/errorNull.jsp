<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> <%--exception 내부 객체 쓰기 위함 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	console.log('예외 타입 : '+'<%=exception.getClass().getName()%>');
	console.log('예외 메세지 : '+'<%=exception.getMessage()%>');
</script>
</head>
<body>
	<h2>공사중 입니다. 빠른 시일 내로 복구하겠습니다</h2>
	(errorNull.jsp)
</body>
</html>