package com.app.service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custome_exception.UserHandlingException;
import com.app.entity.modal.Appointment;
import com.app.entity.modal.Doctor;
import com.app.entity.modal.DoctorTimeTable;
import com.app.repository.AppointmentRepository;
import com.app.repository.DoctorRepository;
import com.app.repository.DoctorTimeTableRepository;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentServiceIntf {

	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Autowired
	DoctorTimeTableRepository doctorTimeTableRepo;
	
	@Autowired
	DoctorRepository doctorRepo;
	
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

	@Override
	public DoctorTimeTable generateTimeTableForDoctor(DoctorTimeTable timeTable, Long doctor_id) {
		DoctorTimeTable dTimeTable = doctorTimeTableRepo.save(timeTable);
		dTimeTable.openSlots(6);
		Doctor doctor = doctorRepo.findById(doctor_id).orElseThrow(() -> new UserHandlingException("Doctor not found"));
		doctor.setTimeSlot(dTimeTable);
		return dTimeTable;
	}
}
