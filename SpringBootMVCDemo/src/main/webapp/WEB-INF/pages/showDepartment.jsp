<%@page import="com.cov.beans.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Department page</title>
</head>
<body>
	<h2>Department Details</h2>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Edit</th>
		</tr>





		<%
		List<Department> depts = (List<Department>) request.getAttribute("depts");
		for (Department dept : depts) {
		%>



		<tr>
			<td><%=dept.getId()%></td>
			<td><%=dept.getName()%></td>
			<td><a href="editDept?id=<%=dept.getId()%>">Edit</a></td>
		</tr>





		<%
		}
		%>
	</table>
	<a href="/">Home</a><br><br>
	
	<a href="regdept">Register Department</a><br><br>



</body>
</html>