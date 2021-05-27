<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@page import="com.pst.sms.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<% StudentDto dto=(StudentDto)request.getAttribute("dto");
 
if(dto==null)
{
	dto=new StudentDto();
	dto.setRoll_number(0);
	dto.setName("");
	dto.setCourse("");
	dto.setGender("");
}
%>

<div> <%@include file="header.html" %> </div>

<center>

<div class="search">
<h1>Update Student page</h1>
<h4 style="color:green" > </h4>
<form action="./SearchStudentController" method="post">
<pre>
Student RollNumber : <input name="roll_number" type="text" />
</pre>
<pre> <input type="submit" value="search"/> </pre>
</form></div>
<%   String msg=request.getParameter("msg");
      if(msg==null) msg=""; %>
<h4 style="color:green"><%=msg %></h4>
<div>
<form name="student_form" action="./UpdateStudentController" method="post" >
<table>
<% String rollNum="";
  if(dto.getRoll_number()!=0)
   rollNum=String.valueOf(dto.getRoll_number());
%>
<tr><td>Roll No</td><td><input type="text" name="roll_number"  value="<%= rollNum%>"></td></tr>
<tr><td>Student Name</td><td><input type="text" name="student_name" value="<%= dto.getName() %>" />  </td></tr>
<tr><td>Gender</td><td><input type="text"  value="<%= dto.getGender()%>" name="gender"/></td></tr>
<tr><td>Course</td> <td> <input type="text"  value="<%= dto.getCourse() %>" name="course"/></td></tr>
<tr>
<td><input type="submit" value="Update"/> </td>
<td><input type="button" value=" Cancel"/></td>
</tr>
</table>
</form>
</div>
</center>

<div> <%@include file="footr.html" %> </div>
</body>
</html>