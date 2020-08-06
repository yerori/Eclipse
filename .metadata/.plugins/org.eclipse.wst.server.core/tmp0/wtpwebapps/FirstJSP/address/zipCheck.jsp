<%@page import="com.address.ZipcodeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a:hover{
 text-decoration:none; color:#000
 
}
a:link{
 text-decoration:none; color:#000
 
}
a:visited{
 text-decoration:none; color:#000
 
}
</style>
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- cdm방식 -->
<%

String dong=request.getParameter("dong");

AddressDAO dao = AddressDAO.getInstance();
ArrayList<ZipcodeBean> zarr = dao.zipcodeRead(dong);
%>
<script>
// jquery이용
function dongCheck(){
	if($("#dong").val()==""){
		alert("동이름을 입력하세요");
		$("#dong").focus(); // text type에 커서 움직
		return false;
	}
	$("#frm").submit();
}

function send(code,sido,gugun,dong,bunji){
	var address =sido+" "+gugun+" "+dong+" "+bunji;
	opener.document.frm.zipcode.value=code; //호출해주는 것 : opener
	opener.document.frm.addr.value=address;
	
	self.close();
}

</script>
</head>
<body>
<form action="zipCheck.jsp" id="frm"> <!-- 안적어 주면 자기 자신,, -->
<table>
<tr>

<td>동 이름 입력 : <input type="text" name="dong" id="dong">
<input type="button" name="zipcodre" value="검색" onclick="dongCheck()"> 
</td>
</tr>
<% // <% : java를 쓰겠당,,
 if(zarr.isEmpty()){
%>	 
	 <tr>
	 <td>검색된 결과가 없습니다.</td>	 
	 </tr>
<%	 
 }else{
%>	 
	 <tr>
	 <td>*검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>	 
	 </tr>
<%	
	for(ZipcodeBean z : zarr){
		String zip = z.getZipcode();
		String sido = z.getSido();
		String bunji = z.getBunji();
		String gugun = z.getGugun();
		String d = z.getDong();
		%>
		<tr>
		<!-- ★ JAVASCRIPT에서는 문자열일때 ''  -->
		 <td><a href="javascript:send('<%=zip%>','<%=sido%>','<%=gugun%>','<%=d%>','<%=bunji%>')"> 
		 <!-- javascript코드로,, send 함수를 부름 -->
		 <%=zip%><%=sido%><%=bunji%><%=gugun%><%=d%></a></td>
		 <!-- bunji에 null값 뜸 -> zipcodebean에 감 -->
		</tr>
		<%
	}//for
 }//else
%>

</table>
</form>
</body>
</html>