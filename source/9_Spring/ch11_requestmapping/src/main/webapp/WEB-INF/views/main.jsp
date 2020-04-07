<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
  <h1>GET방식</h1>
  <form action="${conPath }/student.do" method="get">
  	ID <input type="text" name="id">
  	<input type="submit" value="GET방식으로 전송">
  </form>
  <hr>
  <h1>POST방식</h1>
  <form action="${conPath }/student.do" method="post">
  	ID <input type="text" name="id">
  	<input type="submit" value="POST방식으로 전송">
  </form>
  <hr>
  <h1>redirect, forward 키워드 예제</h1>
  <form action="${conPath }/studentConfirm.do">
  	ID <input type="text" name="id">
  	<input type="submit" value="confirmId">
  </form>
  <a href="${conPath }/fullPath.do">fullPath로 가라</a>
</body>
</html>



















