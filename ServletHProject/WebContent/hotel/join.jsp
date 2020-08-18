<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function() {
		$("#send").click(function(){
			if($("#id").val()==""){
				alert("아이디를 입력하세요");
				$("#id").focus();
				return false;	
			}
			if($("#pwd").val()==""){
				alert("비밀번호를 입력하세요");
				$("#pwd").focus();
				return false;
			}
			if($("#pwd_chk").val()!=($("#pwd").val())){ //!= 쓰기,, match는 반정규화에 해당
				alert("비밀번호를 확인하세요");
				$("#pwd_chk").focus();
				return false;
			}
			if($("#email").val()==""){
				alert("이메일를 입력하세요");
				$("#email").focus();
				return false;
			}
			if($("#address").val()==""){
				alert("주소를 입력하세요");
				$("#address").focus();
				return false;
			}
			if($("#phone").val()==""){
				alert("번호를 입력하세요");
				$("#phone").focus();
				return false;
			}
			$("#form").submit(); //맨마지막에 form에 뿌려주긔
			
		});
			$("#id_checkBtn").click(function() {
				window.open("idCheck.jsp", "", "width=800 height=400");
			});//id_checkBtn 

			$("#zipcode_chk").on("click",function() {
				window.open("../ZIP/jusoPopup.jsp", "",
     				"width=500 height=400");
				})
			$("#send").on("click",function(){
				alert("회원가입을 축하합니다. 로그인 창으로 이동합니다.");
				location.href="login.jsp";
			})
			}); //document 
			
		
	function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
			roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
			detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
			buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.

		$("#address").val(roadFullAddr);
	}
</script>

<style>
form {
	margin: 20px;
}

#form-control {
	size: 50;
}

#container {
	margin: 20px;
	padding: 20px;
	width: 600px;
	height: 800px;
}
</style>

<body>

	
	<form action="insert"
	 method="post" id="form" style="margin: 20px">
		<div class="container">
			<div class="row">
				<div class="col">
					<label for="userid">ID : </label> <input type="text"
						class="form-control" placeholder="Enter userid" id="id" name="id"
						size="20" readonly="readonly">
				</div>
				<div class="col align-self-end">
					<button type="button" id="id_checkBtn" class="btn btn-primary"
						name="id_checkBtn">중복확인</button>
				</div>
			</div>

			<div class="row">
				<div class="col">

					<label for="userid">Password : </label> <input type="password"
						class="form-control" placeholder="Enter password" id="pwd"
						name="pwd" size="20">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="userid">Password Confirm : </label> <input type="text"
						class="form-control" placeholder="Enter password" id="pwd_chk"
						name="pwd_chk">
				</div>
			</div>


			<div class="row">
				<div class="col">
					<label for="userid">Address : </label> <input type="text"
						class="form-control" placeholder="Enter Address" id="address"
						name="address" size="20">
				</div>
				<div class="col align-self-end">
					<button type="button" id="zipcode_chk" class="btn btn-primary"
						name="zipcode_chk">주소입력</button>
				</div>
			</div>

			<div class="form-group">
				<label for="email">Email : </label> <input type="email"
					class="form-control" placeholder="Enter email" id="email"
					name="email">
			</div>
			<div class="form-group">
				<label for="phone">Phone : </label> <input type="tel"
					class="form-control" placeholder="Enter phone" id="phone"
					name="phone">
			</div>

			<Br> <Br>
		
				<button type="button" id="send" class="btn btn-primary">Submit</button>
				<Br>			
			</div>
	</form>


</body>
</html>
<%@ include file="../include/footer.jsp" %>