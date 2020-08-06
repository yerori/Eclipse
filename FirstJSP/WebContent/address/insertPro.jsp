<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- body없어도된다, 화면에 나타내야할 화면이 없기 때문에,, 단지 DB연동이 목적 -->

<%
 request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="ad" class="com.address.Address"/>
<jsp:setProperty property="*" name="ad"/>

<% //db에 넣긩

 AddressDAO dao = AddressDAO.getInstance();
 dao.addrInsert(ad);
 response.sendRedirect("list.jsp");
 // insert.jsp 켜서 입력 -> 바로 list.jsp의 table이 보이게끔 
%>


