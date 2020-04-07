<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/style.css" rel="stylesheet">
<style>
	#content_form{
		width:1000px; margin: 0px auto; height: 500px; 
		text-align: center;
		color: #003300;
		padding-top:100px;
	}
	#content_form input {height: 20px; padding:3px; margin: 10px 0;}
	#content_form .btn {height: 50px; padding:3px; margin: 5px 0;}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<%
		String pageNum=request.getParameter("pageNum");
		String fnum = request.getParameter("fnum"); 
	%>
	<table>
		<caption><%=fnum %>번글 삭제</caption>
		<tr><td>
			<fieldset>
				<legend>삭제하기 위한 암호 입력</legend>
				<form action="fboardDeletePro.jsp" method="post">
					<input type="hidden" name="pageNum" value="<%=pageNum %>">
					<input type="hidden" name="fnum" value="<%=fnum %>">
					<p>암호 <input type="password" name="fpw" required="required" class="btn"></p>
					<p><input type="submit" value="삭제" class="btn">
						 <input type="reset" value="삭제취소" onclick="history.go(-1)" class="btn"></p>
				</form>
			</fieldset>
		</td></tr>
	</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>