<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<script>

</script>
<body>
	<h2>Update page</h2>
	<form method="post" id="update_data">
		<div>글 번호 : ${data.bo_no}</div>
		<div>이름 :</div>
		<div><input name="name" value="${data.name}" type="text" readonly></div>
		<div>제목 :</div>
		<div><input name="title" value="${data.title}" type="text"></div>
		<div>내용 :</div>
		<div><input name="content" value="${data.content}" type="text"></div>
		<div>작성일자 </div>
		<div><fmt:formatDate value="${data.date}" pattern="yyyy/MM/dd"/></div>
		<div>작성시간 </div>
		<div><fmt:formatDate value="${data.time}" pattern="HH:mm:ss"/></div>
		
		<div>
			
			<input type="submit" value="완료"/>
			<input type="reset" value="리셋"/>
		</div>
			
		
	</form>
</body>
</html>