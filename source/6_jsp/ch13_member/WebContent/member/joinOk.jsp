<%@page import="com.tj.member.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");
	String conPath = request.getContextPath();%>
<jsp:useBean id="dto" class="com.tj.member.MemberDto"/>
<jsp:setProperty name="dto" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	String tempbirth = request.getParameter("tempbirth"); // 1991-12-12
	dto.setBirth(Timestamp.valueOf(tempbirth+" 00:00:00"));
	// dto.setRdate(new Date(System.currentTimeMillis()));
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.confirmId(dto.getId()); // ID 중복체크
	if(result == MemberDao.MEMBER_NONEXISTENT){ // 사용가능한 ID
		result = mDao.insertMember(dto); // 회원가입
		if(result == MemberDao.SUCCESS){ //회원가입 성공
			session.setAttribute("id", dto.getId());
%>		<script>
				alert('회원가입 감사합니다. 로그인 이후에 서비스를 이용하세요');
				location.href='login.jsp';
			</script>
<%	}else{ //회원가입 실패
%>
			<script>
				alert('회원가입이 실패되었습니다. 다시 가입해 주세요');
				location.href='join.jsp';
			</script>
<%						
		}
	}else{ // 중복된 ID
%>	<script>
			alert('중복된 ID입니다. 다른 아이디를 사용하세요');
			history.back();
		</script>
<%}%>
</body>
</html>