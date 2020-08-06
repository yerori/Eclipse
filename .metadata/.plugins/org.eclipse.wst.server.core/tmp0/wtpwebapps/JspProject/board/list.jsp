
<%@page import="com.board.BoardVO"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src = "https://code.jquery.com/jquery-3.5.1.min.js"></script>

</head>

<%
request.setCharacterEncoding("utf-8");
String pageNum=request.getParameter("pageNum");
if(pageNum==null){
	pageNum="1";
}
int currentPage = Integer.parseInt(pageNum);
int pageSize=5;
int startRow=(currentPage-1)*pageSize+1;
int endRow=currentPage*pageSize;


//검색하기 위한 script
BoardDAO dao = BoardDAO.getInstance();

String field = "",word="";
ArrayList<BoardVO> arr=null;
int count =0;
if(request.getParameter("word")!=null&&!request.getParameter("word").equals("")){
	field=request.getParameter("field");
	word=request.getParameter("word");
	arr = dao.boardList(field,word,startRow,endRow);
	count = dao.boardCount(field,word);
}else{
	arr = dao.boardList(startRow,endRow);
	count = dao.boardCount();
}
String userid = (String)session.getAttribute("userid");

%>

<body>
<br>

<!-- div: 블럭,, span: 단순히 영역 -->

<div align="right" style="margin-right:20px">
	전체 게시글 수 :<span id="cntSpan"><%=count %></span> <br>
<%
	if(userid!=null){
%>
	<a href="userid"></a>님 반갑습니다. 
	<a href="../member/logout.jsp">  로그아웃     </a> <br>
	<a href="writeForm.jsp">글쓰기</a>
<% 
}	
%>
</div>
<br>


<table class="table table-striped">
<thead class="thead-dark">
<tr>
	<th scope="col">번호</th>
	<th scope="col">제목</th>
	<th scope="col">작성자</th>
	<th scope="col">작성일</th>
	<th scope="col">조회수</th>
	<th scope="col">IP주소</th>
</tr>

</thead>

<tbody>
	<%
	for(BoardVO vo : arr){
		
	%>		
	<tr>
	<td><%=vo.getNum() %></td> <!-- 밑의 jsp? 물음표 의미 : 기본값 갖고 가겠다~ -->
	<td><a href="boardView.jsp?num=<%=vo.getNum() %>"><%=vo.getSubject() %></a></td>
	<td><%=vo.getWriter() %></td> 
	<td><%=vo.getReg_date() %></td> 
	<td><%=vo.getReadcount() %></td>
	<td><%=vo.getIp() %></td>	
	</tr>
<% 
	} 
%>

	</tbody>
</table>

<br>
<form action="list.jsp" name="search" method="get">
	<table>
		<tr>
		<td align=center>
		<select name="field" size=1>
		<option value="subject">제목
		<option value="writer">작성자		
		</select>
	<input type="text" size=30 name="word">
	<input type="submit" value="찾기">
	</td>
	</tr>

	</table>
</form>



<div align="center">
<%
	
	if(count>0){
		int pageCount = count/pageSize+(count%pageSize==0?0:1);
		int pageBlock=3;
		int startPage = (int)((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		if(endPage>pageCount){
			endPage = pageCount; 
		}
	
	//이전
	if(startPage>pageBlock){
%>
		<a href="list.jsp?pageNum=<%=startPage-pageBlock %>&field=<%=field%>&word=<%=word %>" >[이전]</a>
<% 	
	}
		
	
	//for
	for(int i=startPage; i<=endPage;i++){
%>
		<a href="list.jsp?pageNum=<%=i%>&field=<%=field%>&word=<%=word %>"><%=i%></a>
<% 
	}
	
	//다음
	if(endPage<pageCount){
%>	
		<a href="list.jsp?pageNum=<%=startPage+pageBlock %>&field=<%=field%>&word=<%=word %>">[다음]</a>
<%	
	}
}
%>


</div>
</body>
</html>