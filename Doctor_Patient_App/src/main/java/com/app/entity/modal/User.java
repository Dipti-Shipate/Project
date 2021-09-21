package com.app.entity.modal;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class User extends BaseEntity{
	@Column(length = 30, unique = true)
	@NotBlank(message="User name must be supplied")
	private String username;
	
	@Column(length = 30)
	@NotBlank(message="User first name must be supplied")
	private String firstName;
	
	@Column(length = 30)
	@NotBlank(message="User last name must be supplied")
	private String lastName;
	
	@Column(length = 30, unique = true)
	@NotBlank(message="User email must be supplied")
	private String email;
	
	@Column(length = 30, nullable = false)
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password")
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(length = 255, nullable = false)
	@NotBlank(message="User password required")	
	private String mobileNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
//  	Upload on Server side or Cloud
//	@Lob
//	private Byte[] image;
//	private String imageType;
//	private String doctorId;
//	private String patientId;
	
	
	public User() {
		System.out.println("In def constr : "+getClass().getName());
	}

public User(@NotBlank(message = "User name must be supplied") String username,
		@NotBlank(message = "User first name must be supplied") String firstName,
		@NotBlank(message = "User last name must be supplied") String lastName,
		@NotBlank(message = "User email must be supplied") String email,
		@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid password") String password,
		LocalDate dob, Gender gender, @NotBlank(message = "User password required") String mobileNumber) {
	super();
	this.username = username;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.dob = dob;
	this.gender = gender;
	this.mobileNumber = mobileNumber;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public Gender getGender() {
	return gender;
}

public void setGender(Gender gender) {
	this.gender = gender;
}

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}
	
@Override
public String toString() {
	return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", mobileNumber=" + mobileNumber + "]";
}

	
}