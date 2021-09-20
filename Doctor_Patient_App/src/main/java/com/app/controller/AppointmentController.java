package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/appointment")
public class AppointmentController {
	public AppointmentController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@GetMapping("/specialization")//after clicking on physician/dentist block
	ResponseEntity<?> getAllDoctorsBySpecialization(@PathVariable String specialization){
		return null ;
	}
	
}
