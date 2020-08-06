<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="board" class="com.board.BoardVO"/> <!-- usebean: 입력한 값만 받아올수있음  -->
<jsp:setProperty property="*" name="board"/>

<%
	BoardDAO dao = BoardDAO.getInstance();
	String ip=request.getRemoteAddr(); // getRemoteAddr : IP주소불러옴
	board.setIp(ip);
	dao.boardInsert(board);
	response.sendRedirect("list.jsp");
%>