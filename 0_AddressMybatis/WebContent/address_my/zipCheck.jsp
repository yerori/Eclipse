<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>
$(document).ready(function(){
	$("#send").on("click",function(){
	  if($("#dong").val()==""){
		 alert("동 이름을 입력하세요.");
		 return false;
	  }
	  // 요즘에 하는 방식~~
	 $.post("zipAction.amy",{"dong":$("#dong").val()})

	  .done(function(data){  // post가 끝나면 이걸 진행해라~
		  var res = JSON.parse(data);
		  var htmlStr="";
		  var htmlStr="<table>";
			$.each(res.zarr,function(key,val){
			 var bunji = val.bunji==null?"":val.bunji; //undefined 나온 경우를 위해
			 var gugun = val.gugun==null?"":val.gugun;
			  
			  htmlStr+="<tr>";
			  htmlStr+="<td>"+val.zipcode+"</td>";
			  htmlStr+="<td>"+val.sido+"</td>";
			  htmlStr+="<td>"+gugun+"</td>";
			  htmlStr+="<td>"+val.dong+"</td>";
			  htmlStr+="<td>"+bunji+"</td>";
			  htmlStr+="</tr>";
			 }) //each
			  htmlStr+="</table>";			  
			 $("#area").html(htmlStr);				
		 });//area	

// 	우리가 원래 했던 방법
// 	  $.post("zipAction.amy",
// 		{"dong":$("#dong").val()},
// 		function(data){
// 			var res = JSON.parse(data);
// 			var htmlStr="";
// 			var htmlStr="<table>";
			
// 			$.each(res.zarr,function(key,val){
// 			  var bunji = val.bunji==null?"":val.bunji; //undefined 나온 경우를 위해
// 			  var gugun = val.gugun==null?"":val.gugun;
			  
// 			  htmlStr+="<tr>";
// 			  htmlStr+="<td>"+val.zipcode+"</td>";
// 			  htmlStr+="<td>"+val.sido+"</td>";
// 			  htmlStr+="<td>"+gugun+"</td>";
// 			  htmlStr+="<td>"+val.dong+"</td>";
// 			  htmlStr+="<td>"+bunji+"</td>";
// 			  htmlStr+="</tr>";
// 			 }) //each
// 			  htmlStr+="</table>";			  
// 			 $("#area").html(htmlStr);				
// 			}//functiondata
// 		  );//post
		  
			  $("#area").on("click","tr",function(){
					var address = $("td:eq(1)",this).text()+" "+
								  $("td:eq(2)",this).text()+" "+
							      $("td:eq(3)",this).text()+" "+
								  $("td:eq(4)",this).text();
					$(opener.document).find("#zipcode").val($("td:eq(0)",this).text());
					$(opener.document).find("#addr").val(address);
					self.close();
				})//send  
			})
})	
</script>
</head>
<body>

<table>
<tr>
<td>동 이름 입력 : <input type="text" name="dong" id="dong">
<input type="button" name="zipcodre" value="검색" id="send"> 
</td>
</tr>
</table>
<div id="area"></div>
</body>
</html>