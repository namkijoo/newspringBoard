<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Write Page</title>
<script type="text/javascript">
	function goBoardList(){
		location.href="/boardList"
	}
	
	function addWrite(){
		var form = document.getElementById("insert_data");
		var value = document.getElementById("name").value;
		if(value==""){
			alert("이름을 입력하세요");
		}
		else{
			form.action="<c:url value='/boardWriteDo'/>";
			form.submit();
		}
	}
	
	
	
</script>
</head>
<body>
<form method="post" id="insert_data" name="form">
	제목: &nbsp;&nbsp;&nbsp;&nbsp; <input name="title" type="text" id="title"><br>
	작성자 : &nbsp; <input name="name" type="text" id="name"><br>
	내용 : &nbsp;&nbsp;&nbsp;&nbsp; <textarea rows="5" cols="50" name="content" id="content"></textarea> 
	
</form>
 <button type="button" onclick="javascript:goBoardList()">목록으로 돌아가기</button>
  <button type="button" onclick="javascript:addWrite()">저장</button>
</body>
</html>
