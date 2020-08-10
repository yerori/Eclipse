<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.login-container{
    margin-top: 5%;
    margin-bottom: 5%;
}
.login-form-1{
    padding: 5%;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-1 h3{
    text-align: center;
    color: #333;
}
.login-form-2{
    padding: 5%;
    background: #0062cc;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-2 h3{
    text-align: center;
    color: #fff;
}
.login-container form{
    padding: 10%;
}
.btnSubmit
{
    width: 50%;
    border-radius: 1rem;
    padding: 1.5%;
    border: none;
    cursor: pointer;
}
.login-form-1 .btnSubmit{
    font-weight: 600;
    color: #fff;
    background-color: #0062cc;
}
.login-form-2 .btnSubmit{
    font-weight: 600;
    color: #0062cc;
    background-color: #fff;
}
.login-form-2 .ForgetPwd{
    color: #fff;
    font-weight: 600;
    text-decoration: none;
}
.login-form-1 .ForgetPwd{
    color: #0062cc;
    font-weight: 600;
    text-decoration: none;
}
</style>
</head>



<script>
$(document).ready(function(){
	

 $("#loginBtn").on("click",function(){
    $.ajax({
	 type:"post",
	 url:"login",
	 data : {"id":$("#id").val(), "pwd":$("#pwd").val()},
	 success : function(value){
		 if(value.trim()==-1){
			 alert("회원이 아닙니다. 회원가입하세요");
			 location.href="join.jsp";
		 }else if(value.trim()==0){
			 location.href="index.jsp";
		 }else if(value.trim()==2){
			 alert("비밀번호를 확인하세요");
			 $("#pwd").focus();
		 }else if(value.trim()==1){
			 alert("관리자님 안녕하세요.");
			 location.href="index.jsp";
		 }
	 },
	 error : function(e){
		 alert("error : "+e );
	 }
 })	//ajax
})	//loginBtn

  $("#signinBtn").on("click",function(){
	  location.href="join.jsp";
  })

});	//document




</script>

<body>



<div class="container login-container">
	<div class="row">
    	<div class="col-md-6 login-form-1">
        	<h3>Login Form</h3>
                <form action="login" method="post">
                   <div class="form-group">
                      <input type="text" class="form-control" placeholder="ID는 필수항목입니다." id="id" value="" required />
                   </div>
            	      <div class="form-group">
                         <input type="password" class="form-control" placeholder="비밀번호는 필수항목입니다." id="pwd" value="" required/>
                      </div>
                        <div class="form-group" align="center">
                         <input type="submit" class="btnSubmit" value="Login" id="loginBtn" />
                        </div>
               	       <div class="form-group" align="center">
                         <input type="button" class="btnSubmit" value="Sign-in" id="signinBtn"/>
                        </div>
                  </form>
           </div>
	 </div>
</div>
</body>
</html>



