package com.app.service;

import java.util.List;

import com.app.dto.PatientDto;
import com.app.entities.Patient;

public interface PatientService {

	Patient addPatientServ(Patient patient);
	
	List<Patient> displayAllPatient();
	
	void updateStatusOfPatient(Long patientId);
	
	void updatePatient(PatientDto detachedPatient ,Long patientId);
	
	Patient getPatientById(Long patientId);
}
