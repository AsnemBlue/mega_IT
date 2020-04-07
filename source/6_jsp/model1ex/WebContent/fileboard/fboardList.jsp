<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
	#content_form{
		width:1000px; margin: 0px auto; height: 570px; 
		text-align: center;
		color: #003300;
		padding-top:30px;
	}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table>
			<tr><td colspan="7"> 
					<%if(session.getAttribute("customer")!=null){%>
						<a href="fboardWriteForm.jsp">글쓰기</a>
					<%} %>
				</td>
			</tr>
			<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>IP</th><th>작성일</th><th>조회수</th></tr>
			<%
				String pageNum = request.getParameter("pageNum");
				if(pageNum==null) pageNum = "1";
				int currentPage = Integer.parseInt(pageNum);
				final int PAGESIZE=10, BLOCKSIZE=10;
				int startRow = (currentPage-1) * PAGESIZE + 1;
				int endRow   = startRow + PAGESIZE - 1;
				FileBoardDao fbDao = FileBoardDao.getInstance();
				ArrayList<FileBoardDto> dtos = fbDao.listFileBoard(startRow, endRow);
				if(dtos.size()==0){
					out.print("<tr><td colspan='7'>등록된 글이 없습니다.</td></tr>");
				}else{
					for(FileBoardDto d : dtos){
						out.print("<tr><td>"+d.getFnum()+"</td>");
						out.print("<td>"+d.getCname()+"</td>");
						out.print("<td class='left'>");
						if(d.getFre_level()>0){
							int width = d.getFre_level()*20;
							out.print("<img src='../img/level.gif' width='"+width+"' height='10'>");
							out.print("<img src='../img/re.gif'>");
						}
						if(d.getFhit()>10){
							out.print("<img src='../img/hot.gif'>");
						}
						out.print("<a href='fboardContent.jsp?fnum="+d.getFnum()+"&pageNum="+pageNum+
																					"'>"+d.getFsubject()+"</a> ");
						if(d.getFfilename()!=null){
							out.print("<img src='../img/fileup.jpg' width='10'></td>");
						}
						out.print("<td>"+(d.getCemail()!=null? d.getCemail():"-")+"</td>");
						out.print("<td>"+d.getFip()+"</td>");
						out.print("<td>"+d.getFrdate()+"</td>");
						out.print("<td>"+d.getFhit()+"</td>");
					}
				}
			%>
		</table><br>
		<div class="paging">
	<%
		int totCnt = fbDao.getFileBoardTotCnt();
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage +BLOCKSIZE -1;
		if(endPage>pageCnt) endPage = pageCnt;
		if(startPage>BLOCKSIZE){ %>
			[ <a href="fboardList.jsp?pageNum=<%=startPage-1%>"> 이전 </a> ]
	<%}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print(" [ <b>"+ i + "</b> ] ");
			}else{
				out.print(" [ <a href='fboardList.jsp?pageNum="+i+"'>" + i + "</a> ]");
			}
		}
		if(endPage<pageCnt){%>
			[ <a href="fboardList.jsp?pageNum=<%=endPage+1 %>"> 다음 </a> ]
	<%}%>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>