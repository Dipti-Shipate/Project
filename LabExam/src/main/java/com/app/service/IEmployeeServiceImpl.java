package com.app.service;

import java.time.LocalDate;
import java.time.Period;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IEmployeeDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class IEmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeDao empdao;


	@Override
	public String addEmployee(Employee emp, int deptid) {
		// TODO Auto-generated method stub
		Period period=Period.between(emp.getDob(), LocalDate.now());
		int age=period.getYears();
		if(emp.getSalary()<30000 || emp.getSalary()>40000)
		{
			return "Salary must be in range of 30k to 40k";
		}
		else if(age<25 || age>35)
			{
			return "Age must be between 25 and 35";
			}
		else
		{
		return empdao.addEmployee(emp, deptid);
		}
	}
	
	
}
