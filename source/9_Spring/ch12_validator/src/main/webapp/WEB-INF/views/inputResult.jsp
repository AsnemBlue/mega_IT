<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <h1>검증이 완료된 결과 페이지입니다</h1>
  <h2> 이름 : ${student.name }</h2>
  <h2> ID : ${student.id }</h2>
  <button onclick="location.href='${conPath}/inputForm.do'">다시</button>
  <button onclick="history.back()">이전</button>
</body>
</html>












