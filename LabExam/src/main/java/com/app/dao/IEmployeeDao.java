package com.app.dao;

import com.app.pojos.Employee;

public interface IEmployeeDao {
	String addEmployee(Employee emp,int deptid);
}
