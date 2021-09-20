package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LoginResponse;
import com.app.entity.modal.Patient;
import com.app.entity.modal.User;
import com.app.repository.PatientRepository;

@Service
@Transactional
public class PatientServiceImpl implements PatientServiceIntf {

	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public Patient savePatient(Patient patient) {
//		System.out.println("in service"+patient);
		 return patientRepo.save(patient);
	}

	@Override
	public LoginResponse authenticatePatient(String email, String password) {
		Patient patient = patientRepo.findByEmailAndPassword(email, password) //populated or empty optional
				.orElseThrow(() -> new RuntimeException("Auth Failed"));
		return new LoginResponse(patient.getId(), patient.getFirstName());
	}

}
