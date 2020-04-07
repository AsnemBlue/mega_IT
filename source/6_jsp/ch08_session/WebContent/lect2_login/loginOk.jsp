<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String msg = "";
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id!=null && id.equals("aaa")){ // 유효한 id를 입력한 경우
		if(pw!=null & pw.equals("111")){ // pw가 맞은 경우
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
			response.sendRedirect("welcome.jsp");
		}else{ // pw가 틀린 경우
			msg = URLEncoder.encode("pw를 체크하세요","utf-8");
			response.sendRedirect("login.jsp?msg="+msg);
		}
	}else{ // 유효하지 않는 id를 입력한 경우
		msg = URLEncoder.encode("id를 체크하세요","utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
	}	
%>	
</body>
</html>











