<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% // 여러개 입력되니까 string [] 으로,, 
request.setCharacterEncoding("utf-8"); // 한글안깨지게 인코딩 ,,
String[] hobby = request.getParameterValues("hobby"); // getParameterValues : 여러개의 값을 받아오는 함수,, 
%>

<body>
이름 : <%=request.getParameter("name") %><br>
학번 : <%=request.getParameter("num") %><br>
성별 : <%=request.getParameter("sex") %><br>
전공 : <%=request.getParameter("major") %><br>
<% 
String str="";
if(hobby!=null){ //체크박스만 배열 -> 값이 여러개 체크O
for(int i=0;i<hobby.length;i++){
	str+=hobby[i]+ " ";
}
}
%>
취미 :<%=str %>
</body>
</html>