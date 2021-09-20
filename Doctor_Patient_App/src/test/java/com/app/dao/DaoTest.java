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

import com.app.entity.modal.DoctorTimeTable;
import com.app.entity.modal.Gender;
import com.app.entity.modal.Patient;
import com.app.repository.DoctorRepository;
import com.app.repository.PatientRepository;
import com.app.service.PatientServiceIntf;

@SpringBootTest
class DaoTest {
	
	@Autowired 
	private PatientRepository patientRepo;

	@Autowired 
	private DoctorRepository doctorRepo;

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

	
	
	
}
