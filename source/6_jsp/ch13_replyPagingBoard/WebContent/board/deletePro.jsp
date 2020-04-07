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
<%String pageNum = request.getParameter("pageNum");
	int num = Integer.parseInt(request.getParameter("num"));
	String pw = request.getParameter("pw");
	BoardDao bDao = BoardDao.getInstance();
	int result = bDao.deleteBoard(num, pw);
	if(result==BoardDao.SUCCESS){
%>
		<script>
			alert('<%=num%>번 글 삭제성공');
			location.href = 'list.jsp?pageNum=<%=pageNum%>';
		</script>		
<%}else{%>
		<script>
			alert('<%=num%>번 글 삭제실패. 비밀번호 확인하세요');
			history.go(-1);
		</script>	
<%}%>
</body>
</html>
















