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
	$("#send").click(function(){
	 if($("#dong").val()==""){
		alert("동이름을 입력하세요");
		return false;
		}

	 
	 //동이름 비어있지 않다면 ~ : json형태
	 $.post("zip.do",{"dong":$("#dong").val()}, //post방식
	 	function(data){ //콜백함수 - data(json형식인)값만들고옴 -> parsing
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
			 	 htmlStr+="</table>";			  
			  	$("#area").html(htmlStr);
		  }
	 	);

	  $("#area").on("click","tr",function(){
		var address=$("td:eq(1)", this).text()+" "+ //eq : 번째 ,, text: 문서에 있는 값을 불러옴
					$("td:eq(2)", this).text()+" "+								
					$("td:eq(3)", this).text()+" "+
					$("td:eq(4)", this).text();
		$(opener.document).find("#zipcode").val($("td:eq(0)", this).text()); 
		$(opener.document).find("#addr").val(address);
			self.close();	
  		});			
	})	
});



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