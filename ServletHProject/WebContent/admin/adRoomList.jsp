
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
<script>
<script>
$(document).ready(function(){
	getData(1);
})//document
function getData(pageNum){
	$.get("roomlist",
	  {"pageNum":pageNum},
		 function(d){
		   $("#result").html(d);
		 })
}




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
#img{
	width:200px;
}

#addBtn{
	width:80px;
}
</style>

<body>
<form action="adRoomInsert.jsp">
<input type="hidden" name="userid" value="${con.id}">
 <div id="container">
  <h4 id="h4">존재하는 방 : 총 <span id="cntSpan">${count }개</span></h4>
  
<table class="table table-striped">
<thead class="thead-dark">

	<tr>
	<th>방 번호</th>
	<th>방 이름</th>
	<th>최대 성인 수용 인원</th>
	<th>최대 아기 수용 인원</th>
	<th>가격</th>
	<th>이미지</th>
	</tr>
   </thead>
  <tbody>	
	
	
  <c:forEach items="${roomArr }" var="room">
  <tr>
	<td>${room.rno }</td>
	<td><a href="roomdetail?rno=${room.rno}">${room.rname }</a></td>
	<td>${room.tot_ad }</td>
	<td>${room.tot_ch }</td>
	<td>${room.price }</td>
	<td><img src="../hotel/assets/img/room/${room.rimage }" id="img"></td>
	<td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="6" align="center">
	 <a href="../admin/adRoomInsert.jsp" class="btn btn1 d-none d-lg-block " id="addBtn">추가하기</a>
	</tr>
	</tbody>	
</table>
</div>
</form>
<div align = "center" > <br>
	  	<c:if test = "${pu.startPage>pu.pageBlock}"> <!-- 이전-->
	  		<a href = "roomlist?pageNum=${pu.startPage-pu.pageBlock}">[이전]</a>
	  	</c:if>
	  	<c:forEach begin ="${pu.startPage}" end = "${pu.endPage}" var = "i"> <!-- 이전-->
  			<c:if test ="${i==pu.currentPage}"> <!-- 현재페이지-->
 				<c:out value = "${i}"/>
  			</c:if>
  			<c:if test = "${i!=pu.currentPage}"> <!-- 현재페이지 아닌 경우 링크 부여-->
  				<a href = "roomlist?pageNum=${i}">${i}</a>
  			</c:if>
	  	</c:forEach>
	  	<c:if test = "${pu.endPage < pu.totPage}"> <!-- 다음-->
	  		<a href = "roomlist?pageNum=${pu.endPage+1}">[다음]</a>
	  	</c:if>
	  </div>
</body>
</html>
<%@ include file="adFooter.jsp" %>
