<%@page import="com.address.Address"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script> 
<%

int num=Integer.parseInt(request.getParameter("num"));
AddressDAO dao = AddressDAO.getInstance();
Address address = dao.addrDetail(num);

%>
<script>
function zipfinder(){
	window.open("zipCheck.jsp","","width=700 height=400");
}
//jquery 이용
$(document).ready(function(){
	$("#deleteBtn").click(function(){
		if(confirm("정말 삭제할까요?")){
			location.href="deletePro.jsp?num=<%=num%>";
		}
	})
});
	

//매개변수 없는 함수
function del(){
  if(confirm("정말 삭제할까요?")){
	location.href="deletePro.jsp?num=<%=num%>"; <%-- location 객체 이용해서 yes값 불러오기 --%>
  }		
}

// 위에 del, 아래 del 같음 근데 매개변수 이용하냐 안하냐,,

//매개변수 있는 함수 
function dels(no){
	if(confirm("정말 삭제할까요?")){
		location.href="deletePro.jsp?num="+no;
	}
}
</script>
</head>

<body>
<form action="updatePro.jsp" method="post" name="frm" >
<input type="hidden" name="num" value=<%=num %>> 
<!-- hidden:사용자에겐 안보여지지만, server에게넘어감  -->
<table>

<tr>
<td colspan="2">주소록 수정하기</td>

</tr>

<tr>
<td>이름</td>   
<td><input type="text" name="name" value=<%=address.getName() %>></td> 
<!-- 밖으로 나타내는값(value)이 address에서 선택된값이 보이게끔 -->

</tr>

<tr>
<td>우편번호  </td>
<td><input type="text"   value=<%=address.getZipcode() %>> 
<input type="button" value="검색" onclick="zipfinder()"></td>
</tr>

<tr>
	<td>주소</td> 
	<td><input type="text" name="addr" value=<%=address.getAddr() %>></td>
</tr>

<tr>
<td>전화번호</td>
<td> <input type="text" name="tel" value=<%=address.getTel() %>></td>
</tr>
 
<tr>
<td colspan="2"><input type="submit" value="수정">
<input type="button" value="삭제" onclick="del()">
<input type="button" value="매개변수 삭제" onclick="dels(<%=num%>)">
<input type="button" value="jQuery 삭제" id="deleteBtn">
<input type="reset" value="취소">
</td></tr>

</table>
</form>
</body>
</html>