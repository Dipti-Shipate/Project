package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.modal.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	@Query("SELECT a FROM Appointment a WHERE a.patient.id = ?1 AND a.appointmentTime > now()")
	List<Appointment> getAllPatientCurrentAppoitments(Long patientId);
	
	@Query("SELECT a FROM Appointment a WHERE a.patient.id = ?1 AND a.appointmentTime < now() ORDER BY appointmentTime DESC LIMIT 5")
	List<Appointment> getAllPatientAppoitmentsHistory(Long patientId);

	@Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1 AND a.appointmentTime > now()")
	List<Appointment> getAllCurrentAppoitmentsForDoctor(Long doctorId);
	
	@Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1 AND a.patient.id = ?2 AND a.appointmentTime < now() ORDER BY appointmentTime DESC LIMIT 5")
	List<Appointment> getPatientAppoitmentsHistoryForDoctor(Long doctorId, Long patientId);
	
	@Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1 AND a.appointmentTime < now() ORDER BY appointmentTime DESC LIMIT 5")
	List<Appointment> getAllAppoitmentsHistoryForDoctor(Long doctorId);

}
