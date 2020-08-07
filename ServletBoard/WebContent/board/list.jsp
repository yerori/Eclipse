<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.board.model.BoardDTO"%> 
<%@page import="com.board.model.BoardDAOImpl"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous"> 
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/js/bootstrap.min.js" integrity="sha384-XEerZL0cuoUbHE4nZReLT7nx9gQrQreJekYhJD9WNWhH8nEW+0c5qq7aIo2Wl30J" crossorigin="anonymous"></script> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script> 
  $(document).ready(function(){ //로드하자마자 실행하자 
 	 getData(1,"",""); 
	  
 	$("#searchBtn").on("click",function(){ 
  		getData(1,$("#field").val(),$("#word").val()); 
	})
	
  })
 function getData(pageNum,field,word){ 
  	$.get("list", 
		{"pageNum":pageNum,"field":field,"word":word}, 
		function(d){ 
		$("#result").html(d); //list.jsp가 뿌려짐 
		}) 
	} 



</script>
</head>


<body>
  <div id="result"></div><br>
  <div align="left" style="margin:20px">
  <form name="search" id="search">
   <select name="field" id="field" >
   	<option value="writer">작성자</option>
  	<option value="subject">제목</option>
   </select>
   <input type="text" name="word" id="word">
   <input type="button" value="찾기" id="searchBtn">
   <br><br>
   </form>
  </div>
  
   
  
</body>
</html>
 