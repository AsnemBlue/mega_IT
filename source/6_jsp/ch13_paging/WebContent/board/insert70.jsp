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
	// 임의로 데이터 채우기
	BoardDTO dto = new BoardDTO();
	BoardDAO dao = BoardDAO.getInstance();
	
	for(int i = 0; i<70; i++){
		dto.setWriter("홍길동"+i);
		dto.setSubject("제목"+i);
		dto.setContent("내용입니다." + i);
		dto.setEmail("hong"+i+"@naver.com");
		dto.setPw("111");
		dto.setIp("192.168.20.59");
		dao.insertBoard(dto);
	}
	
	response.sendRedirect("list.jsp");
%>
</body>
</html>