<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
${sessionScope.userid}님 반갑습니다.
<a href="logout.me">로그아웃</a><br><br>
<a href="../board/list.me">게시판으로</a>

<h5>회원정보 변경 / <a href="delete.me">회원탈퇴</a></h5>
<form action="update.me" method="post">
<input type="hidden" name="userid" value="${member.userid}">

<table>
 <tr>
  <td>이름</td>
  <td><input type="text" id="name" name="name" value="${member.name }"></td>
 </tr>
  <tr>
  <td>아이디</td>
  <td><input type="text" id="name" name="name" readonly="readonly" value="${member.userid }"></td>
 </tr>
 <tr>
 <td>비밀번호</td>
  <td><input type="password" id="pwd" name="pwd" disabled="disabled" value="${member.pwd }"></td>
 </tr>

<tr>
<td>이메일</td>
  <td><input type="email" id="email" name="email" value="${member.email }"></td>
 </tr>

	
<tr>
<td>전화번호</td>
  <td><input type="tel" id="phone" name="phone" value="${member.phone }"></td>
 </tr>

<tr>
 <td>등급</td>
 <td>
 
 <input type="radio" name="admin" value="0">일반회원
  <input type="radio" name="admin" value="1">관리자
 <script>
 	 if(${member.admin==0}){
		 $("input:radio[value='0']").prop("checked",true);
		 
	 }else{
		 $("input:radio[value='1']").prop("checked",true);
	 }
	  
 </script>
 </td>
</tr>
<tr>
<td>
	<td colspan="2" align="center">
	<input type="submit" id="btn btn-primary" value="수정">
	<input type="reset" value="취소">
</td>
</tr>
 
</table>


</form>

</body>
</html>