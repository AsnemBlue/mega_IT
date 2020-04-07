<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String hiddenParam= request.getParameter("hiddenParam");
	String name       = request.getParameter("name");
	String id     		= request.getParameter("id");
	String pw 				= request.getParameter("pw");
	String birth 			= request.getParameter("birth");
	Timestamp birth2 	= Timestamp.valueOf(request.getParameter("birth")+" 00:00:00");
	String[] hobby 		= request.getParameterValues("hobby");
	String gender 		= request.getParameter("gender");
	String email 			= request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");
%>
	<div id="joinForm_wrap">
		<div id="join_title">회원가입정보</div>
		<h2>hiddenParam : <%=hiddenParam %></h2>
		<h2>name : <%=name %></h2>
		<h2>id : <%=id %></h2>
		<h2>pw : <%
					for(int i=0 ; i< pw.length() ; i++){
						out.print('*');
					}%></h2>
		<h2>birth : <%=birth %></h2>
		<h2>birth2 : <%=birth2 %></h2>
		<h2>hobby : <% 
				if(hobby!=null) {
					for(int i=0 ; i<hobby.length ; i++)
						if(i==hobby.length-1)
							out.print(hobby[i]);
						else
							out.print(hobby[i]+", ");
				}else {
					out.print("없음");
				}
		%></h2>
		<h2>gender : <%=gender %></h2>
		<h2>email : <%=email %></h2>
		<h2>mailSend : <%
				if(mailSend!=null){
					out.print(Arrays.toString(mailSend));
				}else{
					out.print("모두 수신 거부");
				}
		%></h2>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>