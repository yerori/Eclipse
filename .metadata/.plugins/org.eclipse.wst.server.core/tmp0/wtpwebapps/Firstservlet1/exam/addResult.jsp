<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
int num1 =Integer.parseInt(request.getParameter("num1"));
int num2 =Integer.parseInt(request.getParameter("num2"));
%>
</head>
<body>
합 : <%=num1+num2 %>
</body>
</html>