<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
이름 : ${p.name}<br> <!-- p.name=getname같은 역할,, -->
아이디 : ${p.id}<br>
성별 : ${p.gender}<br>
직업 : ${p.job}<br>
메일 : 
<c:forEach items="${p.notice}" var="mail"> <!-- mail의 주솟값이 아닌 value값 나오게끔,, -->
 ${mail}<br>
</c:forEach>
${msg}
</body>
</html>