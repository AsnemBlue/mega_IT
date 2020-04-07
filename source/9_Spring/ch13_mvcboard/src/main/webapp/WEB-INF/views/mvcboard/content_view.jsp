<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet">
  <style></style>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
<body>
  <table>
  	<caption>${dto.bid }번 글 상세보기</caption>
  	<tr><th>작성자</th><td>${dto.bname }</td></tr>
  	<tr><th>제 목</th><td>${dto.btitle }</td></tr>
  	<tr><th>본 문</th><td><pre>${dto.bcontent }</pre></td></tr>
  	<tr><th>작성일</th><td><fmt:formatDate value="${dto.bdate }" pattern="MM/dd(E)"/>
  	<tr><th>조회수</th><td>${dto.bhit }</td></tr>
  	<tr><th>ip</th><td>${dto.bip }</td></tr>
  	<tr><td colspan="2">
  				<button onclick="location='${conPath}/modify_view.do?bid=${bid }&pageNum=${param.pageNum }'">수정</button>
  				<button onclick="location='${conPath}/delete.do?bid=${bid }&pageNum=${param.pageNum }'">삭제</button>
  				<button onclick="location='${conPath}/reply_view.do?bid=${bid }&pageNum=${param.pageNum }'">답변</button>
  				<button onclick="location='${conPath}/list.do?pageNum=${param.pageNum }'">목록</button>
  	</td></tr>
  </table>
</body>
</html>














