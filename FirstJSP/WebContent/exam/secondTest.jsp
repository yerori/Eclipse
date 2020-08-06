<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
 width : 600px;
 height : 400px;

}
table,th, td{
	 border: 1px solid black;
}

.thColor{ 
	 background-color:pink;
}

ol.olType{
list-style-type: lower-latin;
}

</style>

<!--  <script>
function check(){
	alert("테스트");
}

</script>-->
</head>
<body>


<form action="secondOutput.jsp" method="get">
<table>

<tr>
<th>성명</th>
<td><input type="text" name="name"></td>
<th>성별</th>
<td><input type="radio" name=gender value="남자" checked>남자

<input type="radio" name=gender value="여자" >여자

</tr>

<tr>
<th>생년월일</th>
<td colspan=3>
<input type="text" name="year" size=15>년
<input type="text" name="month" size=5>월
<input type="text" name="day" size=5>일
<input type="radio" name=birth value="양력" >양력

<input type="radio" name=birth value="음력" >음력


</tr>

<!-- 3번째 -->
<tr>
<th>주소</th>
<td colspan="3">
<input type="text" name=addr  size=50></td>
</tr>

<!-- 4번째 -->
<tr>
<th>전화번호</th>
<td colspan="3">
<input type="text" name="tel1" size=10>-
<input type="text" name="tel2" size=10>-
<input type="text" name="tel3" size=10></td>
</tr>




<!-- 5번째 -->
<tr>
<th colspan="4" class="thColor">사용가능한 프로그램 선택하기</th>
</tr>


<!-- 6번째 체크박스-->
<tr>

<td colspan="4">

<ol class="olType">
	<li><input type="checkbox" name=prog value="한글">한글</li><br>
	<li><input type="checkbox" name=prog value="포토샵">포토샵</li><br>
	<li><input type="checkbox" name=prog value="매크로 미디어 디렉터">매크로 미디어 디렉터</li><br>
	<li><input type="checkbox" name=prog value="드림위버">드림위버</li><br>
	<li><input type="checkbox" name=prog value="3D MAX">3D MAX</li></td>

</ol>
</tr>



<tr>
<th colspan="4" class="thColor">가고싶은 여행지를 모두 선택하세요.</th>
</tr>

<tr>
<td colspan="4">
<select name="area" size = 3 multiple>
<option value="설악산" selected>설악산</option>
<option value="경포대">경포대</option>
<option value="토발">토발</option>
<option value="해운대">해운대</option>
</select>
</td>
</tr>


<tr>
<th colspan="4" class="thColor">미래의 꿈은 어떠한가요</th>
</tr>


<tr>
<td colspan="4" align="center">
<textarea cols=50 rows=5 name="memo"></textarea>
</tr>


<tr>
<td colspan="4" align="center">
<input type="submit" value="전송" >
<input type="reset" value="다시쓰기" >
</td>
</tr>

</table>
</form>
</body>
</html>