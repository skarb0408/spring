<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>상세정보</h1>
	<hr>
	<ul>
		<li>아이디 = ${hewon.id }</li>
		<li>비밀번호 = ${hewon.password }</li>
		<li>이름 = ${hewon.name }</li>
		<li>이메일 = ${hewon.email }</li>
		<li>성별 = ${hewon.gender }</li>
	</ul>
	
	<%--회원정보 변경페이지 이동 >> 아이디값 전달(식별자) --%>
	<%-- <a href="hewon_update?id=${hewon.id }">회원정보 변경</a>--%>
	
	<%-- 아이디를 전달받아 회원정보를 검색할 필요가 없으므로 전달 안해도됨 --%>
	<a href="hewon_update">회원정보 변경</a>
</body>
</html>