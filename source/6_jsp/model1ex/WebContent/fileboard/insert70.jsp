<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%FileBoardDao fbDao = FileBoardDao.getInstance();
	FileBoardDto fbDto = new FileBoardDto();
	for(int i=0 ; i<70 ; i++){
		if(i%3==0){
			fbDto.setCid("aaa");
		}else if(i%3==1){
			fbDto.setCid("bbb");
		}else{
			fbDto.setCid("ccc");
		}
		fbDto.setFsubject("for문 돌려 강제로 입력한 글 "+i);
		fbDto.setFcontent("내용"+i);
		if(i%10 == 0){
			fbDto.setFfilename("a.pptx");
		}else{
			fbDto.setFfilename(null);
		}
		fbDto.setFpw("111");
		fbDto.setFip("192.168.20.44");
		fbDao.insertFileBoard(fbDto);
	}
	response.sendRedirect("fboardList.jsp");
%>
</body>
</html>