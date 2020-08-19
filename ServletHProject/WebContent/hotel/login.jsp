<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
#container{
 	margin:0 auto; 
 	padding:20px; 
 	height:600px;
 	width:800px;

 	}
</style>

<script>
$(document).ready(function(){
 if($("#id").val==""){
	alert("ID를 입력하세요");
	$("#id").focus();
	return false;
 }
 if($("#pwd").val==""){
	 alert("비밀번호를 입력하세요");
	 $("#pwd").focus();
	 return false;
 }
 $("#send").on("click",function(){
    $.ajax({
	 type:"post",
	 url:"login",
	 data : {"id":$("#id").val(), "pwd":$("#pwd").val()},
	 success : function(value){
		 if(value.trim()==-1){
			 alert("회원이 아닙니다. 회원가입하세요");
			 location.href="join.jsp";
		 }else if(value.trim()==0){ //일반회원
			 location.href="hiltonindex.jsp";
		 }else if(value.trim()==2){
			 alert("비밀번호를 확인하세요");
		 }else if(value.trim()==1){
			 alert("관리자님 안녕하세요.");
			 location.href="../admin/adIndex.jsp";
		 }
	 },
	 error : function(e){
		 alert("error : "+e );
	 }
 })	//ajax
})	//loginBtn

});	//document




</script>

<body>
<form id="container" action="login" method="post">
<div  style="text-align:center">
	 <div class="row">
<div class="col">
    <label for="userid">ID : 
    <input type="text" class="form-control" placeholder="Enter userid" id="id" name="id" size="30"></label>
    <br>
 	</div>
 	</div>
 	
 	
 	 <div class="row">
    <div class="col">

    <label for="userid">Password : 
    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pwd" size="40"></label>
 	</div> 
 	</div>
<!--  	</div>  -->
<!--  <tr> -->
<!--   <td><b>PW</b></td> -->
<!--   <td><input type="password" name="pwd" id="pwd" placeholder="ID는 필수항목입니다." required></td> -->
<!-- </tr> -->
 
 <Br>

  <button id="send" name="send" class="btn btn-primary">로그인</button>
  <input type="button" value="회원가입" id="signinBtn" class="btn btn-primary" onclick="location.href='join.jsp'">
  <Br>

</div>

</form>


</body>
</html>
<%@ include file="../include/footer.jsp" %>


