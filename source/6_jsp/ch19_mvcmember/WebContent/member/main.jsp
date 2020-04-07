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
	<c:if test="${not empty errorMsg }">
		<script>
			alert('${errorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${empty member }"> <!-- 로그인 전 화면 -->
		<h2>로그인 상태가 아닙니다</h2>
		<br><hr><br>
		<button onclick="location.href='${conPath}/loginView.do'">로그인</button>
		<button onclick="location.href='${conPath}/joinView.do'">회원가입</button>
		<button onclick="location.href='${conPath}/allView.do'">전체회원보기</button>
	</c:if>
	<c:if test="${not empty member }"><!-- 로그인 후 화면 -->
		<h2>${member.mName }(${member.mId })님 어서오세요</h2>
		<br><hr><br>
		<button onclick="location.href='${conPath}/modifyView.do'">정보수정</button>
		<button onclick="location.href='${conPath}/logout.do'">로그아웃</button>
		<button onclick="location.href='${conPath}/allView.do'">전체회원보기</button>
	</c:if>
</body>
</html>













