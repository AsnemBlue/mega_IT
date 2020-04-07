<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>td{padding:5px;}</style>
</head>
<body>
<%
	int su1 = Integer.parseInt(request.getParameter("su1"));
	int su2 = Integer.parseInt(request.getParameter("su2"));

%>
	<table>
	<caption><%=su1%>단부터 <%=su2 %>단까지 구구단 출력</caption>
<%	for(int i=1 ; i<10 ; i++){%>
		<tr>
<%		for(int j=su1 ; j<=su2 ; j++){%>
			<td><%=j %> * <%=i %> = <%=j*i %> </td>
<%		}%>
		</tr>
<%	}%>
	</table>
	<br><br>	
	<button onclick="location.href='7_su2Input.html'">뒤로가기</button>
</body>
</html>



