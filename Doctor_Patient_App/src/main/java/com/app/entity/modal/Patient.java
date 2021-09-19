package com.app.entity.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient_tbl")
public class Patient extends User{
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "doctor_id") // to specify name of the FK column
//	private Doctor selectedDoctor;
//	
//	
//	@OneToMany(mappedBy = "selectedPatient", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Doctor> doctors = new ArrayList<>();
	
	public Patient() {
		System.out.println("int patient constr "+getClass().getName());
	}
	
	public Patient(@NotBlank(message = "User name must be supplied") String username,@NotBlank(message = "User first name must be supplied") String firstName,
			@NotBlank(message = "User last name must be supplied") String lastName,
			@NotBlank(message = "User email must be supplied") String email,
			@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password") String password,
			LocalDate dob, Gender gender, @NotBlank(message = "User password required") String mobileNumber) {
		super(username,firstName,lastName,email,password,dob,gender,mobileNumber);
	}
	
}
