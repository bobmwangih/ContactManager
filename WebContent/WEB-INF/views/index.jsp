<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
	font-family: "lato", sans-serif;
}

.container {
	max-width: 1000px;
	margin-left: auto;
	margin-right: auto;
	padding-left: 10px;
	padding-right: 10px;
}

h2 {
	font-size: 26px;
	margin: 20px 0;
	text-align: center;
	small
	{
	font-size
	:
	0.5em;
}

}
.responsive-table {li { border-radius:3px;
	padding: 25px 30px;
	display: flex;
	justify-content: space-between;
	margin-bottom: 25px;
}

.table-header {
	background-color: #95a5a6;
	font-size: 14px;
	text-transform: uppercase;
	letter-spacing: 0.03em;
}

.table-row {
	background-color: #ffffff;
	box-shadow: 0px 0px 9px 0px rgba(0, 0, 0, 0.1);
}

.col-1 {
	flex-basis: 10%;
}

.col-2 {
	flex-basis: 40%;
}

.col-3 {
	flex-basis: 25%;
}

.col-4 {
	flex-basis: 25%;
}

@media all and (max-width: 767px) {
	.table-header {
		display: none;
	}
	.table-row {
		
	}
	li {
		display: block;
	}
	.col {
		flex-basis: 100%;
	}
	.col {
		display: flex;
		padding: 10px 0; &: before { color : #6c7a89;
		padding-right: 10px;
		content: attr(data-label);
		flex-basis: 50%;
		text-align: right;
	}
}
}
}
</style>
<title>Contact Manager</title>
</head>
<body>

	<div align="center">
		<h1>Contact List</h1>
		<h3><a href ="New">New Contact</a></h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
			<c:forEach items ="${listContact}" var="contact" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${contact.name}</td>
				<td>${contact.email}</td>
				<td>${contact.address}</td>
				<td>${contact.phone}</td>
				<td><a href="Edit">Edit</a></td>
				<td><a href ="Delete">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>