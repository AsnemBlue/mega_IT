<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  프로세스단  -->
<jsp:useBean class="com.tj.ex.Student" id="student" scope="request"/>
<jsp:setProperty name="student" property="studentNum"
							value="<%=request.getParameter(\"studentNum\") %>"/>
<jsp:setProperty name="student" property="name"
						 	value='<%=request.getParameter("name") %>'/>
<jsp:setProperty name="student" property="grade"
						 	value='<%=Integer.parseInt(request.getParameter("grade")) %>'/>
<jsp:setProperty name="student" property="className"
						 	value='<%=request.getParameter("className").charAt(0) %>'/>
<jsp:setProperty name="student" property="score"
						 	value='<%=Integer.parseInt(request.getParameter("score")) %>'/>
<jsp:forward page="stResult.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>











