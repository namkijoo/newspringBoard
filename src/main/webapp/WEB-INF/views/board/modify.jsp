<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>replyModify Page</title>
</head>
<body>
	<form method="post" action="/reply/modify">
		<p>
			<label>댓글 작성자</label><input type="text" name="writer" readonly value="${reply.writer}">
		</p>
		<p>
			<textarea rows="5" cols="50" name="content" ></textarea>
		</p>
		<p>
			<input type="hidden" name="bno" value="${reply.bno}">
			<input type="hidden" name="rno" value="${reply.rno}">
			<button type="submit">댓글수정</button>
		</p>
	</form>
</body>
</html>