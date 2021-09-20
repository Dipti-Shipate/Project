package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Employee extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length = 20, unique = true)
	private String email;
	private double salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private LocalDate joiningDate=LocalDate.now();
	@ManyToOne
	@JoinColumn(name = "deptid") 
	private Department selectedDepartment;
	
	public Employee() {
		System.out.println("In def constr of "+getClass().getName());
	}

	public Employee(String name, String email, double salary, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Department getSelectedDepartment() {
		return selectedDepartment;
	}

	public void setSelectedDepartment(Department selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", salary=" + salary + ", dob=" + dob + ", joiningDate="
				+ joiningDate + "]";
	}

	

}
