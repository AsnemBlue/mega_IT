<%@tag import="java.util.Calendar"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%
	Calendar cal = Calendar.getInstance();
%>
<h2><%=cal.get(Calendar.YEAR) %>년
		<%=cal.get(Calendar.MONTH)+1 %>월
		<%=cal.get(Calendar.DATE) %>일
</h2>