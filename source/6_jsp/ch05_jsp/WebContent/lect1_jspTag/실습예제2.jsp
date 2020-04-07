<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		document.getElementsByTagName('form')[0].onsubmit = function(){
			var num = document.getElementsByName('num')[0];
			var n = Number(num.value);
			if(isNaN(n) || n<=0 || n%1!=0 ){
				alert('양수를 입력하세요');
				num.value='';
				num.focus();
				return false;
			}
		};
	};
</script>
</head>
<body>
	<%	String num =  request.getParameter("num"); %>
	<fieldset>
		<legend>숫자입력</legend>
		<form action="" method="get">
			숫자 <input type="text" name="num" value="<%if(num!=null) out.print(num);%>"
						autofocus="autofocus">
			<input type="submit" value="누적">
		</form>
	</fieldset>
	<%
	int n=0, total=0;
	if(num!=null){
		n = Integer.parseInt(num);
		for(int i=1; i<=n ; i++){
			total += i;
		}
		out.println("<h2>1부터 "+n+"까지 누적합은 "+total+"</h2>");
	}
	%>
</body>
</html>









