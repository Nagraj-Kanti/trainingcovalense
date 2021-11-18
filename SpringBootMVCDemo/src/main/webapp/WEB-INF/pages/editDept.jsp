<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department editing page</title>
</head>
<body>
	<h2>Update Department Details</h2>
	<form:form action="updateDept" modelAttribute="deptToEdit">
		<form:label path="id">ID</form:label>
		<form:input path="id" readonly="true" />
		<br>
		<br>
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>

		<input type="submit" value="Update">
	</form:form>
	<br><br>
	<a href="/">Home</a><br><br>
</body>
</html>