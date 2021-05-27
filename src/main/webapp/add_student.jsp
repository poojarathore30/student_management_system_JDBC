<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student page</title>
</head>
<body>
<script type="text/javascript">
function dovalidate() {

	var roll=document.forms["student_form"]["roll_number"].value;
	var name=document.forms["student_form"]["student_name"].value;
	var course=document.forms["student_form"]["course"].value;
	var roll_status=true;
	var name_status=true;
	var course_status=true;
	var roll_msg;
	var name_msg;
	var course_msg;	
	   if(document.getElementById("roll_msg").innerHTML !=" "	)
		   { document.getElementById("roll_msg").innerHTML=" ";	}
	   
	   if(document.getElementById("name_msg").innerHTML !=" "	)
	   { document.getElementById("name_msg").innerHTML=" ";	}
	   
	   if(document.getElementById("course_msg").innerHTML !=" "	)
	   { document.getElementById("course_msg").innerHTML=" ";	}
	   
		if(!roll) { 
			roll_status=false; roll_msg="* Please enter Roll No";
			var span_ele=document.getElementById("roll_msg");
			span_ele.style.color="red";
			span_ele.innerHTML=roll_msg;
		}
		if(!name) { 
			name_status=false; name_msg="* Please enter name";
			var span_ele=document.getElementById("name_msg");
			span_ele.style.color="red";
			span_ele.innerHTML=name_msg;
		}
		if(!course) { 
			course_status=false; course_msg="* Please select course";
			var span_ele=document.getElementById("course_msg");
			span_ele.style.color="red";
			span_ele.innerHTML=course_msg;
			}
		
		if(!roll_status|| !name_status || !course_status) return false;
}
</script>
<%
    String msg=(String)request.getAttribute("msg");
    if(msg==null) msg="";
%>

<div> <%@include file="header.html" %> </div>

<div class="form_container">
<center>
<h1> Add Student</h1>
<h4 style="color:green"> <%= msg %> </h4>
<form name="student_form" action="./AddStudentController" method="post" onsubmit="return dovalidate()" >
<table>
<tr><td>Roll No</td><td><input type="text" name="roll_number"/> <span id="roll_msg"></span> </td></tr>
<tr><td>Student Name</td><td><input type="text" name="student_name"/> <span id="name_msg"></span> </td></tr>
<tr><td>Gender</td><td><input type="radio" checked="checked" value="male" name="gender"/> Male &nbsp;&nbsp;&nbsp;<input value="female" name="gender" type="radio"> Female</td></tr>
<tr><td>Course</td> <td>
<select name="course">
<option  value="">---Select---</option>
<option value="java">---Java---</option>
<option value="react">---React---</option>
<option value=".net">---.NET---</option>
</select> <span id="course_msg"></span>
</td>  </tr>
<tr>
<td><input type="submit" value="Add student"/> </td>
<td><input type="button" value=" Cancel"/></td>
</tr>
</table>
</form>
</center>
</div>
<div> <%@include file="footr.html" %> </div>
</body>
</html>