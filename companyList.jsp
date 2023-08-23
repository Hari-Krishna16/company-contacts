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

<h1>Company List</h1>

<%
    List<Map<String, Object>> dataSet = (List<Map<String, Object>>) session.getAttribute("DataSet");
    if (dataSet != null && !dataSet.isEmpty()) {
        out.println("<table border='1'>");
        out.println("<tr><th>Company ID</th><th>Company Name</th><th>Company Email</th><th>Company Phone</th><th>Company Address</th><th>Company WebSite</th><th>Contacts</th></tr>");

        for (Map<String, Object> data : dataSet) {
            out.println("<tr>");
            out.println("<td>" + data.get("pk_id") + "</td>");
            out.println("<td>" + data.get("name") + "</td>");
            out.println("<td>" + data.get("email") + "</td>");
            out.println("<td>" + data.get("phone") + "</td>");
            out.println("<td>" + data.get("address") + "</td>");
            out.println("<td>" + data.get("website") + "</td>");
            
            List<Map<String, Object>> contacts = (List<Map<String, Object>>) data.get("contacts");
            out.println("<td>");
            if (contacts != null && !contacts.isEmpty()) {
                out.println("<table border='1'>");
                out.println("<tr><th>User Id</th><th>Name</th><th> Email</th><th> Phone</th><th> Address</th></tr>");
                for (Map<String, Object> contact : contacts) {
                    out.println("<tr>");
                    out.println("<td>" + contact.get("pk_id") + "</td>");
                    out.println("<td>" + contact.get("name") + "</td>");
                    out.println("<td>" + contact.get("email") + "</td>");
                    out.println("<td>" + contact.get("phone") + "</td>");
                    out.println("<td>" + contact.get("address") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("No contacts available.");
            }
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");

    } else {
        out.println("<p>No company data available.</p>");
    }
%>

</body>
</html>
