package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.modal.Doctor;
import com.app.service.DoctorServiceIntf;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DoctorServiceIntf doctorService;
	
	public AdminController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@PostMapping
	public ResponseEntity<?> saveDoctor(@RequestBody @Valid Doctor doctor) {
		System.out.println("in save doctor : "+ doctor);
		return new ResponseEntity<>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Doctor> getAllDoctorDetails(){
		System.out.println("in get all doctors detail ");
		return doctorService.getAllDoctors();
	}
	
	@DeleteMapping("remove/{doctor_id}")
	public String deleteDoctor(@PathVariable Long doctor_id) {
		System.out.println("in delete doctor : "+doctor_id);
		return doctorService.deleteDoctorById(doctor_id);
	}
}
