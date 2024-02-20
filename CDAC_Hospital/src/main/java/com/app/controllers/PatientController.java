package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PatientDto;
import com.app.entities.Patient;
import com.app.service.PatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

	@Autowired
	private PatientService patientServ;
	
	@PostMapping
	public Patient addPatient(@RequestBody Patient patient)
	{
		return patientServ.addPatientServ(patient);
	}
	
	@GetMapping
	public List<Patient> displayPatient()
	{
		return patientServ.displayAllPatient();
	}
	
	@PutMapping("status/patientId/{patientId}")
	public  void UpdateStatusOfPatient(@PathVariable Long patientId)
	{
      patientServ.updateStatusOfPatient(patientId);		
	}
	
	
	@PutMapping("patientId/{patientId}")
	public void UpdatePatient(@PathVariable Long patientId,@RequestBody PatientDto detachedPatient)
	{
		
		patientServ.updatePatient(detachedPatient,patientId);
		
	}
	
	
	@GetMapping("/{patientId}")
	public Patient getPatientById(@PathVariable Long patientId)
	{
		return patientServ.getPatientById(patientId);
	}
	
	
	
	
	
}
