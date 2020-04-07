<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="x.jsp">없는 파일 클릭하면 400에러</a>
<% 
	//String nullstr = request.getParameter("xx").toUpperCase(); // NullPointerException
	//Integer.parseInt(request.getParameter("xx")); //NumberFormatException
	int[] arr = {10,20,30};
	for(int idx=0 ; idx<=arr.length ; idx++){
		out.print(arr[idx]);
	}
%>
</body>
</html>









