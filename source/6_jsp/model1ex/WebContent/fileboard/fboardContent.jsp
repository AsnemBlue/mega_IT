<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
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
		width:1000px; margin: 0px auto; height: 550px; 
		text-align: center;
		color: #003300;
		padding-top:50px;
	}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileBoardDao fbDao = FileBoardDao.getInstance();
		fbDao.hitUp(fnum);
		FileBoardDto fbDto = fbDao.getFileBoard(fnum);
	%>
		<table>
			<caption>글 상세보기</caption>
			<tr><th>글번호</th><td><%=fbDto.getFnum() %></td></tr>
			<tr><th>제목</th><td><%=fbDto.getFsubject() %></td></tr>
			<tr><th>작성자</th><td><%=fbDto.getCname() %>
										(<%=fbDto.getCemail()!=null?  fbDto.getCemail() : "등록된 메일 주소 없음"%>)</td></tr>
			<tr><th>첨부파일</th><td><%
						if(fbDto.getFfilename()==null){
							out.print("첨부파일없음");
						}else{
							out.print("<a href='../fileboardUpload/"+fbDto.getFfilename()
														+"' target='_blank'>"+fbDto.getFfilename()+"</a>");
						}
			%></td></tr>
			<tr><th>본문</th><td><pre><%=fbDto.getFcontent() %></pre></td>
			<tr><th>작성일</th><td><%=fbDto.getFrdate() %></td></tr>
			<tr><th>조회수</th><td><%=fbDto.getFhit() %></td></tr>
			<tr><th>ip</th><td><%=fbDto.getFip() %></td></tr>
			<tr><td colspan="2">
					<button onclick="location='fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
					<%String cid = null;
					  CustomerDto customer = (CustomerDto)session.getAttribute("customer");
					  if(customer!=null){
						  cid = customer.getCid();
					  }					
					  if(fbDto.getCid().equals(cid)){%>
						<button 
						onclick="location='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
						수정</button>  
					<%}
					if(session.getAttribute("customer")!=null){ %>
						<button 
						onclick="location='fboardWriteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
						답변</button>  
					<%} %>
					<button 
					onclick="location='fboardDeleteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
					삭제</button>  
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>