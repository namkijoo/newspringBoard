<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form role="form" action="/user/delete" method="post">
	<p>
		<label for="userId">아이디</label>
		<input id="userId" type="text" name="userId" value=${name} Readonly>
	</p>
	<p>
		<label for="userPass">패스워드</label>
		<input id="userPass" type="text" name="userPass">
	</p>
	<p>
		<button type="submit">회원탈퇴</button>
	</p>
		
	</form>
</body>
</html>