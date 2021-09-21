package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dto.LoginResponse;
import com.app.entity.modal.Doctor;
import com.app.entity.modal.DoctorTimeTable;
import com.app.entity.modal.Gender;
import com.app.entity.modal.Patient;
import com.app.repository.DoctorRepository;
import com.app.repository.PatientRepository;
import com.app.service.AppointmentServiceImpl;
import com.app.service.AppointmentServiceIntf;
import com.app.service.DoctorServiceIntf;
import com.app.service.PatientServiceIntf;

@SpringBootTest
class DaoTest {
	
	@Autowired 
	private PatientRepository patientRepo;

	@Autowired 
	private DoctorRepository doctorRepo;
	
	@Autowired
	private DoctorServiceIntf doctorService;
	
	@Autowired
	private AppointmentServiceIntf appointmentService;

	@Test
	void savePatient() {
		
		 Patient p = new Patient("ak123", "Ak", "Ak", "ak@gmail.com", "ak@123", LocalDate.parse("1998-10-12"), Gender.valueOf("MALE"), "12345");
		 patientRepo.save(p);
		 assertTrue(true);
	}
	
	@Test
	void TestGetSpecialization() {
		
		 doctorRepo.getSpecializationsByCity("Mumbai").forEach(e->System.out.println(e));
		 assertTrue(true);
	}
	
	@Test
	void TestGetDoctorListBySpecialization() {
		
		 doctorRepo.findDoctorsBySpecializationAndCity("Dentist","Mumbai").forEach(e->System.out.println(e));
		 assertTrue(true);
	}
	
	@Test
	void TestTimeTableTimeSlots() {
		DoctorTimeTable timeTable = new DoctorTimeTable(LocalTime.parse("08:00:00"),
				LocalTime.parse("14:00:00"), 6, 30,LocalTime.parse("10:00:00"),30);
		timeTable.openSlots(6);
		 assertTrue(true);
	}

	
	@Test
	void saveDoctor() {
		 Doctor p = new Doctor(null, "Hindi", "covid", "BAMS", LocalDate.parse("2000-08-08"), true, "e1", "e1", "e1", "e1@gmail.com", "e1@123", LocalDate.parse("1997-07-07"), Gender.MALE, "9809876756");
		doctorRepo.save(p);
		 assertTrue(true);
	}
	
	@Test
	void getAllDoctorDetail() {
		List<Doctor> allDoctors = doctorService.getAllDoctors();
		allDoctors.forEach(System.out::println);
	}

	@Test
	void deleteDoctorTest() {
		System.out.println(doctorService.deleteDoctorById(6l));
		List<Doctor> allDoctors = doctorService.getAllDoctors();
		allDoctors.forEach(System.out::println);
	}

	@Test
	void authenticateDoctorTest() {
		LoginResponse rs = doctorService.authenticateDoctor("a1@gmail.com", "a1@123");
		System.out.println(rs.getUserFirstName());
	}
	
	@Test
	void saveDoctorTimeTable() {
		
		DoctorTimeTable tt = new DoctorTimeTable(LocalTime.parse("07:00:00"), LocalTime.parse("14:00:00"), 6, 30, LocalTime.parse("12:00:00"), 30);
		DoctorTimeTable g = appointmentService.generateTimeTableForDoctor(tt, 2l);
		System.out.println(g);
		System.out.println(g.getAvailableSlots());
		 assertTrue(true);
	}
	
	
	
}
