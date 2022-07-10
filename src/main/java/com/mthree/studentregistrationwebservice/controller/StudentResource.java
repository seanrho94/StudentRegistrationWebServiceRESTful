package com.mthree.studentregistrationwebservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.studentregistrationwebservice.Student;
import com.mthree.studentregistrationwebservice.service.IService;



@RestController
public class StudentResource {
	@Autowired
	private IService service;
	
	@GetMapping(value = "/")
	public ModelAndView getTemplate() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	@GetMapping(path = "/students")
	public @ResponseBody List<Student> retriveAllStudents() { 
		System.out.println("Inside retriveAllStudents of StudentResource");
		return service.findAll();
	}
	
	//@CrossOrigin("*")
	@PostMapping(path = "/students", consumes = "application/json")
	public Student createStudent(@RequestBody @Valid Student student, BindingResult result, Model model) { // When json comes in as a input, use @RequestBody to tell Jackson.jar to convert it into java code.
		System.out.println("Inside createStudent of UserResource: " + student);
		if(result.hasErrors()) {
			return student;
		} else {
			return service.save(student);
		}
	}
}
