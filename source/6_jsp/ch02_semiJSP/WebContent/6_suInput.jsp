<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>원하는 구구단 수를 입력하세요</h1> 
	<%-- http://localhost:8181/ch02_semiJSP/6_gugudanOut.jsp?su=0 --%>
	<form action="6_gugudanOut.jsp" method="get">
		<p>단 수 <input type="text" name="su" required="required"></p>
		<p><input type="submit" value="구구단 출력"></p>
	</form>
</body>
</html>








