<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Server</title>
</head>

<%
 String name = request.getParameter("name"); //요청 : request 매개변수 : Parameter
 String addr = request.getParameter("addr");
%>

<body>
결과<hr>
이름 : <% out.println(name); %><br>
주소 : <% out.println(addr); %>
<hr>
두번째 결과<br>
이름 :<%=name %><br>      
주소 :<%=addr %>
</body>
</html>