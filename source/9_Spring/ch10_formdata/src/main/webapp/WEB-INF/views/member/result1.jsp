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
  <h1>result1 : 개인정보</h1>
  <h2>이름 : ${name }</h2>
  <h2>ID : ${id }</h2>
  <h2>PW : ${pw }</h2>
  <h2>나이 : ${age }</h2>
  <h2>메일 : ${email }</h2>
  <h2>주소 : ${address }</h2>
  <button onclick="history.back()">뒤로가기</button>
  <button onclick="location.href='${conPath}/'">처음부터 다시 시작하기</button>
</body>
</html>










