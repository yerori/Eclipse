<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- jquery쓰겠다 -->
<script>
$(function(){
	$("#zipBtn").click(function(){
		window.open("zipCheck.jsp","","width=800 height=500");
	})
});
</script>
</head>
<body>
<form>
<a href="list.jsp">전체보기</a>
<table>
<tr> <td>주소록 등록하기</td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" id="name" size="20"></td>
</tr>

<tr>
<td>우편번호</td>
<td><input type="text" name="zipcode" id="zipcode" size="10">
<input type="button" value="검색" id="zipBtn"></td>
</tr>

<tr>
<td>주소</td>
<td><input type="text"  id="addr" size="50"></td>
</tr>

<tr>
<td>전화번호</td>
<td><input type="text"  id="tel" size="20"></td>
</tr>

<tr>
<td><input type="submit" value="등록"><input type="reset" value="취소"></td>
</tr>
</table>
</form>
</body>
</html>