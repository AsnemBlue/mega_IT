<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/board.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker(
    		{	dateFormat : 'yy-mm-dd',
					monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
					showMonthAfterYear : true,
					yearSuffix : '년', // "2018년 7월"
					showOtherMonths : true, // 다른 달도 화면에 출력
					dayNamesMin : ['일','월','화','수','목','금','토']
    		}
    );
  } );
  </script>
</head>
<body>
	<form action="update.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="empno" value="${updateForm.empno }">
		<table>
			<caption>${updateForm.empno }번 사원 정보 수정</caption>
			<tr><th>이름</th>
					<td><input type="text" name="ename" value="${updateForm.ename }" required="required"></td>
			</tr>
			<tr><th>업무</th>
					<td><input type="text" name="job" value="${updateForm.job }" required="required"></td>
			</tr>
			<tr><th>관리자사번</th>
					<td><input type="number" name="mgr" value="${updateForm.mgr }" required="required"></td>
			</tr>
			<tr><th>입사일</th>
					<td><input type="text" name="hiredate" value="${updateForm.hiredate.substring(0,10) }" required="required" id="datepicker"></td>
			</tr>
			<tr><th>급여</th>
					<td><input type="number" name="sal" value="${updateForm.sal }" required="required"></td>
			</tr>
			<tr><th>상여</th>
					<td><input type="number" name="comm" value="${updateForm.comm }" required="required"></td>
			</tr>
			<tr><th>부서코드</th>
					<td><input type="number" name="deptno" value="${updateForm.deptno }" required="required"></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="수정"></td></tr>
		</table>
	</form>
</body>
</html>