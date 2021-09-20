package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.modal.Appointement;

public interface AppointmentRepository extends JpaRepository<Appointement, Long>{

}
