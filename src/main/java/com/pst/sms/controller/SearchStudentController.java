package com.pst.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pst.sms.dao.StudentDao;
import com.pst.sms.dto.StudentDto;
import com.pst.sms.service.StudentService;

@WebServlet("/SearchStudentController")
public class SearchStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentService service=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollNUmber=Integer.parseInt(request.getParameter("roll_number"));
		service=new StudentService();
		StudentDto dto= service.searchStudent(rollNUmber);
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("./update_student.jsp").forward(request, response);
		
	}

}
