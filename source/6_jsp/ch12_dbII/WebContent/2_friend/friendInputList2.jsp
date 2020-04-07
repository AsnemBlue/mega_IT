<%@page import="com.tj.dto.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
	p{text-align: center;}
</style>
<%
	String result = request.getParameter("result");
	if(result!=null && result.equals("1")){%>
		<script>alert('친구추가 성공');</script>
<%}else if(result!=null && result.equals("0")){ %>	
		<script>alert('친구추가 실패. 이름이나 전화번호가 너무 길면 안되고 중복된 전번도 안되요');</script>
<%}%>
<script>
	function search(){
		var name = frm.name.value;
		var tel= frm.tel.value;
		location.href = 'friendInputList2.jsp?name='+name+'&tel='+tel;
	}
</script>
</head>
<body>
	<form action="friendInputListPro.jsp" name="frm">
		<p>친구이름 <input type="text" name="name" required="required"	 size="5"
								value="<%
									String name = request.getParameter("name");
									out.print(name!=null ? name : "");
								%>">
			 전화 <input type="text" name="tel" size="5"
			 					value="<%
									String tel = request.getParameter("tel");
									out.print(tel!=null ? tel : "");
								%>">
			 <input type="submit" value="추가">
			 <input type="button" value="검색" onclick="search()">
		</p>
	</form>
	<table>
	<tr><th>순번</th><th>이름</th><th>전화</th></tr>
	<%FriendDao friendDao = FriendDao.getInstance();
		ArrayList<FriendDto> dtos = friendDao.selectNameTel(name, tel);
		for(int idx=0 ; idx<dtos.size() ; idx++){%>
			<tr><td><%=dtos.get(idx).getNo() %></td>
					<td><%=dtos.get(idx).getName()%></td>
					<td><%=dtos.get(idx).getTel()%></td>
			</tr>
	<%} %>
	</table>
</body>
</html>