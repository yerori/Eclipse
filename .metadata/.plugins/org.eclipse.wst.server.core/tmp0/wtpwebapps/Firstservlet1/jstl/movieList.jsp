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
<%
String[] movieList={"타이타닉","시네마천국","혹성탈출","킹콩","콜미바이유어네임","매드맥스"};
pageContext.setAttribute("list", movieList);
%>

<table border="1">
<tr>
 <th>index</th>
 <th>count</th> <!-- index,count 차이 -->
 <th>title</th>
  <th>비고</th>
</tr>

<c:forEach items="${list}" var="movie" varStatus="status" begin="3" end="6"> <!-- items:저장소 -->
 <tr>
  <td>${status.index}</td>
  <td>${status.count}</td>
  <td>${movie}</td> <!-- "타이타닉","시네마천국","혹성탈출","킹콩" -->
  <td>
   <c:if test="${status.first}">
   	첫번째
   </c:if>
    <c:if test="${status.last}">
   	마지막
   </c:if>
 </tr>
</c:forEach>

</table>
</body>
</html>