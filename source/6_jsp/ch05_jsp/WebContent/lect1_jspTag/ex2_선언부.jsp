<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>span{color:red;}</style>
</head>
<body>
<%!	int i; //선언부에 선언된 변수는 전역변수 (초기화하지 않으면 자동 초기화)
		StringBuffer strBuf = new StringBuffer("좋아요 ");
		private int sum(int a, int b){
			return a+b;
		}
%>
<%	int j=0;
		String str="좋아요 ";
		i++; j++;
		strBuf.append("<span>♥<span>");
		str += "<span>♥<span>";
%>
	<h2>sum(2,4)함수 결과 = <%=sum(2,4) %></h2>
	<h2>i(전역) = <%=i %></h2>
	<h2>j = <%=j %></h2>
	<h2>strBuf(전역) = <%=strBuf %></h2>
	<h2>str = <%=str %></h2>
</body>
</html>



