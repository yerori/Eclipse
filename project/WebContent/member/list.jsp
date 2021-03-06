<%@page import="java.util.ArrayList"%>
<%@page import="com.member.model.SMemberDAOImpl"%>
<%@page import="com.member.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %> <!-- header의 연장선~~ -->
<div class="container">
<br>
<h2>회원리스트(<span id="cntSpan">${count }</span>)</h2><br>
 <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>이름</th>
        <th>ID</th>
        <th>전화번호</th>
        <th>EMAIL</th>
        <th>구분</th>
        <th>삭제</th> 
      </tr>
    </thead>
    <!-- 하나하나 돌리고자하는 변수명 : var -->
	<!-- if set = for(일반회원?:"관리자" -->   
    <tbody class="thead-light">
    <c:forEach items="${members }" var ="mem"> 
    
<%--     <c:if test="${mem.admin==0 }"> --%>
<%--      <c:set var="mode" value="일반회원"/> --%>
<%--     </c:if> --%>
<%--      <c:if test="${mem.admin==1 }"> --%>
<%--      <c:set var="mode" value="관리자"/> --%>
<%--     </c:if> --%>
	 <tr>
	  <td>${mem.name }</td>
	  <td>${mem.userid }</td>
	  <td>${mem.phone }</td>
	  <td>${mem.email }</td>
	 <c:if test="${mem.admin==0 }">
    	<td>일반회원</td>
  		<td onclick="delFunc('${mem.userid }')">삭제</td>
    </c:if>
     <c:if test="${mem.admin==1 }">
     <td>관리자</td>
   	 <td></td>
     </c:if>
     
	  <td>${mode }</td>
 	
	  </tr>
	
	</c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="../include/footer.jsp" %>