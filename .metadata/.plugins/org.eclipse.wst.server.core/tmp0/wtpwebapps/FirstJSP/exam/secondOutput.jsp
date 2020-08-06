<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%

//프로그램 다중선택
String[] prog = request.getParameterValues("prog");
String str="";
if(prog!=null){
	for(int i=0;i<prog.length;i++){
		str+=prog[i]+" ";
	}
}

//여행지 다중선택
String[] area = request.getParameterValues("area");
String jou="";
if(area!=null){
	for(int i=0;i<area.length;i++){
		jou+=area[i]+" ";
	}
}
%>

<body>
성명 : <%=request.getParameter("name") %><br>
성별 : <%=request.getParameter("gender") %><br>
생년월일 : <%=request.getParameter("birth") %>
<%=request.getParameter("year")%> -
<%=request.getParameter("month")%> -
<%=request.getParameter("day") %><br>
주소 : <%=request.getParameter("addr") %><br>
전화번호 : <%=request.getParameter("tel1")%> -
<%=request.getParameter("tel2")%> -
<%=request.getParameter("tel3")%><br>

프로그램 : <%=str %><br>
여행지 : <%=jou %><br>
미래의 꿈 : <%=request.getParameter("memo") %>
</body>
</html>