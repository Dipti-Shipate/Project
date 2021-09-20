package com.app.service;

import java.util.List;

import com.app.dto.LoginResponse;
import com.app.entity.modal.Doctor;
import com.app.entity.modal.Patient;

public interface DoctorServiceIntf {
	//register new doctor
	Doctor saveDoctor(Doctor doctor);
	
	//authenticate doctor
	LoginResponse authenticateDoctor(String email, String password);

	//get list of specializations by city
	List<String> getSpecializationsByCity(String city);
	
	//get list of doctors by specialization and city
	List<Doctor> getAllDoctorsBySpecializationAndCity(String specialization,String city);	
	
	//cancel appointment [implemented in appointment services]
	//String cancelAppointment(Long doctorId, Long appointmentId);
	
	//get list of all doctors
	List<Doctor>getAllDoctors();
	
	//delete doctor by id
	String deleteDoctorById(Long doctorId);

}
