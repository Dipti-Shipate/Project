package com.app.entity.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="doctor_tbl")
public class Doctor extends User{
	@Lob										//Represented as BLOB in database
	private Byte[] certificate;
	
	@Column(length = 30)
	@NotBlank(message="Language must be supplied")
	private String languages;
	// hi, en
	// hi, en, ru
	// [doctorDetails.setLanguages(doctorDetails.getLanguages() + ", ru")]
	
	@Column(length = 30)
	@NotBlank(message="specialization must be supplied")
	private String specialization;
	
	@Column(length = 30)
	@NotBlank(message="qualification must be supplied")	
	private String qualification;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate began_practice;
	
	private Boolean isAvailable;

//	@OneToMany(mappedBy = "selectedDoctor", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Patient> patients = new ArrayList<>();
//	
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "patient_id") // to specify name of the FK column
//	private Patient selectedPatient;

	//schedule
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private ConsultationFees fees;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private DoctorTimeTable timeSlot;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Appointment> appointement = new ArrayList<>();
	
	
	public Doctor() {
		System.out.println("In def constr : "+getClass().getName());
	}


	public Doctor(Byte[] certificate, String languages, String specialization, String qualification,
			LocalDate began_practice, Boolean isAvailable,
			@NotBlank(message = "User name must be supplied") String username,@NotBlank(message = "User first name must be supplied") String firstName,
			@NotBlank(message = "User last name must be supplied") String lastName,
			@NotBlank(message = "User email must be supplied") String email,
			@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password") String password,
			LocalDate dob, Gender gender, @NotBlank(message = "User password required") String mobileNumber) {
		super(username,firstName,lastName,email,password,dob,gender,mobileNumber);

		this.certificate = certificate;
		this.languages = languages;
		this.specialization = specialization;
		this.qualification = qualification;
		this.began_practice = began_practice;
		this.isAvailable = isAvailable;
	}



	public Byte[] getCertificate() {
		return certificate;
	}


	public void setCertificate(Byte[] certificate) {
		this.certificate = certificate;
	}


	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public LocalDate getBegan_practice() {
		return began_practice;
	}


	public void setBegan_practice(LocalDate began_practice) {
		this.began_practice = began_practice;
	}


	public Boolean getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	/*public List<Patient> getPatients() {
		return patients;
	}


	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}*/


//	public Patient getSelectedPatient() {
//		return selectedPatient;
//	}
//
//
//	public void setSelectedPatient(Patient selectedPatient) {
//		this.selectedPatient = selectedPatient;
//	}


	public ConsultationFees getFees() {
		return fees;
	}


	public void setFees(ConsultationFees fees) {
		this.fees = fees;
	}


	public DoctorTimeTable getTimeSlot() {
		return timeSlot;
	}


	public void setTimeSlot(DoctorTimeTable timeSlot) {
		this.timeSlot = timeSlot;
	}


	public List<Appointment> getAppointement() {
		return appointement;
	}


	public void setAppointement(List<Appointment> appointement) {
		this.appointement = appointement;
	}


	@Override
	public String toString() {
		return "Doctor ["+super.toString()+"certificate=" + Arrays.toString(certificate) + ", languages=" + languages + ", specialization="
				+ specialization + ", qualification=" + qualification + ", began_practice=" + began_practice
				+ ", isAvailable=" + isAvailable + "]";
	}
	
}
