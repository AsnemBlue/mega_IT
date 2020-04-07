<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int num1, num2; %>
<%	num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		out.println("<h3>num1 = "+num1 + ", num2 = "+num2+"</h3>");
		out.println("<h3>num1 + num2 = "+(num1+num2) +"</h3>");
		out.println("<h3>num1 - num2 = "+(num1-num2) +"</h3>");
		try{
			out.println("<h3>num1 / num2 = "+(num1/num2) +"</h3>");
		}catch(Exception e){
			System.out.println(e.getMessage());
			out.println("<h3>num1 / num2는 불가합니다</h3>");
		}
		out.println("<h3>num1 * num2 = "+(num1*num2) +"</h3>");
		out.println("<h3>DONE</h3>");
%>
</body>
</html>












