<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function back(){
		location.href="/";
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form role="form" action="/user/modify" method="post">
		<p>
			<label for="userId">닉네임</label>
			<input type="text" id="userId" name="userId" value="${name }" Readonly>
		</p>
		<p>
			<label for="userPass">패스워드</label>
			<input type="text" id="userPass" name="userPass">
		</p>
		<p>
			<button type="submit">회원정보 수정</button>
		</p>
		<p>
			<button type="button" onclick="back()">처음으로</button>
		</p>
	</form>
</body>
</html>