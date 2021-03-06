<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- ajax 쓰기 위해 src 필요 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- lib에 jstl넣고 이 태그 복붙 -->

<script>
$(document).ready(function(){
	getData(1,"",""); //페이지 로드시 전체 리스트 보여주기
	
	$("#btnSearch").on("click",function(){ //검색버튼 클릭
		getData(1,$("#field").val(),$("#word").val()); //field,word값 가져오기
	})
				
	$("#send").click(function(){ //전송버튼 클릭
		if(${empty sessionScope.login}){
			//sessionScope.login==null
			alert("로그인을 하세요");
			return false;
		}
		var name=$("#name").val();
		var content=$("#content").val();
		var grade=$("input:radio[name=grade]:checked").val(); //radio타입을 ajax함수에서 표현
		var postString= "name="+name+"&content="+content+"&grade="+grade;
		$.ajax({ //콜백함수, 이 화면에 그대로 넣기
			type:"post",
			url:"create.gb",
			data:postString, //{"name":$("#name").val()} : json형태
			success:function(d){
				$("#result").html(d); //태그가 있으면 html로 가져옴
			},
			beforeSend: showRequest, //url가기전에 먼저 처리해랏
			error:function(e){
				alert("error : "+e);
			}
		});
	})
});
function getData(pageNum,field,word){
	$.get("list.gb",
		 {"pageNum":pageNum,"field":field,"word":word},
 	function(d){
		$("#result").html(d);
	})
}

function fdelete(num,name){ //매개변수를 2개 둔 이유는 name의 게시물을 삭제하시겠습니까? 때문인듯.
	if(confirm("["+name+"]의 게시물을 삭제하시겠습니까?")){
		$.get("delete.gb",
		  {"num":num,"name":name},
		//$.get("delete.gb?num="+num, 이케 들고가도됨
			function(d){
			 $("#result").html(d);
			}
		)
	}	
}

function showRequest(){
	if($("#name").val()==""){
		alert("이름을 입력하세요");
		$("#name").focus();
		return false;
	}
	if($("#content").val()==""){
		alert("내용을 입력하세요");
		$("#content").focus();
		return false;
	}
	if($("input:radio[name=grade]:checked").length==0){
		alert("평가를 해주세요");
		return false;
	}
	return true;
}

				//this,contextCount & nameCount
function textCount(obj,target){ 
	var len=$("#"+obj.id).val().length;
	if(obj.size==len){
		alert("글자수 초과");
		return false;
	}
	$("#"+target).text(len);
}
				
function fview(num){
	$.getJSON("view.gb",{"num":num},
	function (d){ //콜백함수
		var htmlStr="";
		htmlStr +="<table>";
		htmlStr +="<tr>";
		htmlStr +="<td>이름</td>";
		htmlStr +="<td>"+d.name+"</td>";
		htmlStr +="</tr>";
		htmlStr +="<tr>";
		htmlStr +="<td>내용</td>";
		htmlStr +="<td>"+d.content+"</td>";
		htmlStr +="</tr>";
		htmlStr +="<tr>";
		htmlStr +="<td>작성일</td>";
		htmlStr +="<td>"+d.created+"</td>";
		htmlStr +="</tr>";
		htmlStr +="</table>";		
		$("#view").html(htmlStr);
		
	});
}




</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin:20px">
<c:if test="${sessionScope.login==null }">
 <a href="login.jsp">로그인</a>
</c:if>

<c:if test="${sessionScope.login!=null }">
  ${login }님 반갑습니다. /
  <a href="logout.gb">로그아웃</a>
</c:if>
</div>

<form method="post" action="create.gb">

<table style="margin:20px">
	<tr>
	<td align="center">글쓴이</td>						<!-- onKeyup:글자수증가 -->
	<td><input type="text" name="name" id="name" maxlength="20" onKeyup="textCount(this,'nameCount')">
	*20글자이내															<!-- this:nameCount가르킴 -->
	(<span id="nameCount" style="color:red">0</span>)
	</tr>
	
	<tr>
	<td align="center">내용</td>
	<td><input type="text" name="content" id="content" maxlength="70" onKeyup="textCount(this,'contentCount')">
	*70글자이내
	(<span id="contentCount" style="color:red">0</span>)
	</tr>
	
	<tr>
	<td align="center">평가</td>
	<td><input type="radio" name="grade"  value="excellent" checked="checked">아주잘함(excellent)
	<input type="radio" name="grade" value="good">잘함(good)
	<input type="radio" name="grade"  value="normal">보통(normal)
	<input type="radio" name="grade"  value="fail">노력(fail)</td>
	</tr>
	<tr>
	<td colspan="2">
	<br>
	<input type="submit" value="submit전송">
	<input type="button" value="ajax전송" id="send"></td>
	</tr>
</table>
</form>
<br><Br>
<div align="center">
<form name="search" id="search">
 <select name="field" id="field">
 <option value="name">이름</option>
 <option value="content">내용</option>
</select>
<input type="text" name="word" id="word">
<input type="button" value="찾기" id="btnSearch" >
</form>
</div>
<br><br>
<div id="result" align="center"></div>
<hr>
<br/>
<div id="view" style="margin:20px"></div>


</body>
</html>