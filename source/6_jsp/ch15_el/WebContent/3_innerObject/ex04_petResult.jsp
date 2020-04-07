<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	String id = request.getParameter("id");
	String[] pets = request.getParameterValues("pets");
	out.println("<h3>ID : "+id+"</h3>");
	out.println("<h3>키우는 동물은 ");
	if(pets!=null){
		for(String p : pets){
			out.println(p + " ");
		}
	}else{
		out.println("없습니다");
	}
	out.print("</h3>");
--%>
	<h3>ID : ${param.id }</h3>
	<h3>키우는 동물은 ${paramValues.pets[0] } ${paramValues.pets[1] } 
								 ${paramValues.pets[2] } ${paramValues.pets[3] }
								 ${empty paramValues.pets ? "없습니다":""}
	</h3>
</body>
</html>















