<%@page import="com.tj.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.book.BookDao"%>
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
<% // listP.jsp -> listP.jsp?pageNum=1 / listP.jsp?pageNum=10
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum = "1";
	int currentPage = Integer.parseInt(pageNum);
	final int PAGESIZE = 3, BLOCKSIZE=5;
	int startRow = (currentPage-1) * PAGESIZE +1;
	int endRow = startRow + PAGESIZE -1;
	BookDao bDao = BookDao.getInstance();
	ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
	out.print("<table>");
	out.print("<tr><th>책ID</th><th>책이름</th><th>표지</th><th>가격</th><th>할인율</th><tr>");
	for(BookDto book : books){%>
		<tr><td><%=book.getBid() %></td>
				<td><%=book.getBtitle() %></td>
				<td><img src="../bookImg/<%=book.getBimage1() %>" width="30"></td>
				<td><%=book.getBprice() %></td>
				<td><%=book.getBdiscount() %></td>
		</tr>
<%} 
	out.print("</table>");
%>
<div class="paging">
<%
	int bookTotCnt = bDao.getBookTotCnt();
	int pageCnt = (int)Math.ceil((double)bookTotCnt/PAGESIZE);
	int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
	int endPage = startPage +BLOCKSIZE -1;
	if(endPage>pageCnt) endPage = pageCnt;
	if(startPage>BLOCKSIZE){ %>
		[ <a href="listP2.jsp?pageNum=<%=startPage-1%>"> 이전 </a> ]
<%}
	for(int i=startPage ; i<=endPage ; i++){
		if(i==currentPage){
			out.print(" [ <b>"+ i + "</b> ] ");
		}else{
			out.print(" [ <a href='listP2.jsp?pageNum="+i+"'>" + i + "</a> ]");
		}
	}
	if(endPage<pageCnt){%>
		[ <a href="listP2.jsp?pageNum=<%=endPage+1 %>"> 다음 </a> ]
<%}%>
</div>
</body>
</html>












