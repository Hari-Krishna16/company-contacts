<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="savecontact" method ="post">
          Name: <input type="text" name="name"><br>
        Email: <input type="text" name="email"><br>
        Phone: <input type="text" name="phone"><br>
        Address: <input type="text" name="address"><br>
       DOB : <input type ="text" name ="dateOfBirth"><br/>
       company:<input type ="text" name ="companyName"><br/>
       <input type ="submit">
</form>
<form action="deleteContact" method ="post">
Enter User ID TO Delete :<input type ="text" name = "userId"><br/>
<input type ="submit">
</form>
<form action="getRow" method ="get">
Enter User ID :<input type ="text" name ="userId"><br/>
<input type ="submit">
</form>
<br/>
<form action="getListData" method ="get">
<input type ="submit" value ="getList">
</form>
<br/>
<form action="updateContact" method ="get">
Enter Id To Update :<input type ="text" name ="userId"><br/>
<input type ="submit">
</form>
</body>
</html>