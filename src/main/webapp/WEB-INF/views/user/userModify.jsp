<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function back(){
		location.href="/";
	}
	
	function pwcheck(pw){
		var regexPw=/^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{8,20}$/;
		if(!regexPw.test(pw)){
			pwCheckF.innerHTML = "유효성 체크 범위 벗어남"; 
			$('#pwCheckF').css("color","red")
			$('#sub').attr("disabled","disabled");
			}
		
		else{
			pwCheckF.innerHTML = "유효성 체크 문제 없음";
			$('#pwCheckF').css("color","blue")
			$('#sub').removeAttr("disabled");

		}
	}
	
	function change(){
		
		if(userPass.value=="${password}")
		 	alert("기존 비밀번호와 같아요")
			$('#sub').attr("type","button");
	
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
			<input type="text" id="userPass" name="userPass" oninput="pwcheck(userPass.value)">
			<span id="pwCheckF"></span>
			<span>기존 패스워드 = "${password}"</span>
		</p>
		<p>
			<button type="submit" id="sub" class="sub" onclick="change()">회원정보 수정</button>
		</p>
		<p>
			<button type="button" onclick="back()">처음으로</button>
		</p>
	</form>
</body>
</html>