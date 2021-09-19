package com.app.entity.modal;

public enum AppointmentType {
    CLINIC_VISIT, HOME_VISIT, ONLINE_CONSULT;

    @Override
    public String toString() {
    	return name();
    }

}
