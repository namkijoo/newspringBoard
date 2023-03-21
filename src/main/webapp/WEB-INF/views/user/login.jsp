<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<script>
 function logout(){
	 location.href = "logout"
 }
 
 function register(){
	 location.href="register"
 }
 
a=false
function show(){
	a=!a
	if(a){
		document.getElementById("userPass").type="text";
		document.getElementById("pwBtn").innerHTML="숨기기";	
	}
	else if(!a){
		document.getElementById("userPass").type="password";
		document.getElementById("pwBtn").innerHTML="보이기";	
	}
		
	
}
</script>
<body>
 <h1>Login Page</h1>
 <form action="/login" id="loginCheck" method="post">
 	<label for="userId">아이디 : </label>&nbsp;&nbsp;&nbsp;<input type="text" name="userId" ><br>
 	<label for="userPass">비밀번호 : </label><input type="password" id="userPass" name="userPass"><button type="button" id="pwBtn" onclick="show()">보이기</button>
 	<br><br>
 	<input type="submit" value="login">
 	<button type="button" onclick="javascript:logout();">logout</button>
 	<button type="button" onclick="javascript:register();">register</button>
 </form>
</body>
</html>