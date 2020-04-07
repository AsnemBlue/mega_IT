<%@page import="com.tj.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<table>
		<tr><th>ID</th><th>이름</th><th>비밀번호</th><th>전화</th><th>성별</th></tr>
	<%
		MemberDao memberDao = MemberDao.getInstance();
		ArrayList<MemberDto> dtos = memberDao.selectAll();
		for(MemberDto dto : dtos){%>
			<tr><td><%=dto.getId() %></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getPw() %></td>
					<td>
						<%if(dto.getPhone1()==null){
								out.println('-');
							}else{
								out.println(dto.getPhone1()+"-"+dto.getPhone2()+"-"+dto.getPhone3());
							}
						%>
					</td>
					<td><%=dto.getGender()!=null? dto.getGender():"" %></td>
				</tr>
	<%}%>
	</table>
</body>
</html>















