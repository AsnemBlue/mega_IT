<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // http://localhost:8181/ch02_semiJSP/6_gugudanOut.jsp
		int su = Integer.parseInt(request.getParameter("su"));
	%>
	<h1><%=su %>단 구구단</h1>
	<%for(int i=1 ; i<=9 ; i++){ %>
		<p> <%=su %> * <%=i %> = <%=su*i %></p>
	<%} %>
</body>
</html>






