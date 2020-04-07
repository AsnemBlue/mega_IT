<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int su = Integer.parseInt(request.getParameter("su"));
	int sum = 0;
	for(int i=1 ; i<=su ; i++){
		sum += i;
	}
	request.setAttribute("sum", sum);
%>
	<jsp:forward page="ex03_suView.jsp"/>
</body>
</html>









