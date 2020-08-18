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

})
</script>
<style>
.btn btn1 d-none d-lg-block{
	width:100px;
}
#btn, #subBtn, #nextBtn{
	text-align:"center";
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
	
}

#box{
	margin:0 auto;
}

#p{
	font-weight: bold;
}


</style>
<body>


<form action="resupdate" method="get">

<div id="container" align=center>
<input type="hidden" id="rsno" name="rsno" value="${resArr.rsno}">
<h3 id="p">${resArr.id }님의 예약 확인</h3><br>
<table id="a" border="1">
<tbody>
 
 <tr>
 <th>고객 아이디</th>
 <td>${resArr.id }</td>
 </tr>

 <tr>
 <th>숙박 날짜</th>
 <td>${resArr.startdate}~<br>
 ${resArr.enddate }</td>
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
 <th>지불 방법</th>
 <td>${resArr.pay }</td>
 </tr>


<tr>

<td colspan="2" align="center">
  	
   <input type="submit" class="btn btn1 d-none d-lg-block " id="subBtn" value="수정하기">    													
    <input type="button" class="btn btn1 d-none d-lg-block " id="nextBtn" name="nextBtn" value="다음으로" onclick="location.href='respay?rsno=${resArr.rsno}'">
   <input type="reset" class="btn btn1 d-none d-lg-block " id="btn" value="취소"></td>
</tbody>
</table>
</div>
</form>
</body>
</html>
<%@ include file="../include/footer.jsp" %>