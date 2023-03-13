<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function editButton(){
		location.href="/reply/modify/?bno=${rpl.bno}&rno=${rpl.rno}"
	}
</script>
</head>
<body>
	<h2>Detail Page</h2>
	<hr>
	<table>
		<th>정보</th>
		<th>데이터</th>
		<tr>
			<td>작성일자</td>
			<td><fmt:formatDate value="${data.date}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${data.name}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${data.title}</td>
		</tr>
	</table>
	<br>
	내용
	<div>
	<textarea readonly rows="5" cols="70">${data.content}</textarea>
	</div>
	<button type="button" onclick="location.href='/boardUpdate/?bo_no=${data.bo_no}'">게시물수정</button>
	<button type="button" onclick="location.href='/boardDelete/?bo_no=${data.bo_no}'">게시물삭제</button>
	<br>
	<br>
	<hr>
	
	
	<c:forEach items="${reply}" var="rpl">
	<li>
	    <div>
	        <p>작성자 : ${rpl.writer} / <fmt:formatDate value="${rpl.regDate}" pattern="yyyy-MM-dd"/></p>
	        <p>내용 : ${rpl.content }</p>
	        <p>
	        	<button type="button" onclick="location.href='/reply/modify/?bno=${rpl.bno}&rno=${rpl.rno}'">수정</button>
	        	<button type="button" onclick="location.href='/reply/delete/?bno=${rpl.bno}&rno=${rpl.rno}'">삭제</button>
	        	
	        </p>
	    </div>
	</li>    
	</c:forEach>
<div>
	<form method="post" action="/reply/write">
		<p>
			<label>댓글 작성자</label> <input type="text" name="writer">
		</p>
		<p>
			<textarea rows="5" cols="50" name="content"></textarea>
		</p>
		<p>
		<input type="hidden" name="bno" value="${data.bo_no}">
			<button type="submit">댓글 작성</button>
		</p>
	</form>
</div>
</body>
</html>