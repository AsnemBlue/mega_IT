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
	<script>
		function chk(){
			if(!frm.empno.value){
				alert('사번을 입력 후 중복체크하세요');
				frm.empno.focus();
			}else{
				var mgr = frm.mgr.options[frm.mgr.selectedIndex].value;
				location.href = 'confirmNo.do?empno='+frm.empno.value+'&mgr='+mgr;
			}
		}
	</script>
</head>
<body>
<c:if test="${not empty writeResult }">
	<script>alert('${writeResult}');</script>
</c:if>
<form action="write.do" method="post" name="frm">
	<table>
		<caption>사원등록</caption>
		<tr><th>사번</th>
				<td><input type="number" name="empno" required="required"
						maxlength="4" value="${param.empno }" style="width:110px;">
						<input type="button" value="중복확인" onclick="chk()" style="width:80px;"><br>
						<c:if test="${msg!=null }">${msg }</c:if>
				</td>
			</tr>
			<tr><th>이름</th><td><input type="text" name="ename" required="required" style="width:200px;" value="${param.ename }"></td></tr>
			<tr><th>업무</th><td><input type="text" name="job" required="required" style="width:200px;" value="${param.job }"></td></tr>
			<tr><th>관리자</th>
					<td><select name="mgr">
								<c:forEach var="mgrEmp" items="${managerList}">
									<option value="${mgrEmp.empno }"
										<c:if test="${param.mgr==mgrEmp.empno }"> selected="selected" </c:if>
									>${mgrEmp.empno } - ${mgrEmp.ename }</option>
								</c:forEach>
							</select>
					</td>
			</tr>
			<tr><th>입사일</th><td><input type="date" name="hiredateT" required="required" style="width:200px;" value="${param.hiredate }"></td></tr>
			<tr><th>급여</th><td><input type="number" name="sal" required="required" style="width:200px;" value="${param.sal }"></td></tr>
			<tr><th>상여</th><td><input type="number" name="comm" required="required" style="width:200px;" value="${param.comm }"></td></tr>
			<tr><th>부서코드</th>
					<td><select name="deptno" style="width:200px;">
								<c:forEach var="dept" items="${deptList }">
									<option value="${dept.deptno }" 
										<c:if test="${param.deptno==dept.deptno }"> selected="selected" </c:if>
									>${dept.deptno }-${dept.dname }-${dept.loc }</option>
								</c:forEach>
							</select>
						</td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="등록"></td></tr>
	</table>
</form>
</body>
</html>