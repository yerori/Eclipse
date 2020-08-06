<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- build도구 jstl,, c로 이용할것이다 !! 선언 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- choose문 = switch문 -->
<!-- jstl에선 %보다 mod를 많이 쓴다,,, mod==% -->
<!-- c:out 도 출력문, 그냥 달러도 출력문-->

<!--  request말고 다른방법도 있다~~ -->
첫번째 : ${param.num1}  <br/>
두번째 : ${param.num2}  <br/>
<hr/>
결과 : ${param.num1+param.num2 }<br/>
<!-- 변수 지정 : set키워드 사용 set var : 변수 사용한다~~-->
<c:set var="no" value="${param.num1}"/><br/> <!-- cset이 한줄 끝난다 : 마지막에 / 삽입 -->
<!-- num1을 no라는 변수로 지정! -->
no:${no} <br>
<c:out value="${no}"></c:out> 
<c:choose>
 <c:when test="${no mod 2==0}"> <!-- when과 otherwise는 짝지 --> 
	짝수
 </c:when>	
 <c:otherwise>
 	홀수
</c:otherwise>
</c:choose>
<hr>

 <c:if test="${no%2==0 }"> 
	짝수입니다.
 </c:if>
 <c:if test="${no%2!=0 }">
 	홀수입니다.
 </c:if>
</body>
</html>