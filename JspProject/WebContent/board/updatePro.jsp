<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="board" class="com.board.BoardVO"/>
<jsp:setProperty property="*" name="board"/>

<%
	BoardDAO dao = BoardDAO.getInstance();
	String ip=request.getRemoteAddr(); // getRemoteAddr : IP주소불러옴
	board.setIp(ip);
	int flag=dao.boardUpdate(board);
	if(flag==1){ //정상업뎃
		response.sendRedirect("list.jsp");
	}else{

%>	
	<script>
		alert("비밀번호가 일치하지 않습니다.");
		history.back(); //history.go(-1) : 이전페이지로 넘어감
	</script>
<%
	}	
%>