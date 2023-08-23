<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Company</title>
</head>
<body>
	<%
    Map<String, Object> dataSet = (Map<String, Object>) session.getAttribute("DataSet");
    String userId ="";    
    String name = "";
    String email ="";
    String phone ="";
    String address ="";
    String website ="";
    if (dataSet != null) {
    	userId = String.valueOf(dataSet.get("pk_id"));
        name = String.valueOf(dataSet.get("name"));
        email = String.valueOf(dataSet.get("email"));
        phone = String.valueOf(dataSet.get("phone"));
        address = String.valueOf(dataSet.get("address"));
        website = String.valueOf(dataSet.get("website"));
    }
%>
	<form action="updateDb" method="post">
    User Id: <input type="text" name="userId" value=<%=userId %> readonly><br/>
    Name : <input type="text" name="name" value="<%= name %>"><br />
    email : <input type="text" name="email" value="<%= email %>"><br />
    phone : <input type="text" name="phone" value="<%= phone %>"><br />
    address : <input type="text" name="address" value="<%= address %>"><br />
    website : <input type="text" name="website" value="<%= website %>"><br />
    <input type="submit">
</form>

</body>
</html>
