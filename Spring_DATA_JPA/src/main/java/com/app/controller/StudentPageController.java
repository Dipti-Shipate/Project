package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Student;
import com.app.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentPageController {

	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/createStudent")
	public String getCreateStudentPage(Student student)
	{
		return "/student/createStudent";
	}
	
	@PostMapping("/createStudent")
	public String processCreateStudentPage(Student student,Model map)
	{
		System.out.println(student);
		studentService.createStudent(student);
		System.out.println(studentService);
		map.addAttribute("message","Student record created with ID : "
				+student.getId());
		return "/student/createStudent";
	}
	
	@GetMapping("/getStudentDetails")
	public String getStudentDetailsPage()
	{
		System.out.println("In getStudentDetails");
		return "/student/getStudentDetails";
	}
	
	@PostMapping("/getStudentDetails")
	public String processGetStudentDetails(@RequestParam String studentid,Model map)
	{
		System.out.println("In processGetStudentDetails");
		map.addAttribute("studentDetailsById",studentService.getStudent(Integer.parseInt(studentid)));
		return "/student/getStudentDetails";
	}
	
	@GetMapping("/deleteStudent")
	public String getDeleteStudentPage()
	{
		return "/student/deleteStudent";
	}
	
	@PostMapping("/deleteStudent")
	public String processDeleteStudentPage(@RequestParam String studentid,Model map)
	{
		try{
			studentService.deleteStudent(Integer.parseInt(studentid));
			map.addAttribute("message",
					"Deleted student details successfully");
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			map.addAttribute("message", "Invalid Student ID");
		}
		
		return "/student/deleteStudent";
	}
	
	@GetMapping("/updateStudentDetails")
	public String getUpdateStudentPage()
	{
		return "/student/updateStudentDetails";
	}
	
	@PostMapping("/updateStudentDetails")
	public String processUpdateStudentPage(@RequestParam String studentid,@RequestParam String studentage,Model map)
	{
		try {
			studentService.updateStudent(Integer.parseInt(studentid),Integer.parseInt(studentage));
			map.addAttribute("message",
					"Student details updated successfully");
		}
		catch (RuntimeException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			map.addAttribute("message",
					"Invalid Student ID");
		}
		return "/student/updateStudentDetails";
	}
	
}
