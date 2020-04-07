<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String path =  request.getRealPath("fileboardUpload");
	int maxSize = 1024*1024*5;
	String ffilename = "";
	MultipartRequest multipartRequest = null;
	try{
		multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8",
															new DefaultFileRenamePolicy()); // 서버에 파일 저장
		Enumeration<String> params = multipartRequest.getFileNames(); 
		//while(params.hasMoreElements()){
			String param = params.nextElement();
			ffilename = multipartRequest.getFilesystemName(param);
		//}
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
	// 서버에 저장된 파일 소스폴더로 복사
	InputStream is = null;
	OutputStream os = null;
	try{
		File serverFile = new File(path+"/"+ffilename);
		if(serverFile.exists()){
			is = new FileInputStream(serverFile);
			os = new FileOutputStream("D:/mega_IT/source/6_jsp/model1ex/WebContent/fileboardUpload/"+ffilename);
			byte[] bs = new byte[(int)serverFile.length()];
			int nReadByteCnt;
			while((nReadByteCnt=is.read(bs))!=-1){
				os.write(bs, 0, nReadByteCnt);
			}
		}
	}catch(IOException e){
		System.out.println(e.getMessage());
	}finally{
		if(is!=null) is.close();
		if(os!=null) os.close();
	}
	String pageNum = multipartRequest.getParameter("pageNum");
	int    fnum = Integer.parseInt(multipartRequest.getParameter("fnum"));
	
	String cid = ((CustomerDto)session.getAttribute("customer")).getCid(); // 가능
	
	String fsubject = multipartRequest.getParameter("fsubject");
	String fcontent = multipartRequest.getParameter("fcontent");
	String fpw  = multipartRequest.getParameter("fpw");;
	int    fref = Integer.parseInt(multipartRequest.getParameter("fref"));
	int    fre_step = Integer.parseInt(multipartRequest.getParameter("fre_step"));;
	int    fre_level = Integer.parseInt(multipartRequest.getParameter("fre_level"));;
	String fip = request.getRemoteAddr();
	FileBoardDto fbDto = new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, 0,
				fref, fre_step, fre_level, fip, null, null, null);
	int result;
	FileBoardDao fbDao = FileBoardDao.getInstance();
	if(fnum==0){ // 원글쓰기
		result = fbDao.insertFileBoard(fbDto);
	}else{ // 답변글 쓰기
		result = fbDao.reply(fbDto);
	}
	if(result==FileBoardDao.SUCCESS){
%>
		<script>
			alert('글쓰기 성공');
			location.href = 'fboardList.jsp?pageNum=<%=pageNum%>';
		</script>
<%}else{%>
		<script>
			alert('글쓰기 실패');
			history.back();
		</script>
<%}%>
</body>
</html>