<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
            <th>Website</th>
            <th>Contacts</th>
        </tr>
        <tr>
            <td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("pk_id") %></td>
            <td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("name") %></td>
            <td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("email") %></td>
            <td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("phone") %></td>
            <td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("address") %></td>
            <td><%= ((Map<String, Object>) session.getAttribute("dataSet")).get("website") %></td>
            <td><%
                List<Map<String, Object>> contacts = (List<Map<String, Object>>) ((Map<String, Object>) session.getAttribute("dataSet")).get("contacts");
                if (contacts != null && !contacts.isEmpty()) {
                    out.println("<table border='1'>");
                    out.println("<tr><th>User Id</th><th> Name</th><th>Email</th><th>Phone</th><th>Address</th></tr>");
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
                    out.println("<p>No company data available.</p>");
                }
            %></td>
        </tr>
    </table>
</body>
</html>
