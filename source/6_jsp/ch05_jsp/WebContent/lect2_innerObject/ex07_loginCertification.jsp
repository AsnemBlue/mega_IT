<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%boolean isValid = false;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id!=null && id.equals("aaa")){ // 아이디를 aaa로 잘 입력한 경우
			if(pw!=null && pw.equals("111")){ // 비밀번호를 제대로 입력한 경우
				isValid = true;
			}
		}
		if(!isValid){
			response.sendRedirect("ex07_loginFrm.jsp?msg=no");
		}
	%>
	id는 <%=id %>이고 <br>
	비밀번호는 <%=pw %>입니다<br><br>
	반갑습니다

</body>
</html>