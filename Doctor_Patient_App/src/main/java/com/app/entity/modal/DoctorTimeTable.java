package com.app.entity.modal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Table(name = "doctor_timetable_tbl")
public class DoctorTimeTable extends BaseEntity {
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime startTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime endTime;

	@Max(value = 6)
	@Min(value = 0)
	private int weekDays;

	@Max(value = 30)
	@Min(value = 15)
	private int slotDuration; // 30 mins

	private LocalDateTime breakTime;// duration 30 min

	private int breakDuration = 30;

	@ElementCollection
	private List<LocalDateTime> availableSlots = new ArrayList<>();

	public DoctorTimeTable() {
		System.out.println("In def constr : " + getClass().getName());
	}

	public DoctorTimeTable(String id, LocalDateTime startTime, LocalDateTime endTime, int weekDays, int slotDuration,
			List<LocalDateTime> availableSlots) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekDays = weekDays;
		this.slotDuration = slotDuration;
		this.availableSlots = availableSlots;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(int weekDays) {
		this.weekDays = weekDays;
	}

	public int getSlotDuration() {
		return slotDuration;
	}

	public void setSlotDuration(int slotDuration) {
		this.slotDuration = slotDuration;
	}

	public List<LocalDateTime> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(List<LocalDateTime> availableSlots) {
		this.availableSlots = availableSlots;
	}

	@Override
	public String toString() {
		return "DoctorTimeTable [startTime=" + startTime + ", endTime=" + endTime + ", weekDays=" + weekDays
				+ ", slotDuration=" + slotDuration + ", availableSlots=" + availableSlots + "]";
	}

	// doctor supplied values for advance bookings
	void openSlots(int noOfDays) {
		int totalMinutes = (int) ChronoUnit.MINUTES.between(startTime, endTime);
		int slots = totalMinutes / slotDuration;

		// ---------------------------------
//				MAKE SURE TO SKIP SATURDAY / SUNDAY IN BOOKINGS
//				HINT: COMPARE CURRENT DAY WITH WEEK DAY AND PROCEED
		// ---------------------------------

		// @ start of shift both are same
		int remainingMinutes = totalMinutes;
		if (remainingMinutes >= slotDuration) {
			availableSlots.add(startTime);
		}

		for (int i = 1; i <= slots; i++) {
			remainingMinutes -= slotDuration;
			if (remainingMinutes >= slotDuration) {
				availableSlots.add(startTime.plusMinutes(i * slotDuration));
			}
		}
	}

}
