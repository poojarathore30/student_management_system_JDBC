package com.pst.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pst.sms.service.StudentService;
import com.pst.sms.vo.StudentVO;

@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentVO studentVO=null;
	StudentService studentService=null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from UI
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
		int i=studentService.saveStudent(studentVO);
		if(i!=0)
		{
			String msg="Successfully added to DB";
			request.setAttribute("msg",msg );
			request.getRequestDispatcher("./add_student.jsp").forward(request, response);
		}
		
	}

}
