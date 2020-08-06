<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("utf-8");
  
    %>
    <jsp:useBean id="ad" class="com.address.Address"/>
    <jsp:setProperty property="*" name="ad"/>
    
    
    <% 
    AddressDAO dao = AddressDAO.getInstance();
    dao.addrUpdate(ad);
    response.sendRedirect("list.jsp");  // update 후 다시 list화면 보여주기
     %>