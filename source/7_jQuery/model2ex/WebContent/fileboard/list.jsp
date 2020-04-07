<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<style>
	#content_form {
		width: 800px; height:470px;
		margin: 30px auto 0px;
	}
	#content_form table tr { height: 10px;}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('tr').click(function(){
			var fId = Number($(this).children(0).eq(0).text()); // 0번째 td안의 있는 text;
			if(!isNaN(fId)){
				location.href = '${conPath}/content_view.do?fId='+fId+'&pageNum=${pageNum}';
			}
		});
	});
</script>
<body>
	<c:if test="${not empty resultMsg }">
		<script>alert('${resultMsg}');</script>
	</c:if>
	<c:if test="${not empty loginErrorMsg}">
		<script>
			alert('${loginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty errorMsg}">
		<script>
			alert('${errorMsg}');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<table>
		<tr><td>
					<c:if test="${not empty member }"><a href="${conPath }/write_view.do">글쓰기</a></c:if>
					<c:if test="${empty member }"><a href="${conPath }/loginView.do">글쓰기는 사용자 로그인 이후에만 가능합니다</a></c:if>
		</td></tr>
	</table>
	<br>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>조회수</th>
				<th>날짜</th><th>ip</th></tr>
		<c:if test="${totCnt==0 }">
			<tr><td colspan="6">글이 없습니다</td></tr>
		</c:if>
		<c:if test="${totCnt!=0 }">
			<c:forEach items="${list }" var="dto">
				<tr><td>${dto.fId }</td>
						<td>${dto.mName }</td>
						<td class="left">
							<c:forEach var="i" begin="1" end="${dto.fIndent }">
								<c:if test="${i==dto.fIndent }">└─</c:if>
								<c:if test="${i!=dto.fIndent }"> &nbsp; &nbsp; </c:if>
							</c:forEach>
							${dto.fTitle }
						</td>
						<td>${dto.fHit }</td>
						<td><fmt:formatDate value="${dto.fRdate }" 
											type="date" dateStyle="short"/></td>
						<td>${dto.fIp }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/list.do?pageNum=${startPage-1}"> 이전 </a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i == pageNum }">
				<b> [ ${i } ] </b>
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/list.do?pageNum=${i}"> ${i } </a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage<pageCnt }">
		  [ <a href="${conPath }/list.do?pageNum=${endPage+1}"> 다음 </a> ]
		</c:if>
	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
















