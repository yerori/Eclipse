<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>콜백함수</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script> 
<script>
$(document).ready(function(){
	$("#postBtn").click(function(){
		$.post("process.jsp",{"id":document.getElementById("id").value, // = "id":$("#id").val()
			 "pwd":$("#pwd").val(), "method":"post"},//form action과 동일
			function(data){ //콜백함수 (결과값)
			$("#postResult").html(data);
			}
		); 
	}); //postBtn
	
	$("#getBtn").click(function(){
		$.get("process.jsp",{
			"id":$("#id").val(),"pwd":$("#pwd").val(),"method":"get"},
			function(getre){
				$("#getResult").html(getre);
			}
		)//get
	})//getBtn
	
	$("#loadBtn").click(function(){ 
		$("#loadResult").load("process.jsp",{"id":$("#id").val(),"pwd":$("#pwd").val(),"method":"load"
			//load -> 어차피 result에 콜백돼서, function() 없음
			
			}
		);
	})	
	
	$("#ajaxBtn").click(function(){
		
		$.ajax({
			type:"post",
			url :"process.jsp",
			data : {
				"id" :$("#id").val(),
				"method" :"ajax"
				
			},
			success : function(d){
				$("#ajaxResult").html(d);
			},
			error:function(e){
				alert("error : "+e);
			}
		})//ajax
	});	//ajaxBtn
}); //document
</script>
</head>
<body>


id : <input type="text" id="id" name="id"><br>
pwd : <input type="password" id="pwd" name="pwd"><br>
<input type="button" id="postBtn" value="post전송"> 
<input type="button" id="getBtn" value="get전송"> 
<input type="button" id="loadBtn" value="load전송"> 
<input type="button" id="ajaxBtn" value="ajax전송"> 
<div id="getResult"></div>
<div id="postResult"></div>
<div id="loadResult"></div>
<div id="ajaxResult"></div>

</body>
</html>