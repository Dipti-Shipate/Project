package com.app.entity.modal;

import static com.app.entity.modal.AppointmentType.CLINIC_VISIT;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="doctor_appointment_tbl")
public class Appointement extends BaseEntity{

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	private LocalDateTime appointmentTime;

	@Enumerated(EnumType.STRING)
	private AppointmentType appointmentType = CLINIC_VISIT;

	@Column(length=30, nullable = false)
	private String ailment;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="doctor_id", nullable =  false)
	//@JsonIgnoreProperties("doctor_appointment")
	//@JsonIgnore
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="patient_id", nullable =  false)
	//@JsonIgnoreProperties("patient_appointment")
	//@JsonIgnore
	private Patient patient;
	
	public Appointement() {
		System.out.println("In def constr : "+getClass().getName());
	}

	public Appointement(LocalDateTime appointmentTime, AppointmentType appointmentType, String ailment,
			Doctor doctor) {
		super();
		this.appointmentTime = appointmentTime;
		this.appointmentType = appointmentType;
		this.ailment = ailment;
		this.doctor = doctor;
	}


	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

	public String getAilment() {
		return ailment;
	}

	public void setAilment(String ailment) {
		this.ailment = ailment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointement [appointmentTime=" + appointmentTime + ", appointmentType="
				+ appointmentType + ", ailment=" + ailment + "]";
	}
	
	
	
}
