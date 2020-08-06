<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- 이 jsp 파일은 Pro역할     -->

<%
String userid=(String)session.getAttribute("userid");
// session : HashMap에 넣는 것처럼,, 
MemberDAOImpl dao = MemberDAOImpl.getInstance();
dao.memberDel(userid); //SQL문 -> DB내 데이터 삭제
session.invalidate(); //session -> jsp내 데이터 삭제
response.sendRedirect("loginForm.jsp");
%>