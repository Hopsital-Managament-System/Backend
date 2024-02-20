package com.app.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Validated
public class PatientDto {

	@JsonProperty(value="patientId",access = Access.READ_ONLY)
	private Long id;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String patientName;
	
	@NotNull
	@NotBlank(message = "Password is required")
	private String password;

	@NotBlank(message = "Contact number is required")
    @Size(max = 15, message = "Contact number must be at most 15 characters")
	private String patientContactNo;
	
	@NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be a positive number")
	private int patientAge;
	
	@NotBlank(message = "Patient address is required")
	@Size(max = 400, message = "Patient address must be at most 400 characters")
	private String patientAddress;
	
	
	private String patientBloodGroup;	
	
	@NotNull
	private String patientGender;
	
	@Size(max = 500, message = "Medical history must be at most 500 characters")
	private String medicalHistory;
	
	
}
