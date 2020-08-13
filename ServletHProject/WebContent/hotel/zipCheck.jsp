<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<style>
table{
	padding:20px;
	margin:20px;
}

</style>

<script>
$(document).ready(function(){
	$("#searchBtn").click(function(){
		if($("#dong").val()==""){
			alert("동이름을 입력하세요");
			return false;
		}
		
		$.post("zipcode",{"dong":$("#dong").val()},
		   function(data){
			data=JSON.parse(data);
			var htmlStr="";
			var htmlStr="<table>";
			for(var i=0; i<data.jarr.length;i++){
				htmlStr+="<tr>";
				htmlStr+="<td>"+data.jarr[i].zipcode+"</td>";
				htmlStr+="<td>"+data.jarr[i].sido+"</td>";
				htmlStr+="<td>"+data.jarr[i].gugun+"</td>";
				htmlStr+="<td>"+data.jarr[i].dong+"</td>";
				htmlStr+="<td>"+data.jarr[i].bunji+"</td>";
				htmlStr+="</tr>";
			}
			htmlStr+="<table>";
			$("#area").html(htmlStr);
		  }
		);
		$("#area").on("click","tr",function(){
			var address=$("td:eq(1)",this).text()+" "+
						$("td:eq(2)",this).text()+" "+
						$("td:eq(3)",this).text()+" "+
						$("td:eq(4)",this).text();
			$(opener.document).find("#zipcode").val($("td:eq(0)",this).text());
 			$(opener.document).find("#address").val(address);
 			self.close();
		});
		
	})
});



</script>
<body>
<table>
<tr>
<td>동 이름 입력 : <input type="text" id="dong" name="dong"> 
 
  <button id="searchBtn" class="btn btn-primary" name="searchBtn">주소 검색</button></td>
 
</tr>

</table>

 <div id="area">
 </div> 
</body>
</html>