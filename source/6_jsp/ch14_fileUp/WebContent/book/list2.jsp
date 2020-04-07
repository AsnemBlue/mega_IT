<%@page import="java.util.ArrayList, com.tj.book.BookDto"%>
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
	<table><tr>
	<%
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook();
		for(int i=0 ; i<books.size() ; i++){%>
			<td><img src="../bookImg/<%=books.get(i).getBimage1() %>"><br>
					<%=books.get(i).getBtitle() %><br>
					<b><del><%=books.get(i).getBprice() %></del></b><br>
					<%=books.get(i).getBprice()*(100-books.get(i).getBdiscount())/100 %>
					(<%=books.get(i).getBdiscount() %>할인)
			</td>
			<%if(i%3 == 2) out.print("</tr><tr>");%>
	<%}%>
	</tr></table>
</body>
</html>













