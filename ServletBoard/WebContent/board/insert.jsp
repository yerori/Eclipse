<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<form method="post" action="insert">

<table style="margin:20px">
	<tr>
	<td align="center">글쓴이</td>						
	<td><input type="text" name="writer" id="writer" ></td>		
	</tr>
	
	<tr>
	<td align="center">제목</td>
	<td><input type="text" name="subject" id="subject"></td>
	</tr>
	
	<tr>
	<td align="center">내용</td>
	<td><textarea rows="5" cols="40" id="content" name="content"></textarea>
	</tr>
	
	<tr>
	<td colspan="2">
	<input type="submit" value="submit전송"></td>
	</tr>
</table>
</form>

</body>
</html>