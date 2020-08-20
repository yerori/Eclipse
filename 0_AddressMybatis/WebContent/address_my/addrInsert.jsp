<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert.jsp</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#zipBtn").on("click",function(){
	window.open("zipAction.amy","","width=700 height=400");	
	})
})		

</script>
</head>
<body>
<form action="insertAction.amy" method="post" name="frm">

<table>
<tr>
<td>
<a href="listAction.amy">전체보기</a></br>
Servlet_Mybatis
</td>
</tr>

<tr>
<td>주소록 등록하기</td>
<td colspan="2"></td>
</tr>

<tr>
<td>이름</td>   
<td><input type="text" name="name" size=20 id="name"></td>

</tr>

<tr>
<td>우편번호  </td>
<td><input type="text" name="zipcode" size=10 id="zipcode">
	<input type="button" name="zipcodre" value="검색" id="zipBtn" >
</td></tr>


<tr>
	<td>주소</td> 
	<td><input type="text" name="addr" size=30 id="addr"></td>
</tr>

<tr>
<td>전화번호</td>
<td> <input type="text" name="tel" size=20 id="tel"></td>
</tr>

<tr>
<td><input type="submit" value="등록" id="btn">
<input type="reset" value="취소"></td></tr>

</table>
</form>

</body>

</html>