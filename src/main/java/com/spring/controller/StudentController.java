package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("student")
public class StudentController {
	
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
	
	@RequestMapping("/create")
	public ModelAndView create() {
	    System.out.println("herllo  cxgvdcvbcd");
		return new ModelAndView("student/create");
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request) {
		String name = request.getParameter("student_name");
		String course = request.getParameter("student_course");	
		System.out.println(name);
		System.out.println(course);
		return new ModelAndView("student/create", "dfgd", course);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ModelAndView getAll() {
		System.out.println("heldfgdfl");
		return new ModelAndView("student/create");
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get() {
		System.out.println("heldfgdfl");
		return "hello string";
	}
	
	
}
