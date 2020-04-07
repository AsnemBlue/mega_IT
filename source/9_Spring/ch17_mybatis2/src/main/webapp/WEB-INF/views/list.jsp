<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/board.css" rel="stylesheet">
<script>
	function trClicked(empno) {
		location.href = 'detail.do?empno=' + empno
				+ '&pageNum=${paging.currentPage}';
	}
</script>
</head>
<body>
	<c:set var="num" value="${paging.total - paging.startRow + 1 }" />
	<table>
		<caption>직원목록</caption>
		<tr>
			<td colspan="6" align="right"><a href="${conPath }/writeForm.do">직원등록</a></td>
		</tr>
		<tr><th>번호</th><th>사번</th><th>이름</th><th>급여</th><th>입사일</th><th>부서번호</th></tr>
		<c:forEach var="emp" items="${list }">
			<tr onclick="trClicked('${emp.empno}')">
				<td>${num }</td>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td><fmt:formatNumber value="${emp.sal}" groupingUsed="true"/></td>
				<td>${emp.hiredate }</td>
				<td>${emp.deptno }</td>
			</tr>
			<c:set var="num" value="${num-1 }" />
		</c:forEach>
	</table>
	<br>
	<br>
	<div class="paging">
		<c:if test="${paging.startPage>paging.blockSize }">
			[ <a href="${conPath }/list.do?pageNum=${paging.startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }"
			end="${paging.endPage }">
			<c:if test="${paging.currentPage==i }">
				[ <b> ${i }</b> ]
			</c:if>
			<c:if test="${paging.currentPage!=i }">
				[ <a href="${conPath }/list.do?pageNum=${i}"> ${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage<paging.pageCnt }">
			[ <a href="${conPath }/list.do?pageNum=${paging.endPage+1}">다음</a> ]
		</c:if>
	</div>
</body>
</html>