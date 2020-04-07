<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request"/>
<jsp:setProperty name="pi" property="*"/>
<jsp:forward page="piView.jsp"/>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
</body>
</html>