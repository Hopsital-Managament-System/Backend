package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DoctorDao;
import com.app.dto.DoctorDto;
import com.app.entities.Doctor;
import com.app.entities.DoctorSchedule;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao docDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Doctor addDoctorServ(Doctor doctor) {
		List <DoctorSchedule> listd=doctor.getDSchedule();
		doctor.addDschedule(listd);
		return docDao.save(doctor);
	}

	@Override
	public List<Doctor> getAllDocsServ() {
		return docDao.getAllDoc();
	}

	@Override
	public void updateStatus(Long docId) {
		Doctor doc=docDao.findById(docId).orElseThrow();
		doc.setStatus(false);
		docDao.save(doc);
	}

	@Override
	public void updateDoctor(DoctorDto detachedDoctor, Long docId) {
		Doctor doctor=docDao.findById(docId).orElseThrow();
		mapper.map(detachedDoctor, doctor);
		
	}

	@Override
	public Doctor getDoctorById(Long doctorId) {
		return docDao.findById(doctorId).orElseThrow();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
