package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LoginResponse;
import com.app.entity.modal.Doctor;
import com.app.repository.DoctorRepository;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorServiceIntf{

	@Autowired
	DoctorRepository doctorRepo;
	
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	@Override
	public List<String> getSpecializationsByCity(String city){
		return doctorRepo.getSpecializationsByCity(city);	//get all unique specialization list of doctors
	}

	@Override
	public List<Doctor> getAllDoctorsBySpecializationAndCity(String specialization, String city) {
		
		return doctorRepo.findDoctorsBySpecializationAndCity(specialization, city);
	}

	@Override
	public LoginResponse authenticateDoctor(String email, String password) {
		Doctor doctor = doctorRepo.findByEmailAndPassword(email, password) //populated or empty optional
				.orElseThrow(() -> new RuntimeException("Auth Failed"));
		return new LoginResponse(doctor.getId(), doctor.getFirstName());
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepo.findAll();
	}

	@Override
	public String deleteDoctorById(Long doctorId) {
		doctorRepo.deleteById(doctorId);
		return "Successfully Deleted";
	}
}