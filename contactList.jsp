<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Company List</title>
</head>
<body>

<h1>Contact List</h1>

<%
    List<Map<String, Object>> dataSet = (List<Map<String, Object>>) session.getAttribute("DataSet");
    if (dataSet != null && !dataSet.isEmpty()) {
    	out.println("<table border='1'>");
    	out.println("<tr><th>ID</th><th> Name</th><th> Email</th><th> Phone</th><th> Address</th><th> DOB</th><th>companyId </th></tr>");
    	for (Map<String, Object> data : dataSet) {
    	    out.println("<tr>");
    	    out.println("<td>" + data.get("pk_id") + "</td>");
    	    out.println("<td>" + data.get("name") + "</td>");
    	    out.println("<td>" + data.get("email") + "</td>");
    	    out.println("<td>" + data.get("phone") + "</td>");
    	    out.println("<td>" + data.get("address") + "</td>");
    	    out.println("<td>" + data.get("dateofbirth") + "</td>");
    	    out.println("<td>" + data.get("company_id") + "</td>");
    	    out.println("</tr>");
    	}
    	out.println("</table>");

    } else {
        out.println("<p>No company data available.</p>");
    }
%>

</body>
</html>
