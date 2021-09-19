package com.app.service;

import com.app.dto.LoginResponse;
import com.app.entity.modal.Patient;

public interface PatientServiceIntf {
	
	Patient savePatient(Patient user);
	
	LoginResponse authenticatePatient(String email, String password);
	
}
