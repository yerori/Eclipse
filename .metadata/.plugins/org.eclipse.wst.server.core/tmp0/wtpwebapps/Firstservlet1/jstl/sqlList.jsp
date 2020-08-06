<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sql로 선언,,  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>												<!-- application영역 : 톰캣이 가지는 영역 -->
<sql:setDataSource dataSource="jdbc/member" var="dataSource" scope="application"/>
<sql:query var="resultSet" dataSource="${dataSource}">
select * from jstlmember 
</sql:query>
<table border="1">
<tr>
<c:forEach items="${resultSet.columnNames}" var="columnNames">
 <th>${columnNames}</th>
</c:forEach>
</tr>
<c:forEach items="${resultSet.rowsByIndex}" var="row">
 <tr>
 <c:forEach items="${row}" var="column">
  <td>${column }</td>
 </c:forEach> 
 </tr>
</c:forEach>


</table>

</body>
</html>