package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Patient extends User {

	@Column(name="patient_name",length = 100)
	private String patientName;
	
	@Column(name="patient_contact",length = 15)
	private String patientContactNo;
	
	@Column(name="patient_age")
	private int patientAge;
	
	@Column(name="patient_address",length = 400)
	private String patientAddress;
	
	@Column(name="patient_bloodgroup",length = 10)
	private String patientBloodGroup;	
	
	
	@Column(length=10)
	private String patientGender;
	
	@Column(name="medical_history",length=500)
	private String medicalHistory;
	
	
}
