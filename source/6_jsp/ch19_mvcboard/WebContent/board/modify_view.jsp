<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="${conPath }/modify.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="bid" value="${modify_view.bid }">
		<table>
			<caption>${param.bid }번 글수정</caption>
			<tr><th>작성자</th>
					<td><input type="text" name="bname" value="${modify_view.bname }" 
																													required="required"></td>
			</tr>
			<tr><th>제목</th>
					<td><input type="text" name="btitle" value="${modify_view.btitle }"
																													required="required"></td>
			</tr>
			<tr><th>본문</th>
					<td><textarea rows="5" cols="2" name="bcontent">${modify_view.bcontent }</textarea></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="저장" class="btn">
						<input type="reset" value="취소" class="btn">
						<input type="button" value="목록" class="btn" 
									onclick="history.back()">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>














