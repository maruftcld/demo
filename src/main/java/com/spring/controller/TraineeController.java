package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.common.ICommonController;
import com.spring.dao.TraineeDAO;
import com.spring.model.Student;
import com.spring.model.Trainee;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("trainee")
public class TraineeController{

	@Autowired
	TraineeDAO traineeDAO;

	public ModelAndView create() {
		// TODO Auto-generated method stub
		return null;
	}

	
	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public ModelAndView save(@RequestBody Trainee trainee) {
		traineeDAO.save(trainee);
		
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ResponseEntity<Trainee> edit(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		Trainee t = traineeDAO.getTraineeById(Integer.valueOf(id));
		return ResponseEntity.ok().body(t);
	}

	public ModelAndView update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		System.err.println(id);
		traineeDAO.delete(Integer.valueOf(id));
		return null;
	}

	public ModelAndView getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@GetMapping("/getAll")
	public List<Trainee> getAll1() {
		return traineeDAO.getAll();
	}

	public ModelAndView save(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
