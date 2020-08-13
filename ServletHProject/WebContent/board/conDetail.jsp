<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>


function delFunc(cnum){
	if(confirm("정말 삭제할까요?")){
		location.href="delete?cnum="+cnum;
		alert("삭제되었습니다.");
	}
}


</script>
<style>
.btn btn1 d-none d-lg-block{
	width:100px;
}
#btn, #delBtn{
	padding:30px;
	margin: 20px;
	width:100px;
	
}
#container{
	padding:100px;
	margin:100px;
	text-align:center;
	
}

#a{
margin:0 auto;
	text-align:center;
	
}

#box{
	margin:0 auto;
}

#p{
	font-weight: bold;
}
</style>
<body>


<form action="update" method="post" >
<input type="hidden" id="cnum" name="cnum" value="${con.cnum}">
<div id="container" align=center>
<h3 id="p">${con.id }님이 작성한 코멘트</h3><br>
<table id="a" border="1">
<tbody>
 <tr>
 <th>작성자</th>
 <td><input type="text" id="box" name="id" readonly="readonly" size="50" value="${con.id }"></td>
 </tr>
 <tr>
 <th>이메일</th>
 <td><input type="email" id="box" name="email" size="50"  value="${con.email }"></td>
 </tr>
 
 <tr>
  <th>제목</th>
 <td><input type="text" id="box" name="subject" size="50"  value="${con.subject }"></td>
 </tr>
 
 <tr>
  <th>내용</th>
 <td><input type="text" id="box" name="content" size="50"  value="${con.content }"></td>
 </tr>

<tr>

<td colspan="2" align="center">
  	
   <input type="submit" class="btn btn1 d-none d-lg-block " id="btn" value="수정"> 
   <input type="button"  class="btn btn1 d-none d-lg-block " id="delBtn" value="삭제" onclick="delFunc('${con.cnum }')">
   <input type="reset" class="btn btn1 d-none d-lg-block " id="btn" value="취소"></td>
</tbody>
</table>
</div>
</form>
</body>
</html>
<%@ include file="../include/footer.jsp" %>