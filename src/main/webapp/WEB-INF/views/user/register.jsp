<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>register</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function back(){
		location.href="/";
	}

	function pwCheck(pw){
		$.ajax({
			type:"POST",
			url: "/pwCheck",
			data : { pw: pw },
			success:function(result){	
				if(result == true){				
					pwCheckF.innerHTML = "유효성 체크 문제 없음"; 				
				}else{				
					pwCheckF.innerHTML = "유효성 체크 범위 벗어남"; 
				}
			},
	    	error:function(request,status){
	    		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	}
		});	
	}
	
	
	
	var check1= false
	var check2 = false;
	function pwcheck(pw){
		var regexPw=/^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{8,20}$/;
		if(!regexPw.test(pw)){
			pwCheckF.innerHTML = "유효성 체크 범위 벗어남"; 
			$('#pwCheckF').css("color","red");
			check1=false;
		}
		else{
			pwCheckF.innerHTML = "유효성 체크 문제 없음";
			$('#pwCheckF').css("color","blue");
			check1=true;
		}
	}
	
	function nullCheck(userId,userPass){
		if(userId==""){
			alert("아이디를 입력해주세요");
		}
		if(userPass==""){
			alert("패스워드를 입력해주세요");
		}
	}
	
	function checkK(){
		if(check1==true&&check2==true){
			$('#submit').attr("type","submit");
		}
		else{
			$('#submit').attr("type","button");
		}
			
	}

	
	function checkId(){
		var userId = $('#userId').val();
		$.ajax({
			url:'./idCheck',
			type:'post',
			data : {userId:userId},
			success:function(cnt){
				if(cnt==0){
					$('.id_ok').css("display","inline-block");
					$('.id_already').css("display","none");
					$('#userPass').removeAttr("readonly");
					$('.submit').removeAttr("disabled");
				}
				else{
					$('.id_already').css("display","inline-block");
					$('.id_ok').css("display","none");
					$('#userPass').attr("readonly",true);
					$('.submit').attr("disabled","disabled");
					
				}
			},
			error:function(request,error){
				alert("에러입니다");
			 	alert("code:"+request.status+"\n"+"mesaage:"+request.responseText+"\n"+"error:"+error);
			}
		})
	}
	
	function compare(){
		if((document.getElementById("userPass").value)==(document.getElementById("userPass2").value)){
			document.getElementById("pwCheck").innerHTML="비밀번호가 일치합니다.";	
			$('#pwCheck').css("color","blue")
			check2=true;
		}
		else{
			document.getElementById("pwCheck").innerHTML="비밀번호가 불일치합니다.";
			$('#pwCheck').css("color","red")
			check2=false;
		}
	}
	
</script>
</head>
<body>
	<form action="/register" method="post">
		<div>
			<label>아이디</label>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="userId" name="userId" required oninput="checkId()">
			<span class="id_ok" style="display:none; color:blue;">사용 가능한 아이디 입니다.</span>
			<span class="id_already" style="display:none; color:red;">중복된 아이디 입니다.</span>
		</div>
		<div>
			<label for="userPass">패스워드</label>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="userPass" name="userPass" oninput="pwcheck(userPass.value)">
			<span id="pwCheckF"></span>
		</div>
		<div>
			<label>패스워드 재확인</label>
			<input type="text" id="userPass2" name="userPass2" oninput="compare()">
			<span id="pwCheck"></span>
		</div>
		<br>
		<div>
			<button type="button" id="submit" class="submit" onclick="nullCheck(userId.value,userPass.value),checkK()" >회원가입</button>
			<button type="button" onclick="back()">취소</button>
		</div>
	</form>
</body>
</html>