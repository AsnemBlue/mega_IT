<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<script>
	function chk(){
		if(frm.pw.value!=frm.pwChk.value){
			alert('비밀번호를 확인하세요');
			frm.pw.focus();
			return false;
		}
	}
</script>
</head>
<body>
<form action="joinOk.jsp" method="post" name="frm" onsubmit="return chk()">
	<table>
		<caption>회원가입</caption>
		<tr><th>아이디</th>
				<td><input type="text" name="id" required="required" size="20"></td>
		</tr>
		<tr><th>이름</th>
				<td><input type="text" name="name" required="required" size="20"></td>
		</tr>
		<tr><th>비밀번호</th>
				<td><input type="password" name="pw" required="required" size="20"></td>
		</tr>
		<tr><th>비밀번호 확인</th>
				<td><input type="password" name="pwChk" required="required" size="20"></td>
		</tr>
		<tr><th>전화번호</th>
				<td><select name="phone1">
							<option></option><option>02</option><option>010</option>
						</select> -
						<input type="text" name="phone2" size="3"> -
						<input type="text" name="phone3" size="3">
				</td>
		</tr>
		<tr><th>성별</th>
				<td><input type="radio" name="gender" value="m">남
						<input type="radio" name="gender" value="f">여
				</td>
		</tr>
		<tr><td colspan="2">
					<input type="submit" value="가입">
					<input type="reset" value="취소">
					<input type="button" value="로그인" onclick="location.href='login.jsp'">
				</td>
		</tr>
	</table>
</form>
</body>
</html>












