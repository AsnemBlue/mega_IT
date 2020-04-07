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
	<table>
		<caption>게시판</caption>
		<tr><td><a href="writeForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>제목</th><th>메일</th>
				<th>IP</th><th>작성일</th><th>조회수</th>
		</tr>
	<%
		BoardDao bDao = BoardDao.getInstance();
		int totCnt = bDao.getBoardTotalCnt();
		if(totCnt==0){
			out.print("<tr><td colspan='7'>등록된 글이 없습니다</td></tr>");
		}else{
			ArrayList<BoardDto> dtos = bDao.listBoard();
			for(BoardDto dto : dtos){
				// 글번호, 작성자
				out.println("<tr><td>"+dto.getNum()+"</td><td>"+dto.getWriter()+"</td>");
			  // 제목
				out.println("<td class='left'>");
				if(dto.getHit()>10){
					out.println("<img src='../img/hot.gif'>");
				}
				out.print("<a href='content.jsp?num="+dto.getNum()+"'>"+dto.getSubject()+"</a></td>");
				// 메일
				out.print("<td>"+(dto.getEmail()!=null? dto.getEmail():"-")+"</td>");
				//ip, 작성일
				out.print("<td>"+dto.getIp()+"</td><td>"+dto.getrDate()+"</td>");
				//조회수
				out.print("<td>"+dto.getHit()+"</td></tr>");
			}
		}
	%>
	</table>
</body>
</html>