<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adHeader.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#result{
	padding:30px;
}

</style>
<script>
$(document).ready(function(){
	getData(1);

})//document

function getData(pageNum){
	$.get("roomlist",
	  {"pageNum":pageNum},
		 function(d){
		   $("#result").html(d);
	})
}

</script>
<body>

<div id="result">
</br></br>
</div>
</body>
</html>
<%@ include file="adFooter.jsp" %>