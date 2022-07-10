package com.mthree.studentregistrationwebservice.service;

import java.util.List;

import com.mthree.studentregistrationwebservice.Student;

public interface IService {
	public List<Student> findAll();
	public Student save(Student user);
}
