package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Student;
import com.spring.service.StudentService;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/create")
	public ModelAndView create() {
	    System.out.println("hello");
		return new ModelAndView("student/create");
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request) {
		String msg = studentService.save(request);
		return new ModelAndView("student/create", "msg", msg);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Student> getAll() {
		return studentService.getAll();
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get() {
		System.out.println("heldfgdfl");
		return "hello string";
	}
	
	
	
//	@RequestMapping("/create")
//	public String create() {
//	    System.out.println("herllo  cxgvdcvbcd");
//		return "student/create";
//	}
//	
//	@RequestMapping(value = "/create", method = RequestMethod.GET)
//	public String create() {
//	    System.out.println("hello");
//		return "student/create";
//	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String save(HttpServletRequest request) {
//		String name = request.getParameter("student_name");
//		String course = request.getParameter("student_course");	
//		System.out.println(name);
//		System.out.println(course);
//		return "student/create";
//	}
	
	
	
}
