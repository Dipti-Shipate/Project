package com.app.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IStudentDao;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentDao.deleteById(id);
	}

	@Override
	public void updateStudent(Integer id,int studentage) {
		// TODO Auto-generated method stub
		Student temp=studentDao.getOne(id);
		temp.setAge(studentage);
		
	}
	
	
}
