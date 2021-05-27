<%@page import="com.pst.sms.dto.StudentDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Students</title>
</head>
<body>

<% List<StudentDto> list=(ArrayList<StudentDto>)request.getAttribute("list"); %>
<div> <%@include file="header.html" %> </div>

<center>
<h1>List Of All Students</h1>
<table border="1px">
<thead>
<tr>
<td>Roll Number</td>
<td>Name</td>
<td>Gender</td>
<td>Course</td>
</tr>
</thead>
<%  for(StudentDto d:list){ %>
	<tr><td><%= d.getRoll_number() %></td> <td><%= d.getName() %></td> <td><%= d.getGender() %></td> <td><%= d.getCourse() %></td></tr>
<% } %>
</table>
</center>
<div> <%@include file="footr.html" %> </div>

</body>
</html>