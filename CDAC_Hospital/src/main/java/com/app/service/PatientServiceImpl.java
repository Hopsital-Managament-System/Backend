package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PatientDao;
import com.app.dto.PatientDto;
import com.app.entities.Patient;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Patient addPatientServ(Patient patient) {
		return patientDao.save(patient);
	}

	@Override
	public List<Patient> displayAllPatient() {
		return patientDao.getAllPatients();
	}

	@Override
	public void updateStatusOfPatient(Long patientId) {
		Patient pat=patientDao.findById(patientId).orElseThrow();
		pat.setStatus(false);
		patientDao.save(pat);
		
	}

	@Override
	public void updatePatient(PatientDto detachedPatient, Long patientId) {
		Patient patient=patientDao.findById(patientId).orElseThrow();
		mapper.map(detachedPatient, patient);
		
	}

	@Override
	public Patient getPatientById(Long patientId) {
		
		return patientDao.findById(patientId).orElseThrow();
	}
	
	
	
	
	
	
	
	
}
