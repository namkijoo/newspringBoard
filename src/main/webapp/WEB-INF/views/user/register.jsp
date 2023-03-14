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
					$('.submit').removeAttr("disabled");
				}
				else{
					$('.id_already').css("display","inline-block");
					$('.id_ok').css("display","none");
					$('.submit').attr("disabled","disabled");
					
				}
			},
			error:function(request,error){
				alert("에러입니다");
			 	alert("code:"+request.status+"\n"+"mesaage:"+request.responseText+"\n"+"error:"+error);
			}
		})
	}
</script>
</head>
<body>
	<form action="/register" method="post">
		<div>
			<label>아이디</label>
			&nbsp;&nbsp;&nbsp;<input type="text" id="userId" name="userId" required oninput="checkId()">
			<span class="id_ok" style="display:none; color:blue;">사용 가능한 아이디 입니다.</span>
			<span class="id_already" style="display:none; color:red;">중복된 아이디 입니다.</span>
		</div>
		<div>
			<label>패스워드</label>
			<input type="text" id="userPass" name="userPass" oninput="pwCheck(userPass.value)">
			<p id="pwCheckF"></p>
		</div>
		<br>
		<div>
			<button type="submit" id="submit" class="submit"  >회원가입</button>
			<button type="button" onclick="back()">취소</button>
		</div>
	</form>
</body>
</html>