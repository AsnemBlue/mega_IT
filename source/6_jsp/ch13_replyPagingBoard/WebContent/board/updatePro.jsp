<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.tj.dto.BoardDto"/>
	<jsp:setProperty name="dto" property="*" />
	<%
		/* pageNum 추가*/
		String pageNum = request.getParameter("pageNum");
		dto.setIp(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.updateBoard(dto);
		if(result==BoardDao.SUCCESS){
	%>	
			<script>
				alert('글 수정 성공');
				location.href = 'list.jsp?pageNum=<%=pageNum%>';
			</script>
	<%}else{ %>
			<script>
				alert('글 수정 실패');
				history.go(-1);
			</script>
	<%}%>
</body>
</html>















