<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<script src="../js/modify.js"></script>
</head>
<body>
<%!String id, name, email, address; Timestamp birth;%>
<%MemberDto member = (MemberDto)session.getAttribute("member");
	if(member==null){
		response.sendRedirect("login.jsp");
	}else{
		id = member.getId();
		name = member.getName();
		email = member.getEmail();
		birth = member.getBirth();
		address = member.getAddress();
	}
%>
	<form action="modifyOk.jsp" method="post" name="modify_frm" onsubmit="return infoConfirm()">
		<table>
			<caption>정보수정</caption>
			<tr><th>아이디</th><td><input type="text" name="id" value="<%=id%>" readonly="readonly"></td></tr>
			<tr><th>현비밀번호</th><td><input type="password" name="oldPw" required="required"></td></tr>
			<tr><th>새비밀번호</th><td><input type="password" name="pw"></td></tr>
			<tr><th>새비밀번호</th><td><input type="password" name="pwChk"></td></tr>
			<tr><th>이름</th>
					<td><input type="text" name="name" value="<%=name%>" required="required"></td></tr>
			<tr><th>메일</th>
					<td><input type="email" name="email" value="<%=email==null? "":email%>"></td></tr>
			<tr><th>생년월일</th>
					<td><input type="date" name="tempbirth" 
													value="<%
													if(birth!=null) out.print(birth.toString().substring(0, 10));
													%>"
													required="required"></td></tr>
			<tr><th>주소</th>
					<td><input type="text" name="address" value="<%=address!=null? address:"" %>"></td></tr>
			<tr><td colspan="2">
						<input type="submit" value="정보수정">
						<input type="reset" value="취소">
						<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
		</table>
	</form>
</body>
</html>