<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- cdm방식 -->


<script>
$(document).ready(function(){
	$("button").click(function(){ // id만 달러 표시
		$("#displayArea").html("<img src='pf.jpg' border=0>"); //html이용해서 태그 생성
	
	//this-> 여기서 button을 의미
	alert($(this).text()); //text() 괄호 안에 암것도 없으면 순수 값을 가져옴(get)
						   // ()안 글자 있을 시-> set 역할
	$(this).text("여기도 바뀔까");
	}); //button
	
	$("#txtBtn").on("click",function(){
		alert($("#txt").val())
		$("#txt").val("txt내용 변경"); // 초기값-> txt내용 변경
	});
});//document
</script>
</head>
<body>
<div id="displayArea">이곳의 내용이 변경</div>
<button>표시</button><br>
<input type="text" id="txt"  value="초기값"><br>
<input type="button" value="txt클릭" id="txtBtn">
</body>
</html>