<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="updateAction.amy" method="post" name="frm">
<input type="hidden" name="num" value=${address.num }>

<table>
<tr>
	<td colspan="2">Servlet_Mybatis 주소록 상세보기</td>
</tr>

<tr>
<td>이름</td>
<td><input type="text" name="name" value=${address.name }></td>
</tr>

<tr>
<td>우편번호</td>
<td><input type="text" value=${address.num }>
<input type="button" value="검색" onclick="zipfinder()"></td>
</tr>
	<tr>
	<td>주소</td>
	<td><input type="text" name="addr" value=${address.addr }></td>
	</tr>
	
	<tr>
	<td>전화번호</td>
	<td><input type="text" name="tel" value=${address.tel }></td>
	</tr>
	
	<tr>
	<td colspan="2"><input type="submit" value="수정">
	<input type="button" value="삭제" onclick="location.href='delete.amy?num=${address.num }'">
	<input type="reset" value="취소">
</td></tr>

</table>
</form>


</body>
</html>