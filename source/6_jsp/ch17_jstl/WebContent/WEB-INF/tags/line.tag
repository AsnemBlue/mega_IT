<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="size" type="java.lang.Integer" required="true"%>
<%@ attribute name="ch" type="java.lang.String" %>
<%@ attribute name="color" type="java.lang.String" %>
<c:if test="${empty ch }">
	<c:set var="ch" value="="/>
</c:if>
<c:if test="${empty color }">
	<c:set var="color" value="red"/>
</c:if>
<font color="${color }">
<c:forEach begin="1" end="${size }">${ch }</c:forEach>
</font>
<br>