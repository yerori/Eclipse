<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>


<div class="container">
<form action="insert.me" method="post" id="frm">

  <div class="row">
    <div class="col">
    <label for="userid">ID : </label>
    <!-- id꼭 적을것@!!! -->
    <input type="text" class="form-control" placeholder="Enter userid" id="userid" name="userid">
 	</div> 
 	<div class="col align-self-end">
  	<button type="button" id="id_checkBtn" class="btn btn-primary" name="id_checkBtn">중복확인</button>
  	</div>
  </div>
   <div class="form-group">
    <label for="name">NAME : </label>
    <input type="text" class="form-control" placeholder="Enter name" id="name" name="name">
  </div>

  <div class="form-group">
    <label for="pwd">Password : </label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pwd">
  </div>
    <div class="form-group">
    <label for="pwd_check">Password Confirm : </label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd_check" name="pwd_check">
  </div>
   <div class="form-group">
    <label for="email">Email : </label>
    <input type="email" class="form-control" placeholder="Enter email" id="email" name="email">
  </div>
    <div class="form-group">
    <label for="phone">Phone : </label>
    <input type="text" class="form-control" placeholder="Enter phone" id="phone" name="phone">
  </div>
 <div class="form-check-inline">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="admin" value="1">관리자
  </label>
</div>
<div class="form-check-inline">
  <label class="form-check-label">
    <input type="radio" class="form-check-input" name="admin" value="0" checked>일반회원
  </label>
</div>

<Br>
<Br>

  <button id="send" class="btn btn-primary">Submit</button>
  <Br>
</form>
  </div>

<%@ include file="../include/footer.jsp" %>

