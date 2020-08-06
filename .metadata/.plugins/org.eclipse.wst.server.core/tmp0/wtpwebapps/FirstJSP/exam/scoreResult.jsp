<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<!--  jsp로만 이용  -->

<%
String name = request.getParameter("name");
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int math = Integer.parseInt(request.getParameter("math"));
int total = kor+eng+math; // total 구하기위해 kor를 int처리
int avg = (kor+eng+math)/3;
String grade =""; // 공백인 변수를 먼저 지정,, 

/*if(avg>=90){
	grade="A학점";
}else if(avg>=80){
	grade="B학점";
}else if(avg>=70){
	grade="C학점";
}else {
	grade="F학점";
}*/

switch(avg/10){
case 10:
case 9: grade="A학점";break;
case 8:grade="B학점";break;
case 7:grade="C학점";break;
default :grade="F학점";
}

%>

<body>

결과<br>
<hr>
이름 : <%=name %><br>
국어 : <%=kor %><br>
영어 : <%=eng %><br>
수학 : <%=math %><br>
총점 : <%=total %><br>
평균 : <%=avg %><br>
학점 : <%=grade %>
</body>
</html>