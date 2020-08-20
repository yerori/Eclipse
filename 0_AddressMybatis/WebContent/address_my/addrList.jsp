
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>
$(document).ready(function(){
	$("#btnSearch").on("click",function(){
		$.getJSON("searchAction.amy",
			{"field":$("#field").val(), "word":$("#word").val()},
			  function(data){
				$("#count").html("검색된 총 게시물 수 : "+data.count); //검색한 data 개수
				var htmlStr ="";
				$.each(data.arr, function(key,val){ //val을 value로 하면 X 
					htmlStr+="<tr>";
					htmlStr+="<td>순서</td>";
					htmlStr+="<td>"+val.num+"</td>";
					htmlStr+="<td>"+val.name+"</td>";
					htmlStr+="<td>"+val.addr+"</td>";
					htmlStr+="<td>"+val.tel+"</td>";
					htmlStr+="</tr>";
				})
				$("table tbody").html(htmlStr);
				
			} //func
		) //json
	}) //btn	
})//doc



function fdelete(num){
	if(confirm("삭제하시겠습니까?")){
		$.getJSON("deleteAjaxAction.amy?num="+num,
		  function(data){
			$("#count").html("검색된 총 게시물 수 : "+data.count); //검색한 data 개수
			 var htmlStr ="";
			  $.each(data.arr, function(key,val){ //val을 value로 하면 X 
				htmlStr+="<tr>";
				htmlStr+="<td>순서</td>";
				htmlStr+="<td>"+val.num+"</td>";
				htmlStr+="<td>"+val.name+"</td>";
				htmlStr+="<td>"+val.addr+"</td>";
				htmlStr+="<td>"+val.tel+"</td>";
				htmlStr+="<td onclick="+fdelete("+num+")"+"삭제</td>";
	//			<td onclick="fdelete(${address.num})">삭제</td>
				htmlStr+="</tr>";
			});
			$("table tbody").html(htmlStr);
			}	
		)			
	}
}

</script>

</head>
<body>
<a href="addrInsert.jsp" >글쓰기</a></br>
<div></br> 게시글 개수 : 총 <span id="count">${count }개</span></div>

<table>
 <thead>
 <tr>
  <td>개수</td>
  <td>번호</td>
  <td>이름</td>
  <td>주소</td>
  <td>전화번호</td> 
  <td>삭제</td>
 </tr> 
</thead>
<tbody>
<c:forEach items="${arr }" var="address" varStatus="st">
<tr>
 <td>${count-st.index }</td>
 <td>${address.num }</td>
 <td><a href="viewAction.amy?num=${address.num }">${address.name }</a></td>
 			<!--  값을 줘야 받아오징!! -->
 <td>${address.addr }</td>
 <td>${address.tel }</td>
 <td onclick="fdelete(${address.num})">삭제</td>

</tr>
</c:forEach>
</tbody>
</table>
<br><br><br><br><br>
<div align="center">
 <form name="search" id="search">
  <select name="field" id="field">
   <option value="name">이름</option>
   <option value="tel">전화번호</option>
  </select>
  <input type="text" name="word" id="word">
  <input type="button" value="찾기" id="btnSearch">
 </form>
</div>
</body>
</html>








