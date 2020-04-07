<%@page import="com.tj.dao.BoardDAO"%>
<%@page import="com.tj.dto.BoardDTO"%>
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
	request.setCharacterEncoding("utf-8"); 
	String pageNum = request.getParameter("pageNum");
%>
<jsp:useBean id="dto" class="com.tj.dto.BoardDTO"></jsp:useBean>
<jsp:setProperty name="dto" property="*" />
<%
	dto.setIp(request.getRemoteAddr());

	BoardDAO bDao = BoardDAO.getInstance();
	int result;
	if(dto.getNum() == 0){
		result = bDao.insertBoard(dto);	// 새글쓰기
	} else {
		result = bDao.reply(dto);		// 답글쓰기
	}
	if(result == BoardDAO.SUCCESS){
		// 글쓰기 성공
	%>
		<script>alert('글쓰기 완료'); 
		location.href='list.jsp?pageNum=<%=pageNum %>'; </script>
	<%
	} else {
		// 글쓰기 실패
		%>
		<script>alert('글쓰기 실패'); history.back(); </script>
		<%
	}
%>
</body>
</html>