package com.app.service;

import java.util.List;

import com.app.entity.modal.Doctor;

public interface DoctorServiceIntf {
	List<String> getSpecializationsByCity(String city);
	
	List<Doctor> getAllDoctorsBySpecializationAndCity(String specialization,String city);	
	
}
