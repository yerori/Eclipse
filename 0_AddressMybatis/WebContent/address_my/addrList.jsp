
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>


</head>
<body>
<a href="addrInsert.jsp" >글쓰기</a></br>
</br> 게시글 개수 : 총 <span>${count }개</span>
<table>
 <thead>
 <tr>
  <td>번호</td>
  <td>이름</td>
  <td>주소</td>
  <td>전화번호</td>
 </tr> 
</thead>
<tbody>
<c:forEach items="${arr }" var="address">
<tr>
 <td>${address.num }</td>
 <td><a href="detail.do?num=${address.num }">${address.name }</a></td>
 			<!--  값을 줘야 받아오징!! -->
 <td>${address.addr }</td>
 <td>${address.tel }</td>

</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>








