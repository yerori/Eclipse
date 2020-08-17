<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	$("#btn").on("click",function(){
		location.href="reservation.jsp";
	})
// 	$("#subBtn").on("click",function(){
// 		$.ajax({
// 		  type:"post",
// 		  url:"resupdate",
// 		  data:{"rsno":$("#rsno").val(),"occupancy":$("#occupancy").val(),
// 			  "tot_ad":$("#tot_ad").val(),"tot_ch":$("#tot_ch").val(),
// 			  "startdate":$("#startdate").val(),"enddate":$("#enddate").val(),
// 			  "rname":$("#rname").val(),"gno":$("#gno").val(),
// 			  "id":$("#id").val(),"pay":$("#pay").val()},
// 		  success:function(d){
// 			  location.href="reservationUpdate.jsp";
// 		  },
// 		  error:function(e){
// 			  alert("error : "+e);
// 		  }
// 	})
	
		
// 	})
// 	)
})
// function delFunc(cnum){
// 	if(confirm("정말 삭제할까요?")){
// 		location.href="delete?cnum="+cnum;
// 		alert("삭제되었습니다.");
// 	}
// }


</script>
<style>
.btn btn1 d-none d-lg-block{
	width:100px;
}
#btn, #nextBtn{
	padding:30px;
	margin: 20px;
	width:100px;
	
}
#container{
	padding:100px;
	margin:100px;
	text-align:center;
	
}

#a{
	margin:0 auto;
	text-align:center;
	padding:40px;
	
}

#box{
	margin:0 auto;
}

#p{
	font-weight: bold;
}

#img{
	width:500px;
}

</style>
<body>


<form action="reservationEnd.jsp">
<input type="hidden" id="gno" name="gno" value="${gno}">
<input type="hidden" id="rsno" name="rsno" value="${resArr.rsno}">
<div id="container" align=center>
<h3 id="p">${resArr.id }님의 결제 폼</h3><br>
<table id="a" border="1">
<tbody>
 
 <tr>
 <th>고객 아이디</th>
 <td>${resArr.id }</td>
 </tr>

 <tr>
 <th>숙박 날짜</th>
 <td>${resArr.startdate}~<br>${resArr.enddate }</td>
 </tr>

 <tr>
 <th>숙박 기간</th>
 <td>${resArr.occupancy }일</td>

 </tr>
 
 <tr>
 <th>어른 인원 수</th>
 <td>${resArr.tot_ad }</td>
 </tr>
 
 <tr>
 <th>아기 인원 수</th>
 <td>${resArr.tot_ch }</td>
 </tr>
 
 <tr>
 <th>방 이름</th>
<td><img src="../hotel/assets/img/room/${resArr.rimage }" id="img"></br>
		${resArr.rname }</td>
 </tr>
 
 <tr>
 <th>지불 방법</th>
 <td>${resArr.pay }</td>
 </tr>
  
 <tr>
 <th>총 지불 가격</th>
 <td>${resArr.price }</td>
 </tr>
 


<tr>

<td colspan="2" align="center">
  	
    <input type="submit" class="btn btn1 d-none d-lg-block " id="nextBtn" value="예약하기">
   <input type="reset" class="btn btn1 d-none d-lg-block " id="btn" value="처음으로"></td>
</tbody>
</table>
</div>
</form>
</body>
</html>
<%@ include file="../include/footer.jsp" %>