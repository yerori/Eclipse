<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 콜백함수</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script> 
<script>
$(document).ready(function(){
	$("#b1").click(function(){
		$.get("data.txt",function(data,status){
			//alert("data : "+data+"\n status : "+status) //status : 성공이냐 실패냐 
			if(status=="success"){
				alert("성공입니다!!");
			}	else{
				alert(status);
			}
			var str = "데이터 : "+data+"\n 처리상태 : "+status
			$("#result").text(str); //data -> json형식으로 보내줌
		}
		);//get
	})//b1
	$("#b2").click(function(){
		var htmlStr="";
		$.getJSON("data.txt",function(data){
		$.each(data,function(key,val){ //for each문같은,, 
			htmlStr+="회원번호 : "+val.memberNumber +"<br>";
			htmlStr+="번호 : "+val.irum +"<br>";
			htmlStr+="이미지 : "+val.picture +"<hr>";
		})                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		$("#result").html(htmlStr);                     
		}); // 파싱처리돼서 옴
	})//b2
});
</script>
</head>
<body>
<button id="b1">결과</button> 
<button id="b2">결과2</button> 

<div id="result"></div>

</body>
</html>