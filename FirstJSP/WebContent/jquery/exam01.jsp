<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
%>
</head>
<body>

<form action="exam01.jsp" method="post" name="form">
id : <input type="text" id="id" name="id"><br>
pwd : <input type="password" id="pwd" name="pwd"><br>
<input type="submit" id="postBtn" value="post전송">
</form>
</body>
</html>