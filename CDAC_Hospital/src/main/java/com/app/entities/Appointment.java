package com.app.entities;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="appointment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude ="patient")
public class Appointment extends BaseEntity {

	@Column(name="name",length = 200)
	private String name;
	
	@Column
	private int age;
	
	@Column(length = 20,name = "contact_no")
	private String contactNo;
	
	@Column(name="relation",length = 100)
	private String relation;
	
	@Column(name="payment_amt")
	private double paymentAmount;
	
	@Column(name="payment_status",nullable = false)
	private Boolean paymentStatus=false;
	
	@Column(name="appointment_status",nullable = false)
	private Boolean aptStatus=true;
	
	@ManyToOne
	@JoinColumn(name="patient_id",nullable = false)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id",nullable=false)
	private Doctor doctor;
	
	@OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JoinColumn(name="lab_id")
    private Laboratory laboratory;
	
	private Timestamp timestamp;
	
	public void addAppoitnment(Patient patient,Doctor doctor)
	{
		this.setPatient(patient);
		this.setDoctor(doctor);
		//this.setLaboratory(lab);
		
	}
	
	public void removeAppoitment(Patient patient,Doctor doctor)
	{
		this.setPatient(null);
		this.setDoctor(null);
	//	this.setLaboratory(null);
	}
	

	public Appointment(Doctor doctor2, Patient patient2, Appointment apt) {
		
		this.setPatient(patient2);
		this.setDoctor(doctor2);
	//	this.setLaboratory(lab2);
		this.setAge(apt.getAge());
		this.setContactNo(apt.getContactNo());
		this.setName(apt.getName());
		this.setRelation(apt.getRelation());
		this.setPaymentStatus(true);
		
		long currentSeconds=Instant.now().getEpochSecond();
		this.timestamp=new Timestamp(currentSeconds*1000);
	
	}
	
	public Appointment(String name, int age, String contactNo, String relation, double paymentAmount,
			Boolean paymentStatus, Boolean aptStatus, Patient patient, Doctor doctor) {
		super();
		this.name = name;
		this.age = age;
		this.contactNo = contactNo;
		this.relation = relation;
		this.paymentAmount = paymentAmount;
		this.paymentStatus = paymentStatus;
		this.aptStatus = aptStatus;
		this.patient = patient;
		this.doctor = doctor;
		//this.laboratory=lab;
		
		long currentSeconds=Instant.now().getEpochSecond();
		this.timestamp=new Timestamp(currentSeconds*1000);
		
		
	}
}
