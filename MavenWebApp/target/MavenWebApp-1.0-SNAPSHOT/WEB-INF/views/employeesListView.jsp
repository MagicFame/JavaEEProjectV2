<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Employees</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>

	<h3>List Of Employees</h3>

	<p style="color: red; font-weight: bold;">${errorString}</p>

	<form method="POST"
		action="${pageContext.request.contextPath}/manageEmployee">
		<table>
			<tr>
				<th>Sél</th>
				<th>NAME</th>
				<th>FIRST NAME</th>
				<th>HOME PHONE</th>
				<th>MOBILE PHONE</th>
				<th>WORK PHONE</th>
				<th>ADDRESS</th>
				<th>POSTAL CODE</th>
				<th>CITY</th>
				<th>EMAIL</th>
			</tr>
			<c:forEach items="${employeesList}" var="employee">
				<tr>
					<td><input type="radio" id="${employee.email}" name="sel"
						value="${employee.email}"></td>
					<td>${employee.name}</td>
					<td>${employee.firstName}</td>
					<td>${employee.homePhone}</td>
					<td>${employee.mobilePhone}</td>
					<td>${employee.workPhone}</td>
					<td>${employee.address}</td>
					<td>${employee.postalCode}</td>
					<td>${employee.city}</td>
					<td>${employee.email}</td>
				</tr>
			</c:forEach>
			
		</table>
		<p style="color: blue; font-weight: bold">${error}</p>
		<input type="submit" name="submit" value="Delete" />
		<input type="submit" name="submit" value="Details" />
		<input type="submit" name="submit" value="Add" />
		
	</form>
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>