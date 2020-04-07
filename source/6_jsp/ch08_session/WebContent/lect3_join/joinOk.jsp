<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
<%String agree = request.getParameter("agree");
	String msg = "";
	if(agree!=null && agree.equals("y")){ // 약관에 동의한 경우(세션값받아 저장,일부세션날림)
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		String name = (String)session.getAttribute("name");
		String filePath = "D:/mega_IT/source/6_jsp/ch08_session/WebContent/WEB-INF/"+id+".txt";
		PrintWriter writer = null;
		try{
			writer = new PrintWriter(filePath);
			writer.println("오늘은 DB insert대신 파일에 쓰기");
			writer.println("아이디 : "+id);
			writer.println("비밀번호 : "+pw);
			writer.println("이 름 : "+name);
			msg = "success";
			session.removeAttribute("pw");
			session.removeAttribute("name");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(writer!=null) writer.close();
		}
	}else if(agree!=null && agree.equals("n")){ // 약관에 동의하지 않는 경우(세션날림)
		session.invalidate();
		msg = "fail";
	}else{           // 이상한 경우
		response.sendRedirect("join.jsp");
	}
	response.sendRedirect("result.jsp?msg="+msg);
%>
</body>
</html>















