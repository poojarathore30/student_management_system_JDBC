package com.pst.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pst.sms.service.StudentService;

@WebServlet("/DeleteStudentController")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService service=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollNumber=Integer.parseInt(request.getParameter("roll_number"));
		service=new StudentService();
		boolean status= service.removeStudent(rollNumber);
		if(status==false)
		{
			String msg="Student Deleted Successfully";
			
			response.sendRedirect("./delete_student.jsp?message="+msg);
		}
	}

}
