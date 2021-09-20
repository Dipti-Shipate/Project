package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.modal.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	@Query("SELECT DISTINCT  d.specialization FROM Doctor d where d.address.city=?1")
	List<String> getSpecializationsByCity(String city );

	@Query("SELECT d from Doctor d where d.specialization=?1 and d.address.city=?2")
	List<Doctor> findDoctorsBySpecializationAndCity(String specialization ,String city);
}
