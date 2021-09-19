package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.modal.Doctor;
import com.app.repository.DoctorRepository;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorServiceIntf{

	@Autowired
	DoctorRepository doctorRepo;
	
	@Override
	public List<String> getSpecializationsByCity(String city){
		return doctorRepo.getSpecializationsByCity(city);	//get all unique specialization list of doctors
	}

	@Override
	public List<Doctor> getAllDoctorsBySpecializationAndCity(String specialization, String city) {
		
		return doctorRepo.findDoctorsBySpecializationAndCity(specialization, city);
	}


	
	
}
