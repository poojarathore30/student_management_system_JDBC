package com.pst.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pst.sms.bo.StudentBO;
import com.pst.sms.dto.StudentDto;
import com.pst.sms.util.DbConnection;

public class StudentDao {
 private final String UPDATE_STUDENT="update student_data set name=? , gender=? , course=? where roll_number=?";
 private final String SEARCH_STUDENT="select roll_number,name,gender,course from student_data where roll_number=?";
 private final String VIEW_STUDENT="SELECT roll_number, name,gender,course from student_data";
 private final String SAVE_STUDENT="INSERT INTO STUDENT_DATA(roll_number,name,gender,course) values(?,?,?,?)";
 private final String DELETE_STUDENT="DELETE FROM STUDENT_DATA WHERE roll_number=?";
 public int addStudent(StudentBO studentbo){
	 // do DB operation logic
	 int i=0;
	 // prepared statement
	 try {
		Connection con=DbConnection.getConn();
		PreparedStatement ps=con.prepareStatement(SAVE_STUDENT);
		// executing the queries
		ps.setInt(1, studentbo.getRoll_number());
		ps.setString(2, studentbo.getName());
		ps.setString(3,studentbo.getGender());
		ps.setString(4, studentbo.getCourse());
		i=ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return i;
 }
 
 public List<StudentDto> viewStudents() {
	 StudentDto dto=null;
	 List<StudentDto> studentList=new ArrayList<StudentDto>();
	 try {
		Connection con=DbConnection.getConn();
		PreparedStatement ps= con.prepareStatement(VIEW_STUDENT);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			dto=new StudentDto();
			dto.setRoll_number(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setGender(rs.getString(3));
			dto.setCourse(rs.getString(4));
			studentList.add(dto);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return studentList;
 }
 
 
 public boolean delete(int rollNumber) {
	 boolean status=true;
	   	try {
			Connection con=DbConnection.getConn();
			PreparedStatement ps= con.prepareStatement(DELETE_STUDENT);
			ps.setInt(1, rollNumber);
			status= ps.execute();
			System.out.println("status :: "+status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   	return status;
 }
 
 public StudentDto getStudentDetails(int rollNumber)
 {
	 StudentDto dto=null;
	 try {
		Connection con=DbConnection.getConn();
		PreparedStatement ps= con.prepareStatement(SEARCH_STUDENT);
		ps.setInt(1, rollNumber);
		ResultSet rs= ps.executeQuery();
		if(rs.next())
		{
			dto=new StudentDto();
			dto.setRoll_number(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setGender(rs.getString(3));
			dto.setCourse(rs.getString(4));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return dto;
 }
 public int update_student(StudentBO studentbo)
 {
	 int i=0;
	   	try {
			Connection con=DbConnection.getConn();
			PreparedStatement ps= con.prepareStatement(UPDATE_STUDENT);
			ps.setString(1, studentbo.getName());
			ps.setString(2, studentbo.getGender());
			ps.setString(3, studentbo.getCourse());
			ps.setInt(4, studentbo.getRoll_number());
		    i=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   	return i;
 }
 
}
