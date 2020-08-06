<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate(); //invalidate : 모든 세션 지움
// session.removeAttribute("userid");  :  유저아이디만 지우겠다!
response.sendRedirect("loginForm.jsp");

%>