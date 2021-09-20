package com.app.entity.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name="user_address_tbl")
public class Address {
	
	@Id
	private Long id ;
	
	@Column(length = 20, nullable = false)
	private String city;
	@Column(length = 20, nullable =  false)
	private String state;
	@Column(length = 20, nullable =  false)
	private String flatNo;
	
	public Address() {
		System.out.println("In def constr : "+getClass().getName());
	}

	public Address(String city, String state, String flatNo) {
		super();
		this.city = city;
		this.state = state;
		this.flatNo = flatNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	@Override
	public String toString() {
		return "Address [   city=" + city + ", state=" + state + ", flatNo=" + flatNo + "]";
	}
	
	
	
}