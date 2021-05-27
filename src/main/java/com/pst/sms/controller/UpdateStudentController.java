package com.pst.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pst.sms.service.StudentService;
import com.pst.sms.vo.StudentVO;

@WebServlet("/UpdateStudentController")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   StudentVO studentVO=null;
    StudentService studentService=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roll_number=Integer.parseInt(request.getParameter("roll_number"));
		String name=request.getParameter("student_name");
		String gender=request.getParameter("gender");
		String course=request.getParameter("course");
		studentVO= new StudentVO();
		studentVO.setRoll_number(roll_number);
		studentVO.setName(name);
		studentVO.setGender(gender);
		studentVO.setCourse(course);
		studentService=new StudentService();
		int i=studentService.modifyStudent(studentVO);
		if(i!=0)
		{
			String msg="Successfully updated to DB";
			response.sendRedirect("./update_student.jsp?msg="+msg);
		}
		
	}

}
