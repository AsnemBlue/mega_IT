<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  프로세스단  -->
<jsp:useBean class="com.tj.ex.Student" id="student" scope="request"/>
<jsp:setProperty name="student" property="studentNum" param="studentNum"/>
<jsp:setProperty name="student" property="name" param="name"/>
<jsp:setProperty name="student" property="grade" param="grade"/>
<jsp:setProperty name="student" property="className" param="className"/>
<jsp:setProperty name="student" property="score" param="score"/>
<jsp:forward page="stResult.jsp"/>
<!DOCTYPE html>
<html>
<head></head>
<body></body>
</html>











