package com.mthree.studentregistrationwebservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.studentregistrationwebservice.Student;

@Repository(value="studentjparepos")
public interface StudentJPARepository extends IDAO, JpaRepository<Student, Integer> {

}
