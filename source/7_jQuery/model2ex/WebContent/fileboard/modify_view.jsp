<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
	<form action="${conPath }/boradModify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="fId" value="${modify_view.fId }">
		<input type="hidden" name="dbFileName" value="${modify_view.fFileName }">
		<table>
			<caption>${modify_view.fId }번 글 수정(page:${param.pageNum })</caption>
			<tr><th>작성자</th>
					<td><input type="text" required="required" size="30"
								value="${modify_view.mName }(${modify_view.mId })" readonly="readonly"></td>
			</tr>
			<tr><th>제목</th>
					<td><input type="text" name="fTitle" required="required" size="30"
								value="${modify_view.fTitle }"></td>
			</tr>
			<tr><th>본문</th>
					<td><textarea rows="5" cols="32" 
							name="fContent">${modify_view.fContent }</textarea></td>
			</tr>
			<tr><th>첨부파일</th>
					<td><input type="file" name="fFileName" class="btn"> 원첨부파일:
							<c:if test="${not empty modify_view.fFileName }">
						 		<a href="${conPath }/fileboardUp/${modify_view.fFileName}" target="_blank">${modify_view.fFileName}</a>
						 	</c:if>
						 	<c:if test="${empty modify_view.fFileName }">
						 		첨부파일없음
						 	</c:if>
					</td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="수정" class="btn">
						<input type="button" value="목록"  class="btn"
							onclick="location='${conPath}/list.do?pageNum=${param.pageNum }'">
						<input type="reset" value="취소" class="btn"
						  onclick="history.back()">
					</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>