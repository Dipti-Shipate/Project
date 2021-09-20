package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{

	@Autowired
	private EntityManager entityManager;

	@Override
	public String addEmployee(Employee emp,int id) {
		Department selectedDept=entityManager.find(Department.class, id);
		entityManager.persist(emp);
		selectedDept.addEmployee(emp);
		return "Employee Added Successfully!!";
	}

}
