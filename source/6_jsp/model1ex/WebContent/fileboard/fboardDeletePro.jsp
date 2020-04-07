<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
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
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	String fpw = request.getParameter("fpw");
	FileBoardDao fbDao = FileBoardDao.getInstance();
	int result = fbDao.deleteFileBoard(fnum, fpw);
	if(result==FileBoardDao.SUCCESS){
%>
		<script>
			alert('<%=fnum%>번 글 삭제성공');
			location.href = 'fboardList.jsp?pageNum=<%=pageNum%>';
		</script>		
<%}else{%>
		<script>
			alert('<%=fnum%>번 글 삭제실패. 비밀번호 확인하세요');
			history.go(-1);
		</script>	
<%}%>
</body>
</html>