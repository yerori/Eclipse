<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
request.setCharacterEncoding("utf-8"); 
%>
<jsp:useBean id="student" class="com.exam.StudentBean"/> 
<jsp:setProperty property="*" name="student"/> <!-- setproperty: 입력 -->
<!-- StudentBean st = new StudentBean(); 와 같다,, 즉, StudentBean 객체를 만듦의 jsp방식 -->
<!-- jsp액션태그라고 함,, class에는 파일 위치를 적어놓음  -->
<%
String[] h = student.getHobby();
String strHobby = "";
for(int i=0; i<h.length;i++){
	strHobby+=h[i]+" ";
}

%>
</head>
<body>
이름 :<jsp:getProperty property="name" name="student"/> <!-- getProperty : 출력 -->
<hr>
이름 : <%=student.getName() %><br>
학번 : <%=student.getStudentNum() %><br>
성별 : <%=student.getGender() %><br>
전공 : <%=student.getMajor() %><br>
취미 : <%=strHobby %>
</body>
</html>