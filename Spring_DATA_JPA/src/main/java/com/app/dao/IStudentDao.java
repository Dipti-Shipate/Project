package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Student;

public interface IStudentDao extends JpaRepository<Student, Integer>{

}
