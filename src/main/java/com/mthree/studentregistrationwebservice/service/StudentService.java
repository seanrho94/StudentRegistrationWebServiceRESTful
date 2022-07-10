package com.mthree.studentregistrationwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.mthree.studentregistrationwebservice.Student;
import com.mthree.studentregistrationwebservice.dao.IDAO;

@Service
public class StudentService implements IService {
	@Autowired
	@Qualifier(value = "studentjparepos")
	private IDAO dao;
	
	
	public StudentService() {
		System.out.println("Inside Default Constructor of StudentService");
	}
	
	@Override
	public List<Student> findAll() {
		System.out.println("Inside findAll of StudentService");
		return dao.findAll();
	}

	@Override
	public Student save(Student student) {
		System.out.println("Inside save of UserService");
		dao.save(student);
		return student;
	}

}
