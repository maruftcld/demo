package com.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.StudentDAO;
import com.spring.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentDAO studentDAO; 
	
	public String save(HttpServletRequest request) {	
		String status = "";
		String name = request.getParameter("student_name");
		String course = request.getParameter("student_course");
		String code = request.getParameter("student_code");
		
		if(name.length() > 5) {
			status = "Length is greater than 5";
		}else if(!course.equals("JEE")) {
			status = "NOT a JEE student";
		}else {
			//database
			Student student = new Student();
			student.setName(name);
			student.setCourse(course);
			student.setCode(code);
			int saveStatus = studentDAO.save(student);
			
			if(saveStatus > 0) {
				status = "Data Saved";
			}else {
				status = "Data NOT Saved";
			}
			
		}
		return status;
	}

}
