<%@page import="com.board.BoardVO"%>
<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
request.setCharacterEncoding("utf-8");
int num=Integer.parseInt(request.getParameter("num"));
BoardDAO dao = BoardDAO.getInstance();
BoardVO board = dao.boardView(num);

%>
</head>
<body>
<h1>글 수정하기</h1>

<form action="updatePro.jsp" method="post">
<!-- update sql엔 num이 있는데, setInt num 안해줬으니 hidden num값주긔 -->
<input type="hidden" name="num" value=<%=num %>>
<table border=1>
<tr>	
	<td>이름</td>
	<td><%=board.getWriter() %></td>
</tr>
		
<tr>	
	<td>제목</td>
	<td><input type="text" name="subject" value="<%=board.getSubject() %>"></td>
</tr>

<tr>	
	<td>이메일</td>
	<td><input type="text" name="email" value="<%=board.getEmail() %>"></td>
</tr>

<tr>	
	<td>내용</td>
	<td><textarea cols="50" rows="10" name="content"><%=board.getContent() %></textarea>
</tr>

<tr>	
	<td>비밀번호</td>
	<td><input type="password" name="passwd"></td>
</tr>

<tr>
	<td colspan="2" align="center">
	<input type="submit" value="글수정">
	<input type="reset" value="다시 쓰기">
	<input type="button" value="목록보기" onclick="location.href='list.jsp'">
	</td>
</tr>

</table>
</form>

</body>
</html>