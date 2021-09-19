package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.modal.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Optional<Patient>findByEmailAndPassword(String email, String password);

}
