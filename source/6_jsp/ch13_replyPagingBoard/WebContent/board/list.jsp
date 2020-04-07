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
	<%/* paging 처리를 위한 starRow, endRow 계산 
				list.jsp -> list.jsp?pageNum=1   list.jsp?pageNum=20*/ 
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);		// 현재 페이지 수
		final int PAGESIZE=10, BLOCKSIZE=10;
		// startRow = (페이지번호 - 1) * 페이지당 갯수+ 1
		int startRow = (currentPage-1) * PAGESIZE + 1;
		// endRow = 시작번호(startRow) + 페이지당갯수 - 1
		int endRow = startRow + PAGESIZE -1; 
		BoardDao bDao = BoardDao.getInstance();
		int totCnt = bDao.getBoardTotalCnt();// 전체 글갯수
		if(totCnt==0){
			out.print("<tr><td colspan='7'>등록된 글이 없습니다</td></tr>");
		}else{
			ArrayList<BoardDto> dtos = bDao.listBoard(startRow, endRow);// startRow부터 endRow까지
			for(BoardDto dto : dtos){
				// 글번호, 작성자
				out.println("<tr><td>"+dto.getNum()+"</td><td>"+dto.getWriter()+"</td>");
			  // 제목
				out.println("<td class='left'>");
				// 답변글일 경우 = 들여쓰기 + re.gif 출력
				if(dto.getRe_level()>0){
					int width = dto.getRe_level() * 20;
					out.print("<img src='../img/level.gif' width='"+width+"' height='10'>");
					out.print("<img src='../img/re.gif'>");
				}
				if(dto.getHit()>10){
					out.println("<img src='../img/hot.gif'>");
				}
				out.print("<a href='content.jsp?num="+dto.getNum()+"&pageNum="+pageNum+"'>"+dto.getSubject()+"</a></td>");
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
	<div class="paging">
			<%
				int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 전체 페이지 수
				// startPage = ((현재페이지 -1)/블록사이즈)*블록사이즈 +1
				int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
				// endPage = 시작페이지 + 블록사이즈 수 -1
				int endPage = startPage + BLOCKSIZE -1 ;
				if(endPage>pageCnt){
					endPage = pageCnt;
				}
				if(startPage>BLOCKSIZE){
					out.print(" [<a href='list.jsp?pageNum="+(startPage-1)+"'>이전</a>] ");
				}
				for(int i=startPage ; i<=endPage ; i++){
					if(i==currentPage){
						out.print(" [<b>"+i+"</b>] "); //현재페이지인 경우
					}else{//현재페이지가 아닌 경우 해당 수를 클릭하면 해당 페이지로 넘어감
						out.print(" [<a href='list.jsp?pageNum="+i+"'>"+i+"</a>] ");
					}
				}
				if(endPage<pageCnt){
					out.print(" [<a href='list.jsp?pageNum="+(endPage+1)+"'>다음</a>] ");
				}
			%>
	</div>
</body>
</html>










