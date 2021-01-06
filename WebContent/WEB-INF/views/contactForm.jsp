<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New contact/Edit</title>
</head>
<body>
	<div align="center">
		<h1>New contact/ edit</h1>
		<form:form action="save" method="post" modelAttribute="contact">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>address</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>phone</td>
					<td><form:input path="phone" /></td>
				</tr>		
			</table>
			<div align ="center"><input type="submit" value="Save" /></div>
		</form:form>
	</div>
</body>
</html>