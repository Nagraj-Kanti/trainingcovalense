<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Registration Page</title>
</head>
<body>
	<h2>Department Registration</h2>
	<form:form action="regdept" method="post" modelAttribute="department">

		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>
		<input type="submit" value="Register">
	</form:form>
	<br><br>
	<a href="getDepts">Show Department</a><br><br>
	<a href="/">Home</a><br><br>
	

</body>
</html>