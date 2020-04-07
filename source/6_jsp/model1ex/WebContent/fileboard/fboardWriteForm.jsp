<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
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
		width:1000px; margin: 0px auto; height: 550px; 
		text-align: center;
		color: #003300;
		padding-top:50px;
	}
	#content_form input {height: 20px; padding:3px; margin: 10px 0;}
	#content_form .btn {height: 50px; padding:3px; margin: 5px 0;}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
			if(session.getAttribute("customer")==null){
				response.sendRedirect("../customer/login.jsp");
			}
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null) pageNum = "1";
			int fnum = 0; // 글번호를 0으로 초기화
			FileBoardDto fbDto = new FileBoardDto(); // 빈dto객체(fnum, fref, fre_step, fre_level은 0)
			if(request.getParameter("fnum")!=null){ // 답글 쓰러 왔구먼.
				fnum = Integer.parseInt(request.getParameter("fnum"));
				FileBoardDao fbDao = FileBoardDao.getInstance();
				fbDto = fbDao.getFileBoard(fnum); //원글에 대한 정보 (ref, ref_step, ref_level 필요)
			}
		%>
		<form action="fboardWritePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum%>">
			<input type="hidden" name="fnum" value="<%=fnum%>">
			<input type="hidden" name="fref" value="<%=fbDto.getFref()%>">
			<input type="hidden" name="fre_step" value="<%=fbDto.getFre_step()%>">
			<input type="hidden" name="fre_level" value="<%=fbDto.getFre_level()%>">
			<table>
				<caption><%=fnum==0? "글쓰기":"답변 글쓰기" %></caption>
				<tr><th>제목</th>
						<td><input type="text" name="fsubject" required="required" autofocus="autofocus"></td>
				</tr>
				<tr><th>첨부파일</th><td><input type="file" name="ffilename"></td></tr>
				<tr><th>본문</th><td><textarea rows="5" cols="2" name="fcontent"></textarea></td></tr>
				<tr><th>삭제비번</th><td><input type="password" name="fpw" required="required"></td></tr>
				<tr><td colspan="2">
							<input type="submit" value="글쓰기" class="btn">
							<input type="reset" value="다시쓰기" class="btn">
							<input type="button" value="목록" onclick="location='fboardList.jsp?pageNum=<%=pageNum%>'" class="btn">
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>