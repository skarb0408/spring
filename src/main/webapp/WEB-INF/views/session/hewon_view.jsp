<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>������</h1>
	<hr>
	<ul>
		<li>���̵� = ${hewon.id }</li>
		<li>��й�ȣ = ${hewon.password }</li>
		<li>�̸� = ${hewon.name }</li>
		<li>�̸��� = ${hewon.email }</li>
		<li>���� = ${hewon.gender }</li>
	</ul>
	
	<%--ȸ������ ���������� �̵� >> ���̵� ����(�ĺ���) --%>
	<%-- <a href="hewon_update?id=${hewon.id }">ȸ������ ����</a>--%>
	
	<%-- ���̵� ���޹޾� ȸ�������� �˻��� �ʿ䰡 �����Ƿ� ���� ���ص��� --%>
	<a href="hewon_update">ȸ������ ����</a>
</body>
</html>