<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  프로세스단  -->
<jsp:useBean class="com.tj.ex.Student" id="student" scope="request"/>
<jsp:setProperty name="student" property="*"/>
<jsp:forward page="stResult.jsp"/>
<!DOCTYPE html>
<html>
<head></head>
<body></body>
</html>