<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details Page</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>

	<h3>Employee Details Page</h3>

	<p style="color: red;">${errorString}</p>

	<form method="POST" action="${pageContext.request.contextPath}/editEmployee">
		<br>
		<fieldset>
			<legend>Employee Details ${employee.firstName} ${employee.name}</legend>
			Name
			<input type="hidden" name="DBemail" value="${employee.email}" /> <br>
            <input type="text" name="name" value="${employee.name}" /> <br>
            Firstname
            <input type="text" name="firstName" value="${employee.firstName}" /> <br>
            HomePhone
            <input type="text" name="homePhone" value="${employee.homePhone}" /> <br>
            MobilePhone
            <input type="text" name="mobilePhone" value="${employee.mobilePhone}" /> <br>
            WorkPhone
            <input type="text" name="workPhone" value="${employee.workPhone}" /> <br>
            Address
            <input type="text" name="address" value="${employee.address}" /> <br>
            PostalCode
            <input type="text" name="postalCode" value="${employee.postalCode}" /> <br>
            City
            <input type="text" name="city" value="${employee.city}" /> <br>
            Email
            <input type="text" name="email" value="${employee.email}" /> <br>
            
            <input type="submit" name="submit" value="Save" />
            <a href="listOfEmployees">Cancel</a>
		</fieldset>
	</form>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>