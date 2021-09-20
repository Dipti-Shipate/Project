package com.app.dto;

public class LoginResponse {
	private Long userId;
	private String userFirstName;
	
	public LoginResponse() {
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(Long userId, String userFirstName) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setPatientFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	@Override
	public String toString() {
		return "LoginResponse [patientId=" + userId + ", patientFirstName=" + userFirstName + "]";
	}
	
	
	
}
