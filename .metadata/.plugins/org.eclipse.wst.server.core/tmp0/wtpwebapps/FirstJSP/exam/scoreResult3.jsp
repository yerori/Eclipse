<%@page import="com.exam.ScoreBean3"%>
<%@page import="com.exam.ScoreBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
// 3번째 : 생성자를 이용 ,, setter와 생성자는 똑같다!!!! 
request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
int kor=Integer.parseInt(request.getParameter("kor"));
int eng=Integer.parseInt(request.getParameter("eng"));
int math=Integer.parseInt(request.getParameter("math"));
//int total=kor+eng+math;

ScoreBean3 sb = new ScoreBean3(name,kor,eng,math); // <- 이케 괄호 안,,, 생성자 이용

%>
</head>


<body>
<!--  scoreResult3.jsp-->
이름 :<%=sb.getName() %><br>
국어 :<%=sb.getKor() %><br>
영어 :<%=sb.getEng() %><br>
수학 :<%=sb.getMath() %><br>
총점 :<%=sb.getTotal() %><br> <!-- total,avg,grade는 setter안해두돼용  -->
평균 :<%=sb.getAvg() %><br>
학점 :<%=sb.getGrade() %>
	
</body>
</html>