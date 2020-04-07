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
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.dto.BoardDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	// pageNum추가
	String pageNum = request.getParameter("pageNum");
	dto.setIp(request.getRemoteAddr());
	BoardDAO bDao = BoardDAO.getInstance();
	int result = bDao.updateBoard(dto);
	if(result == BoardDAO.SUCCESS){
		// 수정 성공
		%>
		<script>
		alert('글 수정 성공');
		location.href="list.jsp?pageNum=<%=pageNum %>";
		</script>
		<%
	} else {
		// 수정 실패
		%>
		<script>
		alert('글 수정 실패');
		history.go(-1);
		</script>
		<%
	}
%>
</body>
</html>