<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
	String conPath = request.getContextPath();
	String appPath = application.getContextPath();
	String absolutePath = application.getRealPath("."); //현프로젝트의 절대경로
%>
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=absolutePath %></h2>
	<%
	String filePath = application.getRealPath("WEB-INF/inpu.txt");
	BufferedReader reader = new BufferedReader(new FileReader(filePath));
	while(true){
		String str = reader.readLine();
		if(str==null)break;
		out.println(str+"<br>");
	}
	if(reader!=null) reader.close();
	
	%>
	<h2>접근할 text 파일 경로 : <%=filePath %></h2>
</body>
</html>



















