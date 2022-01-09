<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="hewon_view" method="post">
	<%--회원정보를 변경하기 위해 아이디를 요청 처리 메소드에 반드시 전달 --%>
	<%-- @SessionAttributes --%>
	<%-- <input type="hidden" name="id" value="${hewon.id }"> --%>
		<table>
			<tr>
				<td>아이디</td>
				<td>${hewon.id }</td> 
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${hewon.name }"></td> 	
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${hewon.email }"></td> 	
			</tr>
			<tr>
				<td>성별</td>
				<td>
					남자&nbsp;<input type="radio" name="gender" value="남자" checked="checked">&nbsp;&nbsp;&nbsp;
					여자&nbsp;<input type="radio" name="gender" value="여자">
				</td> 	
			</tr>
			<tr>
				<td colspan="2"><button type="submit">회원변경</button></td>
			</tr>
		</table>
	</form>
</body>
</html>