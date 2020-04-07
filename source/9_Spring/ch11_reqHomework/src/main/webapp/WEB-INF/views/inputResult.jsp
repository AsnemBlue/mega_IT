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
</head>
<body>
  <div id="wrap">
		<span class="currentCnt">"현재 총 ${currentCnt }명"</span>
	  <table>
	  	<caption>결과는 다음과 같습니다</caption>
	  	<tr><th>이름 : </th><td>${student.name }</td></tr>
	  	<tr><th>국어 : </th><td>${student.kor }</td></tr>
	  	<tr><th>영어 : </th><td>${student.eng }</td></tr>
	  	<tr><th>수학 : </th><td>${student.mat }</td></tr>
	  	<tr><th>총점 : </th><td>${student.sum }</td></tr>
	  	<tr><th>평균 : </th><td>${student.avg }</td></tr>
	  	<tr><th>평균 : </th><td><fmt:formatNumber value="${student.avg }" pattern="###.00"/> </td></tr>
	  	<tr><td colspan="2">
	  				<button onclick="history.back()">뒤로가기</button>
	  				<button onclick="location.href='${conPath}/inputForm.do'">다시입력</button>
	  	</td></tr>
	  </table>
	 </div>
</body>
</html>