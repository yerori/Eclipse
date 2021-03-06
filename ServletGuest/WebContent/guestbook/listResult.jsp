<%@page import="java.util.ArrayList"%>
<%@page import="com.guest.model.GuestDAO"%> <!-- import 먼저 시키고 -->
<%@page import="com.guest.model.GuestDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- lib에 jstl넣고 이 태그 복붙 -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js" integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J" crossorigin="anonymous"></script>
<!-- 부트스트랩 쓰긔 -->


<h2>Guest Book (${count }개)</h2><br>
<table class="table" style="margin:20px">
  <thead class="thead-dark">
    <tr>
     <th scope="col">번호</th>
     <th scope="col">SEQ</th>
 	 <th scope="col">이름</th>
      <th scope="col">내용</th>
      <th scope="col">등급</th>
      <th scope="col">날짜</th>
      <c:if test="${login!=null }"> <!-- ${login!=null } == sessionScope.login!=null   -->
      <th scope="col">삭제</th>
      </c:if>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${guestbook }" var ="guest" varStatus="st">  <!-- varStatus : 목록값의 위치를 알려줌 -->
  		<!-- listaction에서 request.setAttribute("guestbook",arr)했으니, items에 guestbook담음-->
    <tr>
    <td>${rowNo-st.index }</td>
    <th>${guest.num }</th>
	<td><a href="javascript:fview(${guest.num })">${guest.name }</a></td>
	<td>${guest.content }</td>
	<td>${guest.grade }</td>
	<td>${guest.created }</td>
	 <c:if test="${sessionScope.login!=null }">
	   <td><a href="javascript:fdelete(${guest.num },'${guest.name }')">삭제</a></td>
	 </c:if>
	</tr>
	</c:forEach>	
</table>


<div align="center">
	<c:if test="${pu.startPage > pu.pageBlock }"> <!-- 이전 --> 	<!-- '' : string이니까 붙여주기 -->
	 <a href="javascript:getData(${pu.startPage-pu.pageBlock},'${pu.field }','${pu.word }')">[이전]</a>
	</c:if >
	
	<c:forEach begin="${pu.startPage}" end="${pu.endPage }" var ="i">
	<c:if test="${i==pu.currentPage }"> <!-- 현재 페이지,, i가 현재페이지 의미 -->
		<c:out value="${i }"/>
	</c:if>
	
	<c:if test="${i!=pu.currentPage }"><!-- 현재 페이지 아닌 경우 링크 부여 -->
	 <a href="javascript:getData(${i },'${pu.field }','${pu.word }')">${i }</a>
	</c:if>
	</c:forEach>
	<c:if test="${pu.endPage < pu.totPage }">
	 <a href="javascript:getData(${pu.endPage+1 },'${pu.field }','${pu.word }')">[다음]</a>
	</c:if>
</div>
</body>

</html>