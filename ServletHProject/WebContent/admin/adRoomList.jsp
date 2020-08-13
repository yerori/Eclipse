<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adHeader.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<style>
#container{
	margin:0 auto;
	padding:30px;
	text-align:center;
}

#h4{
	padding:20px;
}
#img{
	width:200px;
}
</style>
<body>
<input type="hidden" name="userid" value="${con.id}">
 <div id="container">
  <h4 id="h4">작성된 글 : 총 <span id="cntSpan">${count }개</span></h4>
  
<table class="table table-striped">
<thead class="thead-dark">

	<tr>
	<td>방 번호</td>
	<td>방 이름</td>
	<td>최대 성인 수용 인원</td>
	<td>최대 아기 수용 인원</td>
	<td>가격</td>
	<td>이미지</td>
	</tr>
   </thead>
  <tbody>	
	
	
  <c:forEach items="${roomArr }" var="room">
  <tr>
	<td>${room.rno }</td>
	<td><a href="roomdetail?rno=${room.rno}">${room.rname }</a></td>
	<td>${room.men }</td>
	<td>${room.baby }</td>
	<td>${room.price }</td>
	<td><img src="../hotel/assets/img/room/${room.rimage }" id="img"></td>
	<td>
	</tr>
	</c:forEach></tbody>
</table>
</div>
</body>
</html>
<%@ include file="adFooter.jsp" %>