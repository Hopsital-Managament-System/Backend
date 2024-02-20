package com.app.service;

import java.util.List;

import com.app.dto.DoctorDto;
import com.app.entities.Doctor;

public interface DoctorService {

	Doctor addDoctorServ(Doctor doctor);
	
	List<Doctor> getAllDocsServ();
	
	void updateStatus(Long docId);
	
	void updateDoctor(DoctorDto detachedDoctor, Long docId);
	
	Doctor getDoctorById(Long doctorId);
}
