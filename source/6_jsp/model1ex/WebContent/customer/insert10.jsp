<%@page import="java.sql.Date"%>
<%@page import="com.tj.model1ex.dao.CustomerDao"%>
<%@page import="com.tj.model1ex.dto.CustomerDto"%>
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
	CustomerDto c = new CustomerDto();
	CustomerDao cDao = CustomerDao.getInstance();
	for(int i=0 ; i<10 ; i++){
		c.setCid("aa"+i);
		c.setCpw("111");
		if(i%2==0){
			c.setCname("홍길동");
			c.setCgender("m");
		}else{
			c.setCname("김말자");
			c.setCgender("f");
		}
		c.setCtel("010-8888-888"+i);
		c.setCemail("hong"+i+"@naver.com");
		c.setCaddress("서울시 종로구 삼일대로17길 "+i);
		c.setCbirth(Date.valueOf("1991-02-2"+i));
		cDao.insertCustomer(c);
	}
	response.sendRedirect("../main/main.jsp");
%>
</body>
</html>











