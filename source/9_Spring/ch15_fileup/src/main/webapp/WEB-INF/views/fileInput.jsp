<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
<body>
  <div align="center">
  	<hr width="500" color="green">
  	<h2>파일 업로드</h2>
  	<hr width="500" color="green">
  	<form action="fileUpload" method="post" enctype="multipart/form-data">
  		<p>첨부파일1 : <input type="file" name="file1"></p>
  		<p>첨부파일2 : <input type="file" name="file2"></p>
  		<p>첨부파일3 : <input type="file" name="file3"></p>
  		<input type="submit">
  	</form>
  </div>
</body>
</html>












