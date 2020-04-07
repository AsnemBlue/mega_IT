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
  <!-- 넘어온 파라미터 : bid, pageNum -->
  <!-- model에 add된 것 : dto(원글에 대한 dto), bid -->
  <form action="${conPath }/reply.do" method="post">
  	<input type="hidden" name="pageNum" value="${param.pageNum }">
  	<input type="hidden" name="bgroup" value="${dto.bgroup }">
  	<input type="hidden" name="bstep" value="${dto.bstep }">
  	<input type="hidden" name="bindent" value="${dto.bindent }">
  	<table>
  		<tr><th>작성자</th><td><input type="text" name="bname" required="required"></td></tr>
  		<tr><th>제 목</th><td><input type="text" name="btitle" value="[답]${dto.btitle.substring(0,1) }"
  								 required="required"></td></tr>
  		<tr><th>본 문</th><td><textarea rows="5" cols="32" name="bcontent"></textarea></td></tr>
  		<tr><td colspan="2">
  					<input type="submit" value="답글저장" class="btn">
  					<input type="reset" value="취소" class="btn">
  					<input type="button" value="이전" onclick="history.go(-1);" class="btn">
  					<input type="button" value="목록" class="btn"
  							onclick="location.href='${conPath}/list.do?pageNum=${param.pageNum }'">
  		</td></tr>
  	</table>
  </form>
</body>
</html>









