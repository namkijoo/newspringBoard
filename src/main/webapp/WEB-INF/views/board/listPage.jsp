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

function search(){
	let searchType = document.getElementsByName("searchType")[0].value;
	let keyword =  document.getElementsByName("keyword")[0].value;
	location.href = "/listPage?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
}


</script>




</head>

<body>
	
	<table border=1>
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
	<br>
	<div>
		<select name="searchType">
			<option value="title" <c:if test="${searchType eq 'title'}">selected</c:if>>제목</option>
			<option value="content" <c:if test="${searchType eq 'content'}">selected</c:if>>내용</option>
			<option value="title_content" <c:if test="${searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
			<option value="writer" <c:if test="${searchType eq 'writer'}">selected</c:if>>작성자</option>
		</select>
			
		<input type="text" name="keyword" value="${keyword}"/>
			
		<button type="button" id="searchBtn" onclick="search()">검색</button>
	</div>
	<br>
	<div>
		<c:if test="${prev}">
			<span>[<a href="/listPage?num=${startPageNum-1}">이전</a>]</span>
		</c:if>
		
		<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
			<span>
				<c:if test="${select != num}">
			 	   <a href="/listPage?num=${num}">${num}</a>
				</c:if>    
  
				<c:if test="${select == num}">
				   <b>${num}</b>
				 </c:if>
			</span>
		</c:forEach>
		
		<c:if test="${next}">
			<span>[<a href="/listPage?num=${endPageNum+1}">다음</a>]</span>
		</c:if>
		
	</div>
	<br>
	<button type="button" onclick="goBoardWrite()">작성</button>
	<button type="button" onclick="logout()">logout</button>
	<button type="button" onclick="modify()">회원정보 수정</button>
	<button type="button" onclick="userdelete()">회원탈퇴</button>
</body>

</html>