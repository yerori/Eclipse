<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <script src="/project/js/member.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Home Page</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
    	<!-- choose when test까지 한 묶음으로 붙어다니고,, empty sessionScope 세션이 비어있다면,,  -->
    <c:choose>
     <c:when test="${empty sessionScope.userid }"> 
      <li class="nav-item">
        <a class="nav-link" href="/project/member/login.me">로그인</a> 
      </li>
       <li class="nav-item">
        <a class="nav-link" href="/project/member/insert.me">회원가입</a>
      </li>
     </c:when>
     
     <c:otherwise>
      <li class="nav-item">
        <a class="nav-link" href="/project/member/logout.me">로그아웃</a> 
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/project/member/view.me">정보변경</a> 
      </li>
          <li class="nav-item">
        <a class="nav-link" href="/project/member/delete.me">회원탈퇴</a> 
      </li>
     </c:otherwise>
    </c:choose>
      
      <li class="nav-item">
        <a class="nav-link" href="/project/board/board.me">게시판</a>
      </li>    
    </ul>
    <c:if test="${not empty sessionScope.userid }">
     <span class="navbar-text">
     ♥ ${sessionScope.userid}님 반갑습니다. ♥</span>
     </c:if>
  </div>  
</nav>
