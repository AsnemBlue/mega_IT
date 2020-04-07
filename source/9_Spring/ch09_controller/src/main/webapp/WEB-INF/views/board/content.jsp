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
  <h2>board의 content.jsp입니다</h2>
  <h2>ID : ${id }</h2>
  <h2>PW : ${pw }</h2>
  <h2>memeber의 id ${member.id }</h2>
  <h2>member의  pw ${member.pw }</h2>
  <hr>
  <h2><span onclick="history.back()">뒤로가기(메인페이지로)</span></h2>
</body>
</html>










