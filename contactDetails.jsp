<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company Details</title>
</head>
<body>
	<h2>Data:</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Address</th>
			<th>DateOfBirth</th>
			<th>companyId</th>
		</tr>
		<tr>
			<td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("pk_id") %></td>
			<td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("name") %></td>
			<td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("email") %></td>
			<td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("phone") %></td>
			<td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("address") %></td>
			<td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("dateofbirth") %></td>
			<td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("company_id") %></td>
		</tr>
	</table>
</body>
</html>
