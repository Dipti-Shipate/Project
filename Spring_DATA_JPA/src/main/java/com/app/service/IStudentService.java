package com.app.service;

import java.util.Optional;

import com.app.pojos.Student;

public interface IStudentService {

	 Student createStudent(Student student);
	 Optional<Student> getStudent(Integer id);
	    void deleteStudent(Integer id);
	    void updateStudent(Integer id,int studentage);
}
