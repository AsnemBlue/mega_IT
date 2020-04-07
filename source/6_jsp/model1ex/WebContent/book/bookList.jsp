<%@page import="com.tj.model1ex.dto.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.model1ex.dao.BookDao"%>
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
		width:1000px; margin: 0px auto; height: 500px; 
		text-align: center;
		color: #003300;
		padding-top:100px;
	}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<% // listP.jsp -> listP.jsp?pageNum=1 / listP.jsp?pageNum=10
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3, BLOCKSIZE=5;
		int startRow = (currentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
		out.print("<table><tr>");
		for(BookDto book : books){%>
			<td><a href="bookDetail.jsp?bid=<%=book.getBid() %>&pageNum=<%=pageNum %>">
						<img src="../bookImg/<%=book.getBimage1() %>"><br>
						<%=book.getBtitle() %><br></a>
						<b><del><%=book.getBprice() %></del></b><br>
						<%=book.getBprice()*(100-book.getBdiscount())/100 %>
						(<%=book.getBdiscount() %>할인)
				</td>
	<%} 
		out.print("</tr></table>");
	%>
	<br><br><br><div class="paging">
	<%
		int bookTotCnt = bDao.getBookTotCnt();
		int pageCnt = (int)Math.ceil((double)bookTotCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage +BLOCKSIZE -1;
		if(endPage>pageCnt) endPage = pageCnt;
		if(startPage>BLOCKSIZE){ %>
			[ <a href="bookList.jsp?pageNum=<%=startPage-1%>"> 이전 </a> ]
	<%}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print(" [ <b>"+ i + "</b> ] ");
			}else{
				out.print(" [ <a href='bookList.jsp?pageNum="+i+"'>" + i + "</a> ]");
			}
		}
		if(endPage<pageCnt){%>
			[ <a href="bookList.jsp?pageNum=<%=endPage+1 %>"> 다음 </a> ]
	<%}%>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>