var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;

$(document).ready(function(){
	$("#send").click(function(){
		if($("#userid").val()==0){
		alert("이름을 넣어주세요");
		$("#userid").focus;
		return false;
	}	
		
		if($("#userid").val()==0){
		alert("아이디를 입력하세요");
		$("#userid").focus;
		return false;
	}
		if($("#name").val()==0){
			alert("이름을 입력해주세요");
			$("#name").focus;
			return false;
		}
		if($("#pwd").val()==0){
			alert("비밀번호를 입력해주세요");
			$("#pwd").focus;
			return false;
		}
	//비번확인
		if($("#pwd").val()!=$("#pwd_check").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd").focus;
			return false;
		}
		
		if($("#email").val()==0){
			alert("이메일을 입력해주세요");
			$("#email").focus;
			return false;
		}
		if(!$("#phone").val().match(exp)){
			alert("전화번호 입력 양식이 아닙니다.");
			$("#phone").focus;
			return false;
		}
		$("#frm").submit();
	});			
	//id중복확인 버튼 클릭
		$("#id_checkBtn").click(function(){
			window.open("idCheck.me","","width=700 height=250");
		});
		
	//중복확인 page이동
	$("#useBtn").click(function(){
		if($("#userid").val()==""){
			alert("ID를 입력하세요");
			$("#userid").focus();
			return false;
		}
	
		$.ajax({
			type:"post",
			url:"idCheck.me",
			data:{"userid":$("#userid").val()},
			success:function(val){
				if(val.trim()=="yes"){
					alert("사용가능");
				$(opener.document).find("#userid").val($("#userid").val());
				$(opener.document).find("#uid").val($("#userid").val());
				self.close();
				}else if(val.trim()=="no"){
					alert("사용불가능");
					$("#userid").val("");
				}
			},
			error : function(e){
				alert("error :"+e);
			}
		});
	
	})
})
function delFunc(userid){
	if(confirm("정말 삭제할까요?")){
		$.getJSON("userDelete.me?userid="+userid, function(data){
		var htmlStr="";
		$.each(data.root, function(key,val){
			htmlStr+="<tr>";
			htmlStr+="<td>"+val.name+"</td>";
			htmlStr+="<td>"+val.userid+"</td>";
			htmlStr+="<td>"+val.phone+"</td>";
			htmlStr+="<td>"+val.email+"</td>";
			htmlStr+="<td>"+val.mode+"</td>";
			if(val.mode=='일반회원'){
				htmlStr+="<td onclick=del('"+val.userid+"')>삭제</td>";
			}else{
				htmlStr+="<td></td>";
			}
			htmlStr+="</tr>";					
		})
		$("table tbody").html(htmlStr);
	})
	}	
}
