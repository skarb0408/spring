<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력페이지</h1>
	<hr>
	<!-- web.xml에서 filter 선언한거 참조하기 -->
	<form action="param" method="post">
		 이름: <input type="text" name="name"> 
		<!--이름: <input type="text" name="userName">-->
		<button type="submit">전송</button>
	</form>
</body>
</html>