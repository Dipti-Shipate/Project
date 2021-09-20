package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.DoctorServiceIntf;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorServiceIntf doctorService;
	
	public DoctorController() {
		System.out.println("in constr of "+getClass().getName());		
	}
	
	@GetMapping("specialization/{city}")
	public ResponseEntity<?>getSpecializationByCity(@PathVariable String city){
		System.out.println("in get doctor's specializations ");
		return new ResponseEntity<>(doctorService.getSpecializationsByCity(city), HttpStatus.FOUND);
	}
	
	@GetMapping("search/{specialization}/{city}")
	public ResponseEntity<?>getDoctorsBySpecializationAndCity(@PathVariable String specialization,@PathVariable String city){
		System.out.println("in get doctor's specializations ");
		return new ResponseEntity<>(doctorService.getSpecializationsByCity(city), HttpStatus.FOUND);
	}
}