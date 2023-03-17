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
			check=false;
			}
		
		else{
			pwCheckF.innerHTML = "유효성 체크 문제 없음";
			$('#pwCheckF').css("color","blue")
			check=true;
		}
	}
	
	var pass = "";
	var check=false
	function pwCheck(){
		var userId = $('#userId').val();
		var userPass = $('#userPass').val();
		$.ajax({
			type:"POST",
			url: "/pwCheck",
			data : { 
				userId:userId,
				},
			success:function(result){	
				pass=result;
			},
	    	error:function(request,status){
	    		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	}
		});	
	}
	
	function change(){
		if(userPass.value=="")
			alert("비밀번호를 입력하세요.")
		else if(userPass.value==this.pass){
			alert("기존 비밀번호와 같아요");
		}
		else{
			$('#sub').attr("type","submit");
		}
	}
	
	function compare(){
		if((document.getElementById("userPass").value)==(document.getElementById("userPass2").value)){
			document.getElementById("pwCheck").innerHTML="비밀번호가 일치합니다.";	
			$('#pwCheck').css("color","blue")
			$('#sub').removeAttr("disabled");	
		}
		else{
			document.getElementById("pwCheck").innerHTML="비밀번호가 불일치합니다.";
			$('#pwCheck').css("color","red")
			$('#sub').attr("disabled","disabled");
		}
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
			<input type="text" id="userPass" name="userPass" oninput="pwcheck(userPass.value),pwCheck()">
			<span id="pwCheckF"></span>
		</p>
		<p>
			<label for="userPass2">패스워드확인</label>
			<input type="text" id="userPass2" name="userPass2" oninput="compare()">
			<span id="pwCheck"></span>
		</p>
		<p>
			<button type="button" id="sub" class="sub" onclick="change()" disabled>회원정보 수정</button>
		</p>
		<p>
			<button type="button" onclick="back()">처음으로</button>
		</p>
	</form>
</body>
</html>