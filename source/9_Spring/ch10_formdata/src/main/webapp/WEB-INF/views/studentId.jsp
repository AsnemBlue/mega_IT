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
  <h1>ModelAttribute를 통해 cnt, list</h1>
  <h2>cnt : ${cnt }</h2>
  <h2>list : ${list }</h2>
  <hr>
  <h1>요청경로로 전달 받은 값</h1>
  <h2>ID : ${id }</h2>  
  <h2>PW : ${pw }</h2>
</body>
</html>
















