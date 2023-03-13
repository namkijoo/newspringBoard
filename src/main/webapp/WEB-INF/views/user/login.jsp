<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<script>
 function logout(){
	 location.href = "logout"
 }
</script>
<body>
 Login Page
 <form action="loginCheck" id="loginCheck">
 	<input type="text" id="id" name="id" value="admin">
 	<input type="text" id="pwd" name="pwd" value="welcome1">
 	<input type="submit" value="submit">
 	<button type="button" onclick="javascript:logout();">logout</button>
 </form>
</body>
</html>