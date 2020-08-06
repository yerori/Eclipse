<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="member.js"></script> <!-- 멤버.js 파일에 jsp읿력하겠다~~~ -->



</head>
<body>
<form action ="memberPro.jsp" method= "post" id="frm">
<input type="hidden" name="uid" id="uid">

<h2>회원가입</h2>

<table>
<tr><td colspan="2">'*'표시 항목은 필수 입력 항목입니다.</td></tr>
<tr><td>이름</td>
	<td><input type="text" name="name" id="name" required>*</td>
</tr>


<tr><td>아이디</td>
	<td><input type="text" name="userid" id="userid" disabled="disabled">*
	<input type="button" name="check" value="중복 체크" id="idBtn" ></td>
</tr>


<tr><td>암호</td>
	<td><input type="password" name="pwd" id="pwd" required>*</td>
</tr>

<tr><td>암호 확인</td>
	<td><input type="password" name="pwd_check" id="pwd_check" required>*</td>
</tr>

<tr><td>이메일</td>
	<td><input type="email" name="email" id="email"></td>
</tr>

<tr><td>전화번호</td>
	<td><input type="text" name="phone" id="phone" ></td>
</tr>

<tr><td>등급</td>
	<td><input type="radio" name="admin" value="0" checked="checked">일반회원 
	<input type="radio" name="admin" value="1">관리자</td>
</tr>
<tr><td colspan="2" align="center"><input type="button" id="send" value="확인">
<input type="reset" value="취소"></td>

</tr>
</table>
</form>
</body>
</html>