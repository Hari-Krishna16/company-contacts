<%@page import="org.omg.CORBA.Request"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>amazon</title>
</head>
<body>
<form action="save" method="post">
        Name: <input type="text" name="name"><br>
        Email: <input type="text" name="email"><br>
        Phone: <input type="text" name="phone"><br>
        Address: <input type="text" name="address"><br>
        Website: <input type="text" name="website"><br>
        <input type="submit">
    </form>
    <br>
    <form action="delete">
        Enter company Id for Delete : <input type="text" name="userId"> <br/>
        <input type="submit">
    </form>
<br/>
    <form action="get" method="get">
        Enter company to Get: <input type="text" name="userID"><br>
        <input type="submit">
    </form>
    <br/>
 
    <form action="getList" method ="get">
    <input type ="submit" value ="GetList">
    </form>
    <br/>
   
    <form action="update" method ="get">
      Enter Id To Update :<input type ="text" name ="userId"> <br/>
    <input type ="submit">
    </form>
</body>
</html>