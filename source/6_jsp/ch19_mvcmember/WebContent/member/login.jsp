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
	<c:if test="${not empty errorMsg}">
		<script>
			alert('${errorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty joinResult }">
		<script>
			alert('${joinResult}');
		</script>
	</c:if>
	<form action="${conPath }/login.do" method="post">
		<table>
			<tr><th>ID</th><td><input type="text" name="mId" value="${mId }" required="required"></td></tr>
			<tr><th>PW</th><td><input type="password" name="mPw" required="required"></td></tr>
			<tr><td colspan="2">
						<input type="submit" value="로그인">
						<input type="button" value="회원가입"
									onclick="location.href='${conPath}/joinView.do'">
		</table>
	</form>
</body>
</html>
















