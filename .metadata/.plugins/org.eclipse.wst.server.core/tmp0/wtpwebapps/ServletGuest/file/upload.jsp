<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="upload.do" enctype="multipart/form-data"> <!-- get 안됨 -->
글쓴이 : <input type="text" name="name"><br>
제목 : <input type="text" name="title"><br>
파일 지정하기 : <input type="file" name="uploadFile"><br> <!-- 파일 로드 할 수 있게끔,, -->
<input type="submit" value="전송">
</form>
</body>
</html>