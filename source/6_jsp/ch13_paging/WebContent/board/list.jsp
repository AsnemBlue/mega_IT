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
 <table>
 	<caption>게시판</caption>
 	<tr>
 		<td><a href="wirteForm.jsp">글쓰기</a></td>
 	</tr>
 </table>
 <table>
 	<tr>
 		<th>글번호</th><th>작성자</th><th>제목</th><th>메일</th><th>IP</th><th>작성일</th><th>조회수</th>
 	</tr>
 	<%
 		/** paging  처리를 위한 startRow, endRow 계산 
	 		list.jsp -> list.jsp?pageNum=1, list.jsp?pageNum=20
 		*/
 		String pageNum = request.getParameter("pageNum");
	 	if(pageNum == null) pageNum = "1";
	 	int currentPage = Integer.parseInt(pageNum);
 	 	// PAGESIZE = 한 페이지당 글 수 :10개 , BLOCKSIZE = 블록당 페이지수 : 10개
	 	final int PAGESIZE = 10, BLOCKSIZE = 10;
	 	
	 	// startRow = (페이지번호 -1) * 페이지당 갯수 +1
	 	int startRow = (currentPage -1) * PAGESIZE +1;
	 	// endRow = startRow + 페이지당 갯수 +1
	 	int endRow = startRow + PAGESIZE -1;
 		
 		BoardDAO bDao = BoardDAO.getInstance();
 		int totCnt = bDao.getBoardTotalCnt();	// 전체 글 갯수
 		ArrayList<BoardDTO> dtos = null;
 		
 		if(totCnt == 0) {
 			out.println("<tr><td colspan='7'>등록된 글이 없습니다.</td></tr>");
 		} else {
 			//dtos = bDao.listBoard();
 			dtos = bDao.listBoard(startRow, endRow);
	 		for(BoardDTO d : dtos){ // 글번호, 작성, 제목, 메일, ip, 작성일, 조회수
	 			out.println("<tr><td>"+d.getNum() + "</td><td>" + d.getWriter() + "</td>" );
	 			out.println("<td class='left'>");
	 			// 답변글 들여쓰기 + re.git 출력
	 			if(d.getRe_level() > 0) {
	 				int width = d.getRe_level() * 10;
	 				out.println("<img src='../img/level.gif' width='"+ width + "' height='10' />");
	 				out.println("<img src='../img/re.gif' />");
	 			}
	 			
	 			if(d.getHit()>10){
	 				// hit수가 10개 이상일때
	 				out.println("<img src='../img/hot.gif'>");
	 			}
	 			
	 			out.println("<a href='content.jsp?num="+d.getNum()+"&pageNum="+pageNum+"'>"+d.getSubject()+"</a></td>");
	 			out.println("<td>"+(d.getEmail()!=null? d.getEmail() : "-")+"</td>");
	 			out.println("<td>"+d.getIp()+"</td>");
	 			out.println("<td>"+d.getrDate()+"</td>");
	 			out.println("<td>"+d.getHit()+"</td></tr>");
	 		}
 		}
 		
 	%>
 </table>
 
 <div class="paging">
 <%
 	int pageCnt = (int)Math.ceil((double)totCnt / PAGESIZE);	//  전체 패이지수
 	
	// startPage(시작페이지) = ((현재페이지 -1) / 블록사이즈 ) * 블록사이즈 +1
	int startPage = ((currentPage-1) / BLOCKSIZE) * BLOCKSIZE +1;
	// endPage(끝페이지) = 시작페이지 + 블록사이즈 수 -1
	int endPage = startPage + BLOCKSIZE -1;
	
	if(endPage > pageCnt){
		endPage = pageCnt;
	}
	
	if(startPage > BLOCKSIZE){
		out.print(" [<a href='list.jsp?pageNum=" + (startPage-1)+"'> 이전 </a>] ");
	}
	
	for(int i = startPage; i <=endPage; i++){
		if(i == currentPage){
			// 현재 페이지인경우 링크를 나타내지 않는다.
			out.print(" [<b> "+i+" </b>] ");
		} else {
			out.print(" [<a href='list.jsp?pageNum=" + i +"'> "+ i + " </a>] ");
		}
	}
	
	if(endPage < pageCnt){
		out.print(" [<a href='list.jsp?pageNum=" + (endPage+1)+"'> 다음 </a>] ");
	}
 %>
 
 </div>
</body>
</html>


























