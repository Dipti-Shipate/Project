package com.app.entity.modal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
	@DateTimeFormat(pattern = "hh:mm:ss")
	private LocalTime startTime;

	@DateTimeFormat(pattern = "hh:mm:ss")
	private LocalTime endTime;

	@Max(value = 6)
	@Min(value = 0)
	private int weekDays;

	@Max(value = 30)
	@Min(value = 15)
	private int slotDuration; // 30 mins

	private LocalTime breakTime;// duration 30 min

	private int breakDuration = 30;

	@ElementCollection
	private List<LocalTime> availableSlots = new ArrayList<>();

	

	

	public DoctorTimeTable(LocalTime startTime, LocalTime endTime, @Max(6) @Min(0) int weekDays,
			@Max(30) @Min(15) int slotDuration, LocalTime breakTime, int breakDuration) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekDays = weekDays;
		this.slotDuration = slotDuration;
		this.breakTime = breakTime;
		this.breakDuration = breakDuration;
	}



	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
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

	public List<LocalTime> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(List<LocalTime> availableSlots) {
		this.availableSlots = availableSlots;
	}

	@Override
	public String toString() {
		return "DoctorTimeTable [startTime=" + startTime + ", endTime=" + endTime + ", weekDays=" + weekDays
				+ ", slotDuration=" + slotDuration + ", availableSlots=" + availableSlots + "]";
	}

	// doctor supplied values for advance bookings
	public void openSlots(int noOfDays) {
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
		
		availableSlots.forEach(e->System.out.println(e));
	}

}
