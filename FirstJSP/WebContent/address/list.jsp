<%@page import="com.address.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- cdm방식 -->

<% //이름 누르고 검색
 request.setCharacterEncoding("utf-8");
String word="";
String field="";
if(request.getParameter("word")!=null){ //검색값을 눌렀을 때만 불러오고, 아닐 때는 공백 
	field=request.getParameter("field");
	word=request.getParameter("word");
}

AddressDAO dao = AddressDAO.getInstance();
ArrayList<Address> arr = dao.addrList(field, word);
int count = dao.getCount(field,word);
%>
<script>
// 공백으로 검색 시
function searchCheck(){
	if($("#word").val()==""){
		alert("검색어를 입력하세요");
		$("#word").focus();
		return false;
		}
	$("#searchFrm").submit();
	}
function delFunc(no){
	if(confirm("정말 삭제할까요?")){
		location.href="deletePro.jsp?num="+no;
	}
}

</script>

<style>
div.divCss{
text-align:right;
background-color:gray;
padding-right:20px;

}
a:hover{text-decoration:none;}
a:link{text-decoration:none;}
a:visited{text-decoration:none;}
</style>
</head>
<body>
<div class ="divCss"> <!-- div:문단태그 -->
주소록 갯수 : <%=count%> <br>
<a href ="insert.jsp">추가하기</a>
<a href ="list.jsp">전체보기</a>
</div>
 <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">번호</th>
            <th scope="col">이름</th>
            <th scope="col">전화번호</th>
            <th scope="col">주소</th>
             <th scope="col">삭제</th>
          </tr>
        </thead>
   

<tbody>

<% // tf,td,th는 html언어니까 <%로 묶어주면 안된다!
 for(int i=0; i<arr.size(); i++){
	 //arrayList : length가 아닌 size 
	 %>	 
	 
	<tr>
	<td><%=arr.get(i).getNum() %></td>
	<!-- ?가 매개변수 역할,, -->
	<td><a href="detail.jsp?num=<%=arr.get(i).getNum() %>"><%=arr.get(i).getName() %></a></td>
	<td><%=arr.get(i).getTel() %></td>
	<td><%=arr.get(i).getAddr() %></td>
	<td onclick="delFunc(<%=arr.get(i).getNum() %>)">삭제</td>
	<!-- 삭제 누르면 삭제 되기 (매개변수 有) -->
	</tr>
<%	 
 }
%>	
</tbody>
<tfoot>
<tr>
<td></td>
</table>
<form action="list.jsp" name="searchFrm" id="searchFrm">
<select name=field>

<option value="name">이름</option>
<option value="tel">전화번호</option>
</select>
<input type="text" name="word" id="word">
<input type="button" class="btn btn-primary" value="검색" onclick="searchCheck()">
</form>
</body>
</html>