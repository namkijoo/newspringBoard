<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시판</title>
<script type="text/javascript">
function goBoardWrite(){
	location.href="boardWrite";
}

function logout(){
	 location.href = "logout"; 
}

function modify(){
	location.href="user/modify";
}

function userdelete(){
	location.href="user/delete";
}
</script>




</head>

<body>
	<table>
		<tr>
			<td>제목</td>
			<td>작성자</td>
			<td>작성시간</td>
			<td>작성날짜</td>
			<td>번호</td>
		</tr>
		<c:forEach items="${list}" var="test">
		<tr>
			<td>${test.title}</td>
			<td><a href="/boardDetail/?bo_no=${test.bo_no}">${test.name}</a></td>
			<td>${test.time}</td>
			<td>${test.date}</td>
			<td>${test.bo_no}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<c:forEach begin="1" end="${pageNum}" var="num">
			<span>
				<a href="/listPage?num=${num}">${num}</a>
			</span>
		</c:forEach>
	</div>
	<br>
	<button type="button" onclick="goBoardWrite()">작성</button>
	<button type="button" onclick="logout()">logout</button>
	<button type="button" onclick="modify()">회원정보 수정</button>
	<button type="button" onclick="userdelete()">회원탈퇴</button>
</body>

</html>