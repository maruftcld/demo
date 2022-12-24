package com.spring.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.StudentDAO;
import com.spring.model.Attendance;
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
	
	public String saveStudent(Student student) {	
		String status = "";
		studentDAO.save(student);
		return status;
	}
	
	public List<Student> getAll(){
        return studentDAO.getAll();
	}

	public String saveBatchStudent(HttpServletRequest request) {	
		Map<String, String[]> map = request.getParameterMap();
		String[] codes = map.get("code[]");
		String[] names = map.get("name[]");
		String[] courses = map.get("course[]");
		String[] statuses = map.get("status[]");
		System.out.println(statuses);
		for (int i = 0; i < statuses.length; i++) {
			System.out.println(codes[i] + "   " + statuses[i]);
			if(statuses[i] == null) {
				System.out.println("Absent");
			}else {
				System.out.println("Present");
			}
			Attendance attendance = new Attendance();
			attendance.setName(names[i]);
			attendance.setCourse(courses[i]);
			attendance.setCode(codes[i]);
			attendance.setStatus("Present");
			int saveStatus = studentDAO.saveAttendance(attendance);
		}
		
		return "Attendance saved";
	}

}
