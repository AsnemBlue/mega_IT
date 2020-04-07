<%@page import="com.tj.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" >
</head>
<body>
<%
	String pageNum = request.getParameter("pageNum");
	int num = Integer.parseInt(request.getParameter("num"));
	String pw = request.getParameter("pw");
	BoardDAO bDao = BoardDAO.getInstance();
	int result = bDao.deleteBoard(num, pw);
	if(result == BoardDAO.SUCCESS){
		// 삭제 성공
		%>
		<script>
		alert('<%=num %>번글 삭제 성공');
		location.href="list.jsp?pageNum=<%=pageNum %>";
		</script>
		<%
	} else {
		// 삭제 실패
		%>
		<script>
		alert('<%=num %>번글 삭제 실패 비밀번호를 확인하세요.');
		history.go(-1);
		</script>
		<%
	}
%>
</body>
</html>