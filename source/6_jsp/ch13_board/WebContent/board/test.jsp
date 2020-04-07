<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BoardDao"%>
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
	BoardDao bDao = BoardDao.getInstance();
	out.print("<h2>1. DB 글갯수 : "+bDao.getBoardTotalCnt()+"</h2>");
	out.print("<h2>2. 글목록</h2>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for(int idx = 0 ; idx<dtos.size() ; idx++){
		out.println(dtos.get(idx).toString()+"<br>");
	}
	out.println("<h2>3. 글쓰기</h2>");
	BoardDto dto = new BoardDto(0, "글쓴이", "제목", "내용", null, 0, "111", 
			0, 0, 0, "127.0.0.1", null);
	int result = bDao.insertBoard(dto);
	out.println(result==BoardDao.SUCCESS? "글쓰기 성공":"글쓰기 실패");
	out.println("<h2>4. 조회수 올리고 글번호로 dto가져오기</h2>");
	bDao.hitUp(1); // 1번글의 조회수 하나 증가
	dto = bDao.getBoardOneLine("1");
	out.println(dto.toString()+"<br>");
	out.println("<h2>5. 글수정</h2>");
	dto.setWriter("XXXXXXXXX");
	dto.setSubject("xxxxxxxxxx");
	dto.setContent("xxxxxxxxxxxxx");
	dto.setIp("0.0.0.0");
	result = bDao.updateBoard(dto);
	out.println(result==BoardDao.SUCCESS? dto.getNum()+"번글 수정성공":"수정실패");
	out.println("<h2>1번글 삭제 함</h2>");
	result = bDao.deleteBoard(1, "112");
	out.println(result==BoardDao.SUCCESS? "삭제성공<br>":"비번틀려삭제못함<br>");
	result = bDao.deleteBoard(1, "111");
	out.println(result==BoardDao.SUCCESS? "삭제성공<br>":"비번틀려삭제못함<br>");
%>
	<a href="xx.jsp">XX</a>
</body>
</html>














