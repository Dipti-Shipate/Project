package com.app.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.app.service.IDeptService;

@Controller
public class DeptController {
	
	@Autowired
	private IDeptService deptService;
	
	@PostConstruct
	public void myinit()
	{
		System.out.println("In DeptController init method");
	}
	
	@GetMapping("/dept/departments")
	public String showDepartments(Model map)
	{
		System.out.println(" In DeptController");
		map.addAttribute("deptlist", deptService.getAllDepartment());
		return "/dept/departments";
	}
	
	@PreDestroy
	public void mydestroy()
	{
		System.out.println("In DeptController destroy method");

	}
}
