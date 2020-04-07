<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<%
	if(session.getAttribute("validMember")==null){
		response.sendRedirect("login.jsp");
	}
	if(request.getParameter("result")!=null){
%>
		<script>alert('현비밀번호가 맞지 않아 수정불가합니다');</script>
<%		
	}
	//화면에 수정할 정보를 가져오기
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	String phone1 = (String)session.getAttribute("phone1");
	String phone2 = (String)session.getAttribute("phone2");
	String phone3 = (String)session.getAttribute("phone3");
	String gender = (String)session.getAttribute("gender");
%>
<form action="../ModifyOk2" method="post">
	<table>
		<caption>회원 정보 수정</caption>
		<tr><th>아이디</th>
				<td><input type="text" name="id" value="<%=id %>" readonly="readonly" size="20"></td>
		</tr>
		<tr><th>이름</th>
				<td><input type="text" name="name" value="<%=name %>" required="required" size="20"></td>
		</tr>
		<tr><th>현비밀번호</th>
				<td><input type="password" name="oldPw" required="required" size="20"></td>
		</tr>
		<tr><th>새비밀번호</th>
				<td><input type="password" name="newPw" size="20"></td>
		</tr>
		<tr><th>전화번호</th>
				<td><select name="phone1">
						<option></option>
						<option <%if("02".equals(phone1)){out.print("selected='selected'");} %>>02</option>
						<option <%if("010".equals(phone1)){out.print("selected='selected'");} %>>010</option>
						</select> -
						<input type="text" name="phone2" value="<%=phone2!=null? phone2:"" %>" size="3"> -
						<input type="text" name="phone3" value="<%=phone3==null? "":phone3 %>" size="3">
				</td>
		</tr>
		<tr><th>성별</th>
				<td>
					<%if("m".equals(gender)){%>
						<input type="radio" name="gender" value="m" checked="checked">남
						<input type="radio" name="gender" value="f">여
					<%}else if("f".equals(gender)){%>
						<input type="radio" name="gender" value="m">남
						<input type="radio" name="gender" value="f" checked="checked">여
					<%}else{%>
						<input type="radio" name="gender" value="m">남
						<input type="radio" name="gender" value="f">여
					<%}%>
				</td>
		</tr>
		<tr><td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
					<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
				</td>
		</tr>
	</table>
</form>
</body>
</html>
















