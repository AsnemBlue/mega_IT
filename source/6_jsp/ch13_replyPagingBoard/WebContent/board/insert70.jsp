<%@page import="com.tj.dao.BoardDao"%>
<%@page import="com.tj.dto.BoardDto"%>
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
	BoardDto dto = new BoardDto();
	BoardDao dao = BoardDao.getInstance();
	for(int i=0 ; i<70 ; i++){
		dto.setWriter("홍길동"+i);
		dto.setSubject("제목입니다"+i);
		dto.setContent("내용입니다"+i);
		dto.setEmail("hong"+i+"@naver.com");
		dto.setPw("111");
		dto.setIp("192.168.20.41");
		dao.insertBoard(dto);
	}
	response.sendRedirect("list.jsp");
%>
</body>
</html>













