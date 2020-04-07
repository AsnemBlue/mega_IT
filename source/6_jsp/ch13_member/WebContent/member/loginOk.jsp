<%@page import="com.tj.member.MemberDto"%>
<%@page import="com.tj.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.loginCheck(id, pw);
	if(result==MemberDao.LOGIN_SUCCESS){ // 로그인 성공
		MemberDto member = mDao.getMember(id);
		session.setAttribute("member", member);
		response.sendRedirect("main.jsp");
	}else if(result==MemberDao.LOGIN_FAIL_PW){//pw오류
%>
		<script>
			alert('비밀번호를 확인하세요');
			history.go(-1);
		</script>
<%}else if(result==MemberDao.LOGIN_FAIL_ID){%>
		<script>
			alert('존재하지 않는 아이디입니다');
			history.go(-1);
		</script>
<%}%>
</body>
</html>