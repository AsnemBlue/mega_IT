<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	Date now = new Date();
	String str = 
	  String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초입니다",now);
	GregorianCalendar now2 = new GregorianCalendar();
	String str2 =
	  String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초입니다",now);
	Calendar now3 = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일은 좋은 날");
	String str3 = sdf.format(now3.getTime());
%>
	<p>str은 <%=str %></p>
	<p>str2은 <%=str2 %></p>
	<p>str3은 <%=str3 %></p>
</body>
</html>



