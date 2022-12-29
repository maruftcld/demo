package com.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Attendance;
import com.spring.model.Student;
import com.spring.service.StudentService;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@Autowired 
	ServletContext servletContext;

	@RequestMapping("/create")
	public ModelAndView create() {
		//System.out.println(request);
		
	    System.out.println("hello");
		return new ModelAndView("student/create");
	}
	
	@RequestMapping(value = "/_save", headers=("content-type=multipart/*"), method = RequestMethod.POST)
	public ModelAndView _save(HttpServletRequest request,
			@RequestParam("photo") MultipartFile photo) throws IOException {
		String photoname = request.getParameter("code") + ".jpg";
		
		saveFile(photo, photoname, "assets/images");
		//traineeDAO.save(trainee);
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	private void saveFile(MultipartFile file, String fileName, String path) throws IOException {
		byte[] bytes  = file.getBytes();
		String filePath = servletContext.getRealPath(path);
		File dir = new File(filePath);
		File serverFile = new File(dir.getAbsolutePath()
				+ File.separator + fileName);
		System.out.println(serverFile);
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request) {
		String msg = studentService.save(request);
		return new ModelAndView("student/create", "msg", msg);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") String id) {
		System.err.println(id + " ..........");

		return null;
	}
	
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
		System.out.println("hit");
		System.err.println(student.getCountry());
		String msg = studentService.saveStudent(student);
		return new ModelAndView("student/create", "msg", msg);
	}
	
	@RequestMapping(value = "/saveBatchStudent", method = RequestMethod.POST)
	public ModelAndView saveBatchStudent(HttpServletRequest request) {
		String msg = studentService.saveBatchStudent(request);
		return new ModelAndView("student/create", "msg", msg);
	}
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Student> getAll() {
		return studentService.getAll();
	}
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show() {
		List<Student> students = studentService.getAll();
		return new ModelAndView("student/view", "students", students);
	}
	
	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public ModelAndView showAll() {
		List<Student> students = studentService.getAll();
		List<Attendance> attends = studentService.getAllAttendances();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("students", students);
		map.put("attendances", attends);
		
		return new ModelAndView("student/view", "map", map);
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
