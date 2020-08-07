<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<form name="form" style="margin:20px;">
<h2>"${board.writer }""님의 상세 내용</h2>
<input type="hidden" name="num" value=${board.num }>
<table style="margin:20px">
 <tr>
  <th>작성자</th>
  <td><input type="text" name="detailWriter" value=${board.writer }></td>
 </tr>

<tr>
  <th>제목</th>
  <td>${board.subject }</td>
 </tr>
 
 <tr>
  <th>내용</th>
  <td>${board.content }</td>
 </tr>
 
 <tr>
  <th>작성일</th>
  <td>${board.reg_date }</td>
 </tr>
 
 <tr>
  <th>조회수</th>
  <td>${board.readcount }</td>
 </tr>
 
 <tr>
  <td colspan="2">
  <input type="submit" value="수정">
  <input type="button" value="삭제" id ="deleteBtn" name="deleteBtn"> 
 </tr>
</table>
</form>
</body>
</html>