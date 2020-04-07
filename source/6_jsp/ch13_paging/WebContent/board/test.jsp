<%@page import="com.tj.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
	BoardDAO mDao = BoardDAO.getInstance();
	out.println("<h2>1. DB 글갯수 :"+mDao.getBoardTotalCnt()+" </h2>");
	out.println("<h2>2. 글 목록  </h2>");
	ArrayList<BoardDTO> dtos = mDao.listBoard();
	for(int i=0; i <dtos.size(); i++){
		out.println(dtos.get(i).toString()+"<br>");
	}
	
	out.println("<h2>3. 글 쓰기  </h2>");
	BoardDTO dto = new BoardDTO(0, "글쓴이", "제목", "내용", null, 0, "111",0, 0, 0, "127.0.0.1", null);
	int result = mDao.insertBoard(dto);
	if(result == BoardDAO.SUCCESS){
		out.println("글쓰기 성공<br>");
	} else {
		out.println("글쓰기 실패<br>");
	}
	
	out.println("<h2>4. 글 번호로 dto가져오기  </h2>");
	mDao.hitUp(3);
	dto = mDao.getBoardOneLine(3);
	out.println(dto.toString()+"<br>");
	
	out.println("<h2>5. 글 수정  </h2>");
	dto.setWriter("xxxxxxxxxx");
	dto.setSubject("xxxxxx");
	dto.setContent("xxxxxxxxxxxxxxxx");
	dto.setIp("0.0.0.0");
	result = mDao.updateBoard(dto);
	out.println(result == BoardDAO.SUCCESS ? "수정성공" : "수정실패");
	
	out.println("<h2>6. 글 삭제  </h2>");
	result = mDao.deleteBoard(3, "112");
	out.println(result == BoardDAO.SUCCESS ? "삭제성공<br>" : "삭제실패<br>");
	
	result = mDao.deleteBoard(3, "111");
	out.println(result == BoardDAO.SUCCESS ? "삭제성공<br>" : "삭제실패<br>");
	
	
%>
<a href="xx.jsp">xx</a>
</body>
</html>