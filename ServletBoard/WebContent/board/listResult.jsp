<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="margin:20px">게시판</h2>
<table class="table" style="margin:20px"> 
  <thead class="thead-dark">
  <tr>
   <th>번호</th>
   <th>작성자</th>
   <th>내용</th>
   <th>제목</th>
   <th>작성일</th>
   <th>조회수</th>
  </tr>
  </thead>  
 
  <tbody>
<c:forEach items="${arr }" var ="board">
  <tr>
   <td>${board.num }</td>
   <td><a href="detail?num=${board.num }">${board.writer }</a></td>
   <td>${board.content }</td>
   <td>${board.subject }</td>
   <td>${board.reg_date }</td>
   <td>${board.readcount }</td>
  </tr>
  </c:forEach>
  
  </tbody>
 </table>
 

     <div align="center" style="margin:20px">
    <c:if test="${pu.startPage>pu.pageBlock }">
     <a href="javascript:getData(${pu.startPage-pu.pageBlock},'${pu.field }','${pu.word }')">[이전]</a>
    </c:if>
    
    <c:forEach begin="${pu.startPage }" end="${pu.endPage }" var="i">
    <c:if test="${i==pu.currentPage }">
    	<c:out value="${i }" />
    </c:if>   
    
    <c:if test="${i!=pu.currentPage }">
      <a href="javascript:getData(${i },'${pu.field }','${pu.word }')">${i }</a>
    </c:if> 
     </c:forEach>
    <c:if test="${pu.endPage>pu.totPage }">
     <a href="javascript:getData(${pu.endPage+1},'${pu.field }','${pu.word }')">[다음]</a>
    </c:if>
   </div>
   
   <hr> 
</body>
</html>
