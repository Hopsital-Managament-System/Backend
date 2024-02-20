package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="doctor")
public class Doctor extends User {

	@Column(name = "doctor_name", length = 200)
	private String dName;

	@Column(name = "doctor_contact", length = 100)
	private String dContactNo;

	@Column(name = "doctor_specialisation", length = 400)
	private String dSpecialisation;
	
	@Column(name="doctor_experience")
	private int experience;
	
	@Column(name="doctor_license")
	private String dLicense;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="doctor_schedule")
	private List<DoctorSchedule> dSchedule=new ArrayList<>();
	
	
	public void addDschedule(List<DoctorSchedule> listd)
	{
		this.dSchedule.addAll(listd);
	}
}
