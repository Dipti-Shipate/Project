package com.app.entity.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="consultation_fees_tbl")
public class ConsultationFees extends BaseEntity{
	private Integer onlineFee;
	private Integer clinicFee;
	private Integer homeVisitFee;
	
	public ConsultationFees() {
		System.out.println("In def constr : "+getClass().getName());
	}

	public ConsultationFees(Integer onlineFee, Integer clinicFee, Integer homeVisitFee) {
		super();
		this.onlineFee = onlineFee;
		this.clinicFee = clinicFee;
		this.homeVisitFee = homeVisitFee;
	}


	public Integer getOnlineFee() {
		return onlineFee;
	}

	public void setOnlineFee(Integer onlineFee) {
		this.onlineFee = onlineFee;
	}

	public Integer getClinicFee() {
		return clinicFee;
	}

	public void setClinicFee(Integer clinicFee) {
		this.clinicFee = clinicFee;
	}

	public Integer getHomeVisitFee() {
		return homeVisitFee;
	}

	public void setHomeVisitFee(Integer homeVisitFee) {
		this.homeVisitFee = homeVisitFee;
	}

	@Override
	public String toString() {
		return "ConsultationFees [id=" + getId() + ", onlineFee=" + onlineFee + ", clinicFee=" + clinicFee
				+ ", homeVisitFee=" + homeVisitFee + "]";
	}

}
