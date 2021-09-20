package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequest;
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
	
	@PostMapping("/login")
	public /* @ResponseBody */ ResponseEntity<?> authenticateDoctor(@RequestBody LoginRequest request) {
		System.out.println("in auth doctor " + request);
		return new ResponseEntity<>(doctorService.authenticateDoctor(request.getEmail(), request.getPassword()), HttpStatus.ACCEPTED);
	}
	
}