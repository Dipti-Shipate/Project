package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.DoctorServiceIntf;
import com.app.service.PatientServiceIntf;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private DoctorServiceIntf doctorService;
	@Autowired
	private PatientServiceIntf patientService;
	
	public HomeController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	
}
