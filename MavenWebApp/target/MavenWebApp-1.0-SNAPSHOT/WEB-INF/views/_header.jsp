<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>Employees Management Application </h1>
  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
 
     <!-- User store in session with attribute: loginedUser -->
     You session is active <b>${loginedUser.userName}</b>
     <form method="POST" action="${pageContext.request.contextPath}/logout">
			<input type="submit" name="logout" value="LogOut"/>
	</form>
   <br/>
 	
  </div>
 
</div>