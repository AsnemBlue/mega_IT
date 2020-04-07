<%@page import="com.tj.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		for(int i=0 ; i<55 ; i++){
			BoardDao dao = BoardDao.getInstance();
			if(i%4==0){
				dao.write("aaa", "제목"+i, i+"번째 본문", null, "192.168.10.151");			
			}else if(i%4==1){
				dao.write("gico", "제목"+i, i+"번째 본문", null, "192.168.10.151");		
			}else if(i%4==2){
				dao.write("go", "제목"+i, i+"번째 본문", null, "192.168.10.151");		
			}else if(i%4==3){
				dao.write("gayun", "제목"+i, i+"번째 본문", null, "192.168.10.151");				
			}			
		}
		response.sendRedirect("../list.do");
	%>
</body>
</html>