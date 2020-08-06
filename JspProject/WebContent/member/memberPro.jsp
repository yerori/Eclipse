<%@page import="com.member.MemberDAOImpl"%>
<%@page import="com.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.member.MemberVO"%>
<%request.setCharacterEncoding("utf-8"); %>
    

    
<jsp:useBean id="member" class="com.member.MemberVO"/> <!-- getter,setter한 페이지  -->
<jsp:setProperty property="*" name="member"/>

<%
MemberDAOImpl dao = MemberDAOImpl.getInstance();
String uid=request.getParameter("uid");
member.setUserid(uid);
dao.memberInsert(member);
response.sendRedirect("loginForm.jsp"); //회원가입 후 -> 로그인폼 보이게,,
%>