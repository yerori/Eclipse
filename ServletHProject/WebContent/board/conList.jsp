<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<script>


</script>
<style>
#container{
	margin:0 auto;
	padding:30px;
	text-align:center;
}

#h4{
	padding:20px;
}
</style>
<body>
<input type="hidden" name="userid" value="${con.id}">
 <div id="container">
  <h4 id="h4">내가 작성한 글 : <span id="cntSpan">${count }개</span></h4>
  
<table class="table table-striped">
<thead class="thead-dark">

	<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
	<td>이메일</td>
	<td>내용</td>
	</tr>
   </thead>
  <tbody>	
	
	
  <c:forEach items="${conArr }" var="content">
  <tr>
	<td>${content.cnum }></td>
	<td><a href="detail?cnum=${content.cnum}">${content.subject }</a></td>
	<td>${content.id }></td>
	<td>${content.email }></td>
	<td>${content.content }></td>
	</tr>
	</c:forEach></tbody>
</table>
</div>
</body>
</html>
<%@ include file="../include/footer.jsp" %>