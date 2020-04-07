<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
<%Enumeration<String> sAttNames = session.getAttributeNames();
	int cnt = 0;
	while(sAttNames.hasMoreElements()){
		cnt++;
		String sname = sAttNames.nextElement();
		String svalue = session.getAttribute(sname).toString();
		out.println(sname+"(세션명) : "+svalue+"(세션값)<br>");
	}
	if(cnt==0){
		out.println("유효한 세션이 없습니다");
	}
%>
	<button onclick="history.back();">이전페이지</button>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
</body>
</html>













