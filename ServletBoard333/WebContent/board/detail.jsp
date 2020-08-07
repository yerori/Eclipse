<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
		$.getJSON("commentlist",	//detail로드되자마자
			{num:$("#num").val()},
			 function(d){
			//	alert(d.carr.length);
			  var htmlStr="";
			  $.each(d.carr,function(key,val){
				  htmlStr += val.userid+" ";
				  htmlStr += val.msg+" ";
				  htmlStr += val.regdate+"<br> ";
			  });
			  $("#commentResult").html(htmlStr);
			}		
		)
	$("#commentBtn").on("click",function(){
		
	 $.ajax({
		type:"get",
		url:"commentInsert",
		data:{"msg":$("#msg").val(),"num":$("#num").val()},
		success:function(d){
			if(d.trim()==1){
		 	 alert("로그인 하세요");
		 	 location.href="login.jsp";
			}else{
				//로긘 안됐을 때 출력값 뿌리긩
				 var htmlStr="";
				 d=JSON.parse(d);
				 $.each(d.carr,function(key,val){
					  htmlStr += val.userid+" ";
					  htmlStr += val.msg+" ";
					  htmlStr += val.regdate+"<br> ";
				  });
				  $("#commentResult").html(htmlStr);
				}		
			},
		error:function(e){
		  alert("error : "+e);
		 }
	   });
	})
})
</script>
</head>
<body>
<form name="form" style="margin:20px">
<h2>"${board.writer }"님의 상세 내용</h2>
<input type="hidden" id="num" value="${board.num }">

<table >
 <tr>
  <th>글번호</th>
  <td>${board.num }</td>
 </tr>

 <tr>
  <th>작성자</th>
  <td>${board.writer }</td>
 </tr>

<tr>
  <th>제목</th>
  <td>${board.subject }</td>
 </tr>
 
 <tr>
  <th>내용</th>
  <td>${board.content }</td>
 </tr>
 
 <tr>
  <th>작성일</th>
  <td>${board.reg_date }</td>
 </tr>
 
 <tr>
  <th>조회수</th>
  <td>${board.readcount }</td>
 </tr>
 
 <tr align="center">
  <td colspan="2">
  <input type="button" value="수정">
  <input type="button" value="삭제"> 
 </tr>
</table>

<div align="center">
<br><br>
 <textarea rows="5" cols="50" id="msg"></textarea>
 <input type="button" value="write Comment" id="commentBtn">
</div>

<div id="commentResult"></div>

</form>
</body>
</html>