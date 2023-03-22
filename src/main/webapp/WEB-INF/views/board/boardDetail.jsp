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
	var replyCount="${replyCount}"
	function deleteBtn(){
		if(replyCount!=0){
			alert("댓글이 있는 게시물은 삭제할 수 없습니다.");
			document.getElementById("delete").type="button";
		}	
		else{
			if(confirm("정말 삭제하시겠습니까?")==true){
				document.getElementById("delete").type="submit";	
			}
			else
				document.getElementById("delete").type="button";
				true;
			
		}
	}
	
	function editBtn(){
		location.href='/boardUpdate/?bo_no=${data.bo_no}';
	}
	

	function editReply(bno,rno){
		location.href="/reply/modify/?bno="+bno+"&rno="+rno;
	}
	
	function deleteReply(bno,rno){
		location.href="/reply/delete/?bno="+bno+"&rno="+rno;
	}
	
	  
</script>
</head>
<body>
	<a href="/listPage?num=1"><h2>Detail Page</h2></a>
	<hr>
	<table border=1>
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
		<tr>
			<td>댓글수</td>
			<td>${replyCount}</td>
		</tr>
		<c:if test="${data.file_name ne null}">
			<tr>
				<td bgcolor="orange">첨부파일</td>
				<td align="left"><a href="http://localhost:8081/fileDownload.do?file_name=${data.file_name}">${data.file_name}</a></td>
			</tr>
			</c:if>
	</table>
	<br>
	내용
	<div>
	<textarea readonly rows="5" cols="70">${data.content}</textarea>
	</div>
	<c:if test="${data.name==name||role=='admin'}">
		<form method="post" action="/boardDelete">
			<button type="submit" id="delete" onclick="deleteBtn()" >게시물삭제</button>
			<input name="bo_no" value="${data.bo_no}" style="display:none"/>	
		</form>
		
		<form method="get" action="/boardUpdate">
			<button type="submit" id="edit" >게시물수정</button>
			<input name="bo_no" value="${data.bo_no}" style="display:none"/>	
		</form>

	</c:if>
	
	<br>
	<br>
	<hr>
	
	
	<c:forEach items="${reply}" var="rpl">
	<li>
	    <div>
	        <p>작성자 : ${rpl.writer} / <fmt:formatDate value="${rpl.regDate}" pattern="yyyy-MM-dd"/></p>
	        <p>내용 : ${rpl.content }</p>
	        <p>
	        	<c:if test="${name==rpl.writer||role=='admin'}">
	        		<button type="button" id="rplyEditBtn" onclick="editReply('${rpl.bno}','${rpl.rno}')" >수정</button>
	        		<button type="button"  onclick="deleteReply('${rpl.bno}','${rpl.rno}')" >삭제</button>
	        	</c:if>
	        </p>
	    </div>
	</li>    
	</c:forEach>
	<div>
		<form method="post" action="/reply/write">
			<p>
				<label>댓글 작성자</label> <br> 
				<input type="text" name="writer" value="${name}" Readonly>
			</p>
			<p>
				<span>댓글내용</span><br>
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