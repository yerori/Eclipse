<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adHeader.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<script>


</script>
<style>
#container{
	margin:0 auto;
	padding:30px;
	text-align:center;
}

#h4{
	padding:20px;
}
</style>
<body>
<input type="hidden" name="userid" value="${con.id}">
 <div id="container">
  <h4 id="h4">작성된 글 : 총 <span id="cntSpan">${count }개</span></h4>
  
<table class="table table-striped">
<thead class="thead-dark">

	<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
	<td>이메일</td>
	<td>내용</td>
	</tr>
   </thead>
  <tbody>	
	
	
  <c:forEach items="${conarr }" var="content">
  <tr>
	<td>${content.cnum }</td>
	<td><a href="condetail?cnum=${content.cnum}">${content.subject }</a></td>
	<td>${content.id }</td>
	<td>${content.email }</td>
	<td>${content.content }</td>
	</tr>
	</c:forEach></tbody>
</table>
</div>

<div align = "center" > <br>
	  	<c:if test = "${pu.startPage>pu.pageBlock}"> <!-- 이전-->
	  		<a href = "conlist?pageNum=${pu.startPage-pu.pageBlock}">[이전]</a>
	  	</c:if>
	  	<c:forEach begin ="${pu.startPage}" end = "${pu.endPage}" var = "i"> <!-- 이전-->
  			<c:if test ="${i==pu.currentPage}"> <!-- 현재페이지-->
 				<c:out value = "${i}"/>
  			</c:if>
  			<c:if test = "${i!=pu.currentPage}"> <!-- 현재페이지 아닌 경우 링크 부여-->
  				<a href = "conlist?pageNum=${i}">${i}</a>
  			</c:if>
	  	</c:forEach>
	  	<c:if test = "${pu.endPage < pu.totPage}"> <!-- 다음-->
	  		<a href = "conlist?pageNum=${pu.endPage+1}">[다음]</a>
	  	</c:if>
	  </div> 
<div id="result"></div>
</body>
</html>
<%@ include file="adFooter.jsp" %>