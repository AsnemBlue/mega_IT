<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
	#content_form {
		width: 800px; height:400px;
		margin: 100px auto 0px;
	}
</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content_form">
	<form action="${conPath }/write.do" method="post" enctype="multipart/form-data">
		<table>
			<caption>글쓰기 폼</caption>
			<tr><td>제목</td><td><input type="text" name="fTitle"
							required="required" size="30"></td></tr>
			<tr><td>본문</td><td><textarea name="fContent" rows="3" 
							cols="32"></textarea></td></tr>
			<tr><td>첨부파일</td><td><input type="file" name="filName"></td></tr>
			<tr><td colspan="2">
						<input type="submit" value="글쓰기" class="btn">
						<input type="reset" value="취소" class="btn">
						<input type="button" value="목록" class="btn"
							onclick="location.href='${conPath}/list.do'">
		</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
















