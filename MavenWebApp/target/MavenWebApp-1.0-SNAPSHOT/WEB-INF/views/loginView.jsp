<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<p style="color: red;">${errorString}</p>


	<form method="POST" action="${pageContext.request.contextPath}/login">
		<br>
		<fieldset>
			<legend>Login Page</legend>
			<input type="text" name="userName" placeholder="Login" /> <br> <input
				type="password" name="password" placeholder="Password" /> <br> <input
				type="submit" value="Submit" />
		</fieldset>
	</form>

	<p style="color: blue;">Username: admin, password: admin</p>

	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>