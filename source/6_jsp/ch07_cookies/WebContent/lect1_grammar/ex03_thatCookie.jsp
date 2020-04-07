<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>특정 쿠키(쿠키이름이 cookieName인 쿠키)의 값 확인</h2>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		int idx=0;
		for(idx=0 ; idx<cookies.length ;idx++){
			String name = cookies[idx].getName();
			if(name.equals("cookieName")){
				String value = cookies[idx].getValue();
				out.println("<h3>찾고자 하는 쿠키 이름:"+name +"/ 쿠키값:"+value+"</h3>");
				break;
			}
		}
		if(idx==cookies.length){
			out.println("찾고자 하는 쿠기가 없습니다");
		}
	}else{
		out.print("생성된 쿠키가 없습니다");
	}
%>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키생성</a><br>
	<a href="ex02_cookieslist.jsp">쿠키값들 리스트 확인</a> <br>
	<a href="ex03_thatCookie.jsp">특정 쿠키(이름이 cookieName) 찾기</a> <br>
	<a href="ex04_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>











