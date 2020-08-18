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

function delFunc(rno){
	if(confirm("정말 삭제할까요?")){
		alert("삭제되었습니다.");
		location.href="roomdelete?rno="+rno;
	}
}
</script>
<style>
.btn btn1 d-none d-lg-block{
	width:100px;
}
#btn, #delBtn{
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
#img{
	padding:10px;
	width:400px;
}
</style>



<body>


<form action="roomupdate" method="post" >

<div id="container" align=center>
<h3 id="p">${room.rname } 룸 수정</h3><br>
<table id="a" border="1">
<tbody>
 <tr>
 <th>방번호</th>
 <td><input type="text" id="rno" name="rno" readonly="readonly" size="50" value="${room.rno }"></td>
 </tr>
 <tr>
 <th>방이름</th>
 <td><input type="text" id="rname" name="rname" size="50"  value="${room.rname }">
 </td>
 </tr>
 
 <tr>
  <th>최대 성인 수용 인원</th>
 <td>    <select name="tot_ad" id="tot_ad">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
         </select>
         <script>
    $("#tot_ad option").each(function(){
    	if($(this).val()=="${room.tot_ad }"){
    	$(this).prop("selected",true);
    	}
    })
    </script></td>
 </tr>
 
 <tr>
  <th>최대 아기 수용 인원</th>
 <td><select name="tot_ch" id="tot_ch">
 		  <option value="1">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
         </select>
          <script>
    $("#tot_ch option").each(function(){
    	if($(this).val()=="${room.tot_ch }"){
    	$(this).prop("selected",true);
    	}
    })
    </script>
 </tr>

 <tr>
  <th>가격</th>
 <td><input type="text" id="price" name="price" size="50"  value="${room.price }"></td>
 </tr>
 
  <tr>
  <th>이미지</th>
 <td><img src="../hotel/assets/img/room/${room.rimage }" id="img"></br><input type="file" id="rimage" name="rimage" id="img"></td>
 </tr>
<tr>
<td colspan="2" align="center">
   <input type="submit" class="btn btn1 d-none d-lg-block " id="btn" value="수정"> 
   <input type="button"  class="btn btn1 d-none d-lg-block " id="delBtn" value="삭제" onclick="delFunc('${room.rno }')">
</tbody>
</table>
</div>
</form>
</body>
</html>
<%@ include file="../include/footer.jsp" %>