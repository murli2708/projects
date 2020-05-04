<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to catchecho</title>
<style type="text/css">
table,th,td{
border:0px rgb(180,151,151) solid;
border-collapse:collapse;
font-size:25px;
}
.mytable{
width:90%;
}
tr:nth-child(odd){
background-color:azure;
}
tr:nth-child(even){
background-color:lavender;
}
</style>
</head>
<body>
<div align="center">
<table>
<tr>
<td align="center" colspan="3">Book Details</td>
</tr>
<tr>
<td>Book Id</td>
<td>${MyBook.bid}</td>
</tr>
<tr>
<td>Book Name</td>
<td>${MyBook.bname}</td>
</tr><tr>
<td>Author</td>
<td>${MyBook.author}</td>
</tr>
<tr>
<td>Price</td>
<td>${MyBook.price}</td>
</tr>
<tr>
<td>Category</td>
<td>${MyBook.category}</td>
</tr>
<tr>
<td>Publication</td>
<td>${MyBook.pub}</td>
</tr>
</table>
<h2><a href="showAllBooks">Goto Book Home</a></h2>
</div>
</body>
</html>