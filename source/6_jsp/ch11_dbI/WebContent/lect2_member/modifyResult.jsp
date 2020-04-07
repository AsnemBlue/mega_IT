<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<%
	if(request.getParameter("result").equals("success")){
		out.println("<h2>회원정보 수정이 완료되었습니다</h2>");
	}else{
		out.println("<h2>회원정보 수정이 실패되었습니다</h2>");		
	}
%>
	<button onclick="history.go(-1)">이전페이지</button>
	<button onclick="location.href='modify2.jsp'">정보수정</button>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
</body>
</html>














