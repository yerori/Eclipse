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


$("document").ready(function(){        
   getData(1);
});


function getData(pageNum){
	$.get("reslist",
	  {"pageNum":pageNum},
		 function(d){
		   $("#result").html(d);
		 })
}
function delFunc(rsno){
	if(confirm("정말 삭제할까요?")){
		alert("삭제되었습니다.");
		location.href="resdelete?rsno="+rsno;
	}
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

 <div id="container">
  <h4 id="h4">존재하는 예약 : 총 <span id="cntSpan">${count }개</span></h4>
  
<table class="table table-striped">
<thead class="thead-dark">

	<tr>
	<th>고객 ID</th>
	<th>예약 번호</th>
	<th>숙박 기간</th>
	<th>어른 수</th>
	<th>아기 수</th>
	<th>지불 가격</th>
	<th>방 이름</th>
	<th>지불 방법</th>
	<th>예약 삭제</th>
	

	</tr>
   </thead>
  <tbody>	
	
	
  <c:forEach items="${adArr }" var="admin">
  <tr>
  	<td>${admin.id }</td>
	<td>${admin.rsno }</td>
	<td>${admin.startdate }~${admin.startdate }</br>
		총 ${admin.occupancy }박</td>
	<td>${admin.tot_ad }</td>
	<td>${admin.tot_ch }</td>
	<td>${admin.price }</td>
	<td><img src="../hotel/assets/img/room/${admin.rimage }" id="img"></br>
		${admin.rname }</td>
	<td>${admin.pay }</td>
<%--  	<td><a href="resdelete?rsno=${admin.rsno }">삭제</a></td> --%>
	<td onclick="delFunc('${admin.rsno}')">삭제</td> 
	</tr>
	</c:forEach>

	</tbody>	
</table>
</div>

<div align = "center">
	<c:if test = "${pu.startPage > pu.pageBlock }">
		<a href="reslist?pageNum="${pu.startPage-pu.pageBlock }">[이전]</a>
	</c:if>
	
	<c:forEach begin = "${pu.startPage }" end = "${pu.endPage }" var = "i">
		<c:if test="${i==pu.currentPage }">
			<c:out value="${i }"/>
		</c:if>
		<c:if test = "${i!=pu.currentPage }">
			<a href="reslist?pageNum="${i }">${i }</a>
		
		</c:if>
	</c:forEach>
	<c:if test="${pu.endPage<pu.totPage }">
		<a href="reslist?pageNum=${pu.endPage+1 }">[다음]</a>
	</c:if>
</div>

</form>

</body>
</html>
<%@ include file="adFooter.jsp" %>