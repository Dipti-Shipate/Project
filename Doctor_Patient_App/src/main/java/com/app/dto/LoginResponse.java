package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class LoginResponse {
	private Long patientId;
	private String patientFirstName;
	
	public LoginResponse() {
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(Long patientId, String patientFirstName) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	@Override
	public String toString() {
		return "LoginResponse [patientId=" + patientId + ", patientFirstName=" + patientFirstName + "]";
	}
	
	
	
}
