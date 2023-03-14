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
</script>
<body>
 Login Page
 <form action="/login" id="loginCheck" method="post">
 	<input type="text" name="userId" >
 	<input type="text" name="userPass">
 	<input type="submit" value="login">
 	<button type="button" onclick="javascript:logout();">logout</button>
 	<button type="button" onclick="javascript:register();">register</button>
 </form>
</body>
</html>