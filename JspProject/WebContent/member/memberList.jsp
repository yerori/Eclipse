<%@page import="com.member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="member.js"></script>
</head>

<%
MemberDAOImpl dao = MemberDAOImpl.getInstance();
ArrayList<MemberVO> arr = dao.memberList(); //MemberVO형 값만 들어가는 배열 생성
String suserid = (String)session.getAttribute("userid");
int count = dao.memberCount();
%>

<body>
<br>

<!-- div: 블럭,, span: 단순히 영역 -->

<div align="right" style="margin-right:20px">
	전체 회원 수 :<span id="cntSpan"><%=count %></span>    <br>
	<a href="memberView.jsp"><%=suserid %></a> 관리자님 반갑습니다. 
	
	<a href="logout.jsp">  로그아웃     </a> <br>
	<a href="../board/list.jsp">게시판 글 보기</a>

</div>
<br>

<table class="table table-striped">
<thead class="thead-dark">
<tr>
	<th scope="col">이름</th>
	<th scope="col">아이디</th>
	<th scope="col">이메일</th>
	<th scope="col">전화번호</th>
	<th scope="col">등급</th>
	<th scope="col">삭제</th>
</tr>
</thead>

<tbody>
	<%
	for(MemberVO vo : arr){
		String mode = vo.getAdmin()==0?"일반회원":"관리자";
	%>		
	<tr>
	<td><%=vo.getName() %></td>
	<td><%=vo.getUserid() %></td>
	<td><%=vo.getEmail() %></td> <!-- for문 : arr.get(vo).getUse 웅앵  -->
	<td><%=vo.getPhone() %></td> <!-- foreach문 : vo.get웅앵 -->
	<td><%=mode %></td>	
	<td> <a href="javascript:del('<%=vo.getUserid()%>','<%=mode %>')">삭제</a></td>
	</tr>
<% 
	} 
%>

</tbody>
</table>
</body>
</html>