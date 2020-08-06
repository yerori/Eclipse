
var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/; //전화번호 양식

$(document).ready(function(){
	$("#send").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		//아이디 , 비번, 전화번호 
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
		
		if(!$("#pwd_check").val().match($("#pwd").val())){
			alert("비밀번호를 확인하세요");
			$("pwd_check").focus();
			return false;
		}
		
		if($("#email").val()==""){
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
		
//		if($("pwd_check").val()!=$("#pwd").val()){
//			alert("비밀번호를 다시 입력하세요");
//		}
//		
		if(!$("#phone").val().match(exp)){
			alert("전화번호 입력 양식이 아닙니다.");
			$("#phone").focus();
			return false;
		}
		
		$("#frm").submit();
	});	//send
	
	
	//아이디중복확인 버튼 클릭
	$("#idBtn").click(function(){
		window.open("idCheck.jsp","","width=800 height=500");
	}); //idBtn
	
	
	//아이디 중복확인
	$("#idCheckBtn").click(function(){
		if($("#userid").val()==""){
		alert("id를 입력하세요!");
		$("#userid").focus()
		return false;
		}
		$.ajax({
		 type:"post",
		 url : "idCheckPro.jsp",
		 data : {"userid" : $("#userid").val()},
		 success : function(d){
			if(d.trim()=="no"){
				alert("사용 불가능한 아이디입니다.");
				

				
			}else{
				alert("사용 가능한 아이디입니다.");			
			$(opener.document).find("#userid").val($("#userid").val());	// disabled는 값 전달이 x
			$(opener.document).find("#uid").val($("#userid").val()); 
			//hidden값만듦 , userid의 값을 uid에 대입 (uid=userid)
			
			self.close();
			}
		 },
		 error : function(e){
			 alert("error : "+e);
		 }
		});		
	})
			
})//document

	function del(userid,mode){
		if(confirm("정말 삭제하겠습니까?")){	
		if(mode=="관리자"){
			alert("관리자는 삭제할 수 없습니다.");
			return;
		}
		$.getJSON("memberDelete.jsp",{"userid":userid},
			function(data){ // data: 결과값 
				var htmlStr="";				
				$.each(data.jarr,function(key,val){ //jarr의 결과값
					htmlStr+="<tr>";
					htmlStr+="<td>"+val.name+"</td>";
					htmlStr+="<td>"+val.userid+"</td>";
					htmlStr+="<td>"+val.email+"</td>";
					htmlStr+="<td>"+val.phone+"</td>";
					htmlStr+="<td>"+val.mode+"</td>";
//					<td> <a href="javascript:del('<%=vo.getUserid()%>','<%=mode %>')">삭제</a></td>
					htmlStr+="<td><a href=javascript:del('"+val.userid+"','"+val.mode+"')>삭제2</a></td>";	
//					<td><a href="javascript:del('val.userid','val.mode')">삭제2</a></td>
					htmlStr+="</tr>";					
				})	
				$("table tbody").html(htmlStr);		
				$("#cntSpan").text(data.cntObj.count);
		
			}			
		);
	}

}

