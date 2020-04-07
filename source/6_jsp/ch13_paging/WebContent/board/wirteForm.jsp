<%@page import="com.tj.dao.BoardDAO"%>
<%@page import="com.tj.dto.BoardDTO"%>
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
	int num = 0, ref = 0, re_step = 0, re_level =0;
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
	}
	
	BoardDTO dto = new BoardDTO();		// 답변글을 위해 들어왔다면 dto에 원글에 대한 정보를 저장
	
	if(request.getParameter("num")!= null) {
		// 답변글을 쓰려고 한경우 dto에 원글에 대한 정보를 넣는다.
		num = Integer.parseInt(request.getParameter("num"));
		BoardDAO bDao = BoardDAO.getInstance();
		dto = bDao.getBoardOneLine(num);
		ref = dto.getRef();
		re_step = dto.getRe_step();
		re_level = dto.getRe_level();
		
		System.out.println("writeForm.jsp - ref : " + ref);
		System.out.println("writeForm.jsp - re_step : " + re_step);
		System.out.println("writeForm.jsp - re_level : " + re_level);
	}
%>
<form action="writePro.jsp" method="post">
	<input type="text" name="pageNum" value="<%=pageNum %>" />
	<input type="text" name="num" value="<%=num %>" />
	<input type="text" name="ref" value="<%=ref %>" />
	<input type="text" name="ref_step" value="<%=re_step %>" />
	<input type="text" name="re_level" value="<%=re_level %>" />
	<table>
		<caption>게시판 글쓰기</caption>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" required="required" autofocus="autofocus" /></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="subject" required="required" value="<%
				if (dto.getSubject()!=null){
					out.print("re :" + dto.getSubject());
				}
			%>" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="email" /></td>
		</tr>
		<tr>
			<th>본문</th>
			<td><textarea name="content" cols="5" rows="10"></textarea></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" required="required" /></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="글쓰기" class="btn" />
			<input type="reset" value="다시쓰기" class="btn" />
			<input type="button" value="글목록보기" class="btn" onclick="location.href='list.jsp?pageNum=<%=pageNum %>'" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>