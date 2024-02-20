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
@Table(name = "LabTech")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class LabTech extends User{

	@Column(name="labtech_name")
	private String LName;
	
	@Column(name="contact_no")
	private String LContactNo;
	
	
	
	
}
