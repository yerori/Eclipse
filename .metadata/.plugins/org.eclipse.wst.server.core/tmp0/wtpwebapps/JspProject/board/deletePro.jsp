<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>

<% 
BoardDAO dao = BoardDAO.getInstance();
int num=Integer.parseInt(request.getParameter("num"));
int flag=dao.boardDelete(num);
response.sendRedirect("list.jsp");
%>


