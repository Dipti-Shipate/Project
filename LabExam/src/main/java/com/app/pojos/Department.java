package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
public class Department extends BaseEntity {
	@Column(length = 20,unique = true)
	private String deptname;
	
	@Column(length =20)
	private String location;
	
	private int strength;

	@OneToMany(mappedBy = "selectedDepartment",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Employee> employeeList = new ArrayList<Employee>();

	public Department() {
		super();
		System.out.println("In def constr of "+getClass().getName());
	}

	public Department(String deptname, String location, int strength) {
		super();
		this.deptname = deptname;
		this.location = location;
		this.strength = strength;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [deptname=" + deptname + ", location=" + location + ", strength=" + strength + "]";
	}
	
	public void addEmployee(Employee emp)
	{
		this.employeeList.add(emp);
		emp.setSelectedDepartment(this);
		this.setStrength(employeeList.size());
	}
	
	
	
}
