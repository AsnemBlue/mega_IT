<%@page import="com.tj.dao.BoardDao"%>
<%@page import="com.tj.dto.BoardDto"%>
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
	int num =0 , ref=0, re_step=0, re_level=0;
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum="1";
	BoardDto dto = new BoardDto(); // 답변글을 위해 들어왔다면 dto에 원글에 대한 정보
	// 답변글을 쓰려고 온 경우 dto에 원글에 대한 정보로
	if(request.getParameter("num")!=null){
		num = Integer.parseInt(request.getParameter("num"));
		BoardDao bDao = BoardDao.getInstance();
		dto = bDao.getBoardOneLine(num);
		ref=dto.getRef();
		re_step=dto.getRe_step();
		re_level = dto.getRe_level();
	}
%>
	<form action="writePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="num" value="<%=num %>">
		<input type="hidden" name="ref" value="<%=ref%>">
		<input type="hidden" name="re_step" value="<%=re_step %>">
		<input type="hidden" name="re_level" value="<%=re_level %>">
		<table>
			<caption>게시판 글쓰기</caption>
			<tr><th>작성자</th>
					<td><input type="text" name="writer" required="required" autofocus="autofocus"></td>
			</tr>
			<tr><th>제목</th>
					<td><input type="text" name="subject" required="required" value="<%
						if(num!=0){
							out.print("[답]"+dto.getSubject().substring(0, 1));
						}
					%>"></td>
			</tr>
			<tr><th>메일</th>
					<td><input type="email" name="email"></td>
			</tr>
			<tr><th>본문</th>
					<td><textarea rows="5" cols="5" name="content"></textarea></td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="글쓰기" class="btn">
						<input type="reset" value="다시쓰기" class="btn">
						<input type="button" value="목록" class="btn"
											onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
					</td>
			</tr> 
		</table>
	</form>
</body>
</html>

















