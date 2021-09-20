package com.app.service;

import com.app.dto.LoginResponse;
import com.app.entity.modal.Patient;

public interface PatientServiceIntf {
	
	//register new patient
	Patient savePatient(Patient user);
	
	//authenticate patient
	LoginResponse authenticatePatient(String email, String password);
	
	//cancel appointment [implemented in appointment services]
	//String cancelAppointment(Long patientId, Long appointmentId);
	
	
	
}
