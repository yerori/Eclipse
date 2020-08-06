<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

 <c:if test="${param.id!=null}">
  <c:set var="id" value="${param.id}"/>
 </c:if>
  <c:if test="${param.id==null||param.id==''}"> <!-- id가 널이거나 공백이면 -->
 	GUEST
 </c:if>

 <c:choose>	  <!-- (choose+when)이 case문처럼 -->
 <c:when test="${param.color=='yellow'}"> <!-- yellow면, 변수 c는 노랑 -->
	<c:set var="c" value="노랑"/>
</c:when>

 <c:when test="${param.color=='blue'}">
	<c:set var="c" value="파랑"/>
</c:when>

 <c:when test="${param.color=='pink'}">
	<c:set var="c" value="분홍"/>
</c:when>

 <c:when test="${param.color=='orange'}">
	<c:set var="c" value="오렌지"/>
</c:when>
</c:choose>
${id}님이 좋아하는 색깔은 
<span style="background-color:${param.color}">${c}</span>입니다.


</body>
</html>