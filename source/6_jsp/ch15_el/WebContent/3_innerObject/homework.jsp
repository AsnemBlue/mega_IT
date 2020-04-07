<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p {text-align: center;}
	p:last-child { color:red;font-weight: bold;}
</style>
</head>
<body>
	<form action="">
		<p>
			<input type="number" name="n1" value="<%=(int)(Math.random()*9)+1%>"> *
			<input type="number" name="n2" value="<%=(int)(Math.random()*9)+1%>"> =
			<input type="number" name="result">
		</p>
		<p><input type="submit" value="확인"></p>
		<p>${param.n1 } * ${param.n2 } = ${param.result }
		   ${param.n1*param.n2 eq param.result }
		   ${not empty param.result ?(param.n1*param.n2 eq param.result ? "정답":"오답") : "" }
	</form>
</body>
</html>