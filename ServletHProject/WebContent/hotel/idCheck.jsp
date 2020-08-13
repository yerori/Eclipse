<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="/project/js/member.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script>
$(document).ready(function(){
	$("#idCheckBtn").on("click",function(){
		if($("#id").val()==""){
			alert("id를 입력하세요!");
			$("#id").focus();
			return false;
		}
		$.ajax({
			 type:"post",
			 url:"idcheck",
			 data:{"id":$("#id").val()},
			 success : function(d){
				if(d.trim()=="no"){
					alert("사용 불가능한 아이디입니다.");
				}else{
					alert("사용 가능한 아이디입니다.");
				$(opener.document).find("#id").val($("#id").val());
				$(opener.document).find("#uid").val($("#id").val());
				//hidden값인 uid에 id값 대입
				
				self.close();
				}
			},
			error : function(e){
				alert("error : "+e);
			}
		})				
	})
});


</script>

<style>
.row{
	padding:20px;
	margin:20px;
}

</style>
<div class="row">
  <div class="col">
  <h3>아이디 중복 확인</h3>
  <label for="userid"> ID : </label>
  <input type="text" class="form-control" id="id" name="id">
  </div>
  
  <div class="col align-self-end">
  <button id="idCheckBtn" class="btn btn-primary" name="idCheckBtn">중복 확인</button>
  </div>

</div>