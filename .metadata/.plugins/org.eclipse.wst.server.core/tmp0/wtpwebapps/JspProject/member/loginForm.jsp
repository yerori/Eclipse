<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#loginBtn").click(function(){
		if($("#userid").val()==""){
			alert("아이디를 입력하세요");	
			$("#userid").focus();
			return false;
		}
		if($("#pwd").val()==""){
			alert("비밀번호를 입력하세요");
			$("#pwd").focus();
			return false;
		}
		$.ajax({
			
			type : "post",
			url : "loginPro.jsp",
			data : {"userid" : $("#userid").val(), "pwd":$("#pwd").val()},
			success : function(value){
				
// 				alert(value.trim());
				if(value.trim()==-1){
					alert("회원이 아닙니다. 회원가입 하세요.");
				}else if(value.trim()==0){
			
					$(location).attr("href","memberView.jsp"); //jquery표현
				// =  location.href="memberView.jsp"; 대개 많이 쓰는 ,, 
				}else if(value.trim()==1){
			
					location.href="memberList.jsp";
			    // = $(location).attr("href","memberList.jps");
				}else if(value.trim()==2){
					alert("비밀번호를 확인하세요");
				}					
			},
			error : function(e){
				alert("error :"+e);
			}			
		})		
	});
})
</script>
</head>
<body>
<h2>로그인</h2>
<form method="post" id="frm" action="loginPro.jsp"> <!-- ajax써줬기 때문에 이거 안써줘도 됨,,  -->
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="userid" id="userid"></td></tr>

<tr>
<td>암호</td>
<td><input type="password" name="pwd" id="pwd"></td></tr>


<tr>
<td colspan="2" align="center">
<input type="button" id="loginBtn" value="로그인">
<input type="reset" name="cancel" value="취소">
<input type="button" value="회원가입" onclick="location.href='memberForm.jsp'">
</td>
</tr>
</table>
</form>

</body>
</html>