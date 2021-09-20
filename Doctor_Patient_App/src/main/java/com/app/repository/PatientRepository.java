package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.modal.Appointment;
import com.app.entity.modal.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	//authenticate patient
	Optional<Patient> findByEmailAndPassword(String email, String password);

}
