package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in ctor of "+getClass().getName());
	}

	@GetMapping("/employee/addEmployee")
	public String showAddEmployee(Employee employee) 
	{
		System.out.println("In showAddEmployee "+employee);
		return "/employee/addEmployee";
	}
	@PostMapping("/employee/addEmployee")
	public String processAddEmployee(Employee employee,Model map,@RequestParam String deptid) 
	{
		System.out.println("In processAddEmployee"+employee+deptid);
		String message=empService.addEmployee(employee, Integer.parseInt(deptid));
		System.out.println(message);
		if(message.equals("Employee Added Successfully!!"))
		{
			return "redirect:/dept/departments";
		}
		else 
		{
			
			map.addAttribute("message",message);
			return "/employee/addEmployee";
		}

		
	}
}
