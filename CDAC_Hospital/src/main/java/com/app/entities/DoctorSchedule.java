package com.app.entities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="doc_schedule")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DoctorSchedule extends BaseEntity {

	 	@Enumerated(EnumType.STRING)
	    @Column(name = "day_of_week", nullable = false)
	 	private DayOfWeek dayOfWeek;

	 	@Column(name = "start_time", nullable = false)
	    @DateTimeFormat(pattern = "HH:mm:ss")
	    private LocalTime startTime;

	    @Column(name = "end_time", nullable = false)
	    @DateTimeFormat(pattern = "HH:mm:ss")
	    private LocalTime endTime;

}
