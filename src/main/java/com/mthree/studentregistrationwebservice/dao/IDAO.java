package com.mthree.studentregistrationwebservice.dao;

import java.util.List;

import com.mthree.studentregistrationwebservice.Student;

public interface IDAO {
	public List<Student> findAll();
	public Student save(Student user);
}
