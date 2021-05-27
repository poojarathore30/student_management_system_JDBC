package com.pst.sms.service;

import java.util.List;
import com.pst.sms.bo.StudentBO;
import com.pst.sms.dao.StudentDao;
import com.pst.sms.dto.StudentDto;
import com.pst.sms.vo.StudentVO;

public class StudentService {
	StudentDao student_dao=null;
	StudentBO student_bo=null;
	StudentDto student_dto=null;
  public int saveStudent(StudentVO studentVO){
	   // business operation
	  student_dao=new StudentDao();
	  student_bo=new StudentBO();
	  student_bo.setRoll_number(studentVO.getRoll_number());
	  student_bo.setName(studentVO.getName());
	  student_bo.setGender(studentVO.getGender());
	  student_bo.setCourse(studentVO.getCourse());
	  
	  int i=student_dao.addStudent(student_bo);
	  return i;
  }
  
  public List<StudentDto> getAllStudents()
  {
	  student_dao=new StudentDao();
	  return student_dao.viewStudents();
  }
  
  public boolean removeStudent(int rollNUmber) {
	  student_dao=new StudentDao();
	  return student_dao.delete(rollNUmber);
  }
  public StudentDto searchStudent(int rollNUmber) {
	  student_dao=new StudentDao();
	  return student_dao.getStudentDetails(rollNUmber);
  }
  public int  modifyStudent(StudentVO studentVO) {
	  student_dao=new StudentDao();
	  student_bo=new StudentBO();
	  student_bo.setRoll_number(studentVO.getRoll_number());
	  student_bo.setName(studentVO.getName());
	  student_bo.setGender(studentVO.getGender());
	  student_bo.setCourse(studentVO.getCourse());
	  
	  int i=student_dao.update_student(student_bo);
	  return i;
}
}







