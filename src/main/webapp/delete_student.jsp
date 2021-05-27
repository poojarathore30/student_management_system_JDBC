<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>
</head>
<body>
<%
String msg=request.getParameter("message");
if(msg==null)
{
	msg="";
}
%>

<div> <%@include file="header.html" %> </div>

<center>
<h1>Delete Student page</h1>
<h4 style="color:green" ><%= msg %> </h4>
<form action="./DeleteStudentController" method="post">
<pre>
Student RollNumber : <input name="roll_number" type="text" />
</pre>
<pre> <input type="submit" value="delete"/> </pre>
</form>
</center>

<div> <%@include file="footr.html" %> </div>
</body>
</html>