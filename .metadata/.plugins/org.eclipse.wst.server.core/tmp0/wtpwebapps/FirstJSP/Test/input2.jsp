<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- cdm 방법 : src를 주솔 -->

<!-- <script src="../js/jquery-3.5.1.min.js"> </script> <!-- 상위 폴더 조회 : ..  -->
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script> 
// jQuery 시작 : $로 표시 ,,  // form밑에다 선언 
/*
$(document).ready(function(){ // 버튼이 밑에 있으니 준비할때까지 기다려랑!
	$("#btn").click(function(){ // button이 선언돼있는 행 밑인 /form 다음에 선언하거나, 
		 alert("test");			// $(document).ready(function(){와 같이 선언해놓거나!!
	});  	
})*/

$(function(){ // $(function(){ = $(document).ready(function(){ 
	$("#btn").on("click",function(){ //.on("click")~ 웅앵 이 방식을 젤 많이 쓴당
		
	
		if($("#name").val()==""){ // $("#name") = getElementById("name")
			alert("이름을 입력하세요.");      // value=val
			return false; //return = return false
			}	//if
			
		if($("#studentNum").val()==""){ // $("#name") = getElementById("name")
		alert("학번을 입력하세요.");      // value=val
		return;
			}
		if($("input[name='hobby']:checked").length==0){
			alert("취미를 입력하세요.");		
				return false;
			}//if
			//form.submit();
		$("#form").submit();

		}); //click
	
	})//function

</script>
</head>
<body>

<!--메소드에는 get, post방식이 있다.!!! -->
<form action="inputResult.jsp" method="post" name="form" id="form"> <!-- ★ get은 기본적인 메소드 : 주소 전부다 주소창에 기입됨-->
 
이름 : <input type="text" name="name" id="name"><br>
학번 : <input type="text" name="studentNum" id="studentNum"><br> 
<br>
성별 :
 <input type = "radio" name = "gender" value = "남자" checked  id="man">
<label for="man">남자</label>
<input type = "radio" name = "gender" value = "여자" id="feman">
<label for="feman">여자</label> 


<br>
전공 : <select name="major" id = "major"> <!-- size : 보이는 칸의 수, multiple : 다중선택 -->
<option value="국문학과" selected>국문학과</option>
<option value="영문학과">영문학과</option>
<option value="수학과"  >수학과</option>
<option value="정치학과">정치학과</option>
<option value="체육학과">체육학과</option>
</select>
<br>
취미<br>
<input type="checkbox"name="hobby" value="운동">운동
<input type="checkbox"name="hobby" value="운동1">운동1
<input type="checkbox"name="hobby" value="운동2">운동2
<input type="checkbox"name="hobby" value="운동3">운동3
<input type="checkbox"name="hobby" value="운동4">운동4


<input type="button" value="보내기" id="btn"> <!-- 버튼은 모양만 버튼 ,, ()속 빈공간 : 인자가 없는 함수로 만들기 -->
<input type="reset" value="취소">

</form>

</body>
</html>