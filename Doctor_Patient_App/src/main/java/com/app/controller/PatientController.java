package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequest;
import com.app.entity.modal.Patient;
import com.app.service.PatientServiceIntf;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {
	
	@Autowired
	PatientServiceIntf patientService;

	public PatientController() {
		
		System.out.println("In Constructor : "+getClass().getName());
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody @Valid Patient patient) {
		
		System.out.println("In class : "+getClass().getName());
		System.out.println("User : "+patient);
		return new ResponseEntity<>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public /* @ResponseBody */ ResponseEntity<?> authenticatePatient(@RequestBody LoginRequest request) {
		System.out.println("in auth patient " + request);
		return ResponseEntity.ok(patientService.authenticatePatient(request.getEmail(), request.getPassword()));
	}
	
}
