<%@page import="com.tj.ch14.dto.BoardDto"%>
<%@page import="com.tj.ch14.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
<body>
  <%
  	BoardDao bDao = BoardDao.getInstance();
  	BoardDto bDto = new BoardDto();
  	for(int i=0 ; i<55 ; i++){
  		bDto.setBname("홍길동"+i);
  		bDto.setBtitle("제목"+i);
  		bDto.setBcontent("본문 내용"+i);
  		bDto.setBip("192.168.20.31");
  		int result = bDao.write(bDto);
  		System.out.println(result == BoardDao.SUCCESS? i+"번째 성공":i+"번째 실패");
  	}
  	String conPath = request.getContextPath();
  	response.sendRedirect(conPath+"/list.do");
  %>
</body>
</html>


















