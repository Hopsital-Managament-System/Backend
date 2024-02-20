package com.app.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "laboratory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Laboratory extends BaseEntity {

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "amount")
    private double amount;

    @OneToOne
    @JoinColumn(name = "appointment_id", unique = true)
    private Appointment appointment;
}


//package com.app.entities;
//
//import java.time.LocalDate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Table(name="laboratory")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//
//public class Laboratory extends BaseEntity {
//
//	
//	
//	@Column(length = 200)
//	private String testName;
//	
//
//	@Column(name="test_bill")
//	private double amount;
//	
//	
//	
//	
////	@Column(name="test_type",length=200)
////	private String testType;   // Example: "Blood Test", "X-Ray", "Urinalysis", etc
////	
////	@Column(name="lab_result",length=500)
////	private String results;
////	
////	@Column(name="date")
////	private LocalDate date;
////	
////	@ManyToOne
////	@JoinColumn(name="patient_id")
////	private Patient patient;
////	
////	@ManyToOne
////	@JoinColumn(name="doctor_id")
////	private Doctor doctor;
////	
////	@ManyToOne
////	@JoinColumn(name="labtech_id")
////	private LabTech labtech;
//	
////	@OneToOne
////	@JoinColumn(name="appoitnment_id")
////	private Appointment appointment;
////	
////	
////	private boolean paymentStatus;
////	
//}
