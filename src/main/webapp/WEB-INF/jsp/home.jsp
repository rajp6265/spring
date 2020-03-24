<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com.example.demo.Alien" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <form action="addAlien" method="post">
                <input type="text" name="aid"> <br>
                <input type="text" name="aname"> <br>
                <input type="text" name="tech"> <br>
                <input type="submit" value="submit">
     </form>
      ___________________________________________________
         <h1>  This is Update Part</h1>
     <form action="updateAlien" method="post">
                <input type="text" name="aid"> <br>
                <input type="text" name="aname"><br>
                 <input type="text" name="tech"><br>              
                <input type="submit" value="Update">
     </form>
     ${aliens}     
</body>
</html>