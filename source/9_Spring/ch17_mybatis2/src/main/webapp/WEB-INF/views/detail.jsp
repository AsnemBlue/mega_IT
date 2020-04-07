<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/board.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>직원정보</caption>
		<tr><th>사번</th><td>${detail.empno }</td></tr>
		<tr><th>이름</th><td>${detail.ename }</td></tr>
		<tr><th>업무</th><td>${detail.job }</td></tr>
		<tr><th>관리자번호</th><td>${detail.mgr }</td></tr>
		<tr><th>입사일</th><td>${detail.hiredate }</td></tr>
		<tr><th>급여</th><td>${detail.sal }</td></tr>
		<tr><th>상여</th><td>${detail.comm }</td></tr>
		<tr><th>부서번호</th><td>${detail.deptno }</td></tr>
		<tr><td colspan="2" align="center">
			<button onclick="location.href='joinlist.do?pageNum=${param.pageNum}'">목록</button>
			<button onclick="location.href='updateForm.do?empno=${detail.empno }&pageNum=${param.pageNum}'">수정</button>
			<button onclick="location.href='delete.do?empno=${detail.empno }&pageNum=${param.pageNum}'">삭제</button>
		</td></tr>
	</table>
</body>
</html>
