<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adHeader.jsp" %>    
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
</style>
<body>


<form action="roominsert" method="post" >
<input type="hidden" id="cnum" name="cnum" value="${con.cnum}">
<div id="container" align=center>

<table id="a" border="1">
<tbody>
 <tr>
 <th>방 이름</th>
 <td><input type="text" id="rname" name="rname" size="30"></td>
 </tr>
 <tr>
 <th>최대 성인 인원</th>
   <td><select id="men" name="men">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>                             
  </select></td>
  </tr>
 
 
 <tr>
  <th>최대 아기 수용 인원</th>
  <td><select id="baby" name="baby">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>                             
  </select></td>
 </tr>
 
  <tr>
  <th>가격</th>
 <td>￦<input type="text" id="price" name="price" size="30">원</td>
 </tr>

 <tr>
  <th>사진</th>
 <td><input type="file" id="rimage" name="rimage"></td>
 </tr>

<tr>

<td colspan="2" align="center">
  	
   <input type="submit" class="btn btn1 d-none d-lg-block " id="btn" value="등록하기"> 
   <input type="reset" class="btn btn1 d-none d-lg-block " id="btn" value="취소"></td>
</tbody>
</table>
</div>
</form>
</body>
</html>
<%@ include file="adFooter.jsp" %>