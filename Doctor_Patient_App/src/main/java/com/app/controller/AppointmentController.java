package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.modal.Appointment;
import com.app.entity.modal.DoctorTimeTable;
import com.app.service.AppointmentServiceIntf;
import com.app.service.DoctorServiceIntf;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentServiceIntf appointmentService;
	
	@Autowired
	DoctorServiceIntf doctorService;
	

	public AppointmentController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
//	@GetMapping("/specialization")//after clicking on physician/dentist block
//	ResponseEntity<?> getAllDoctorsBySpecialization(@PathVariable String specialization){
//		return null ;
//	}
	
	@GetMapping("specialization/{city}")
	public ResponseEntity<?>getSpecializationByCity(@PathVariable String city){
		System.out.println("in get doctor's specializations ");
		return new ResponseEntity<>(doctorService.getSpecializationsByCity(city), HttpStatus.FOUND);
	}
	
	@GetMapping("search/{specialization}/{city}")
	public ResponseEntity<?>getDoctorsBySpecializationAndCity(@PathVariable String specialization,@PathVariable String city){
		System.out.println("in get doctor's specializations ");
		return new ResponseEntity<>(doctorService.getSpecializationsByCity(city), HttpStatus.FOUND);
	}
	
	@PostMapping("createTimeTable/{doctor_id}")
	public ResponseEntity<?> createDoctorTimeTable(@RequestBody  DoctorTimeTable timeTable, @PathVariable Long doctor_id) {
		System.out.println("in create doctor's time table  : "+timeTable+" : "+doctor_id);
		return new ResponseEntity<>(appointmentService.generateTimeTableForDoctor(timeTable, doctor_id),HttpStatus.CREATED);
	}


	@GetMapping("currAppointmentP/{patient_id}")
	public List<Appointment> getAllCurrentAppoinments(@PathVariable Long patient_id){
		System.out.println("in get all appointments of patient "+patient_id);
		return appointmentService.getAllPatientCurrentAppoitments(patient_id);
	}

	@GetMapping("appointementHistoryP/{patient_id}")
	public List<Appointment> getAllAppoinmentsHistory(@PathVariable Long patient_id){
		System.out.println("in get all appointment history "+patient_id);
		return appointmentService.getAllPatientAppoitmentsHistory(patient_id);
	}

	@GetMapping("currAppointmentD/{doctor_id}")
	public List<Appointment> getAllCurrentAppoinmentsForDoctor(@PathVariable Long doctor_id){
		System.out.println("in get all appointments for doctor "+doctor_id);
		return appointmentService.getAllCurrentAppoitmentsForDoctor(doctor_id);
	}

	@GetMapping("appointementHistoryD/{doctor_id}/{patient_id}")
	public List<Appointment> getAppoinmentsHistoryOfPatientForDoctor(@PathVariable Long doctor_id, @PathVariable Long patient_id){
		System.out.println("in get appointment history of patient for doctor "+doctor_id +", "+patient_id);
		return appointmentService.getPatientAppoitmentsHistoryForDoctor(doctor_id, patient_id);
	}

	@GetMapping("appointementHistoryD/{doctor_id}")
	public List<Appointment> getAllAppoinmentsHistoryForDoctor(@PathVariable Long doctor_id){
		System.out.println("in get all appointment history for doctor "+doctor_id);
		return appointmentService.getAllAppoitmentsHistoryForDoctor(doctor_id);
	}
	
}
