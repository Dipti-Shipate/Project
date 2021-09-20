package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.modal.Appointment;
import com.app.repository.AppointmentRepository;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentServiceIntf {

	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Override
	public String cancelAppointment(Long userId, Long appointmentId) {
		// DELETE FROM Appointment a where a.patient.id = ?1 and a.id = ?2
		return null;
	}

	@Override
	public List<Appointment> getAllPatientCurrentAppoitments(Long patientId) {
		return appointmentRepo.getAllPatientCurrentAppoitments(patientId);
	}

	@Override
	public List<Appointment> getAllPatientAppoitmentsHistory(Long patientId) {
		return appointmentRepo.getAllPatientAppoitmentsHistory(patientId);
	}

	@Override
	public List<Appointment> getAllCurrentAppoitmentsForDoctor(Long doctorId) {
		return appointmentRepo.getAllCurrentAppoitmentsForDoctor(doctorId);
	}

	@Override
	public List<Appointment> getPatientAppoitmentsHistoryForDoctor(Long doctorId, Long patientId) {
		return appointmentRepo.getPatientAppoitmentsHistoryForDoctor(doctorId, patientId);
	}

	@Override
	public List<Appointment> getAllAppoitmentsHistoryForDoctor(Long doctorId) {
		return appointmentRepo.getAllAppoitmentsHistoryForDoctor(doctorId);
	}

}
