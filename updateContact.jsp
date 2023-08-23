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
	Map<String, Object> companyDataSet = (Map<String, Object>) session.getAttribute("companyDataSet");
    String userId ="";    
    String name = "";
    String email ="";
    String phone ="";
    String address ="";
    String dateOfBirth ="";
    String companyName ="";
    if (dataSet != null) {
    	userId = String.valueOf(dataSet.get("pk_id"));
        name = String.valueOf(dataSet.get("name"));
        email = String.valueOf(dataSet.get("email"));
        phone = String.valueOf(dataSet.get("phone"));
        address = String.valueOf(dataSet.get("address"));
        dateOfBirth = String.valueOf(dataSet.get("dateofbirth"));
        companyName = String.valueOf(companyDataSet.get("name"));
    }
%>
	<form action="updateContactToDb" method="post">
    User Id: <input type="text" name="userId" value=<%=userId %> readonly><br/>
    Name : <input type="text" name="name" value="<%= name %>"><br />
    email : <input type="text" name="email" value="<%= email %>"><br />
    phone : <input type="text" name="phone" value="<%= phone %>"><br />
    address : <input type="text" name="address" value="<%= address %>"><br />
    dateOfBirth : <input type="text" name="dateOfBirth" value="<%= dateOfBirth %>"><br />
    companyName : <input type="text" name="companyName" value="<%= companyName %>"><br />
    <input type="submit">
</form>

</body>
</html>
