package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentDao;
import com.app.dao.DoctorDao;
import com.app.dao.LaboratoryDao;
import com.app.dao.PatientDao;
import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;
import com.app.entities.Doctor;
import com.app.entities.Laboratory;
import com.app.entities.Patient;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao aptDao;
	
	@Autowired
	private DoctorDao docDao;
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private LaboratoryDao labDao;
	
	@Autowired
	private ModelMapper mapper;

//	@Override
//	public String addAppoinment(Long patientId, Long doctorId, Long labId, AppointmentDto apt) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public String addAppoinment(Long patientId, Long doctorId, Long labId, AppointmentDto apt) {
//		Patient patient=patientDao.findById(patientId).orElseThrow();
//		Doctor doctor=docDao.findById(doctorId).orElseThrow();
//		Laboratory lab=labDao.findById(labId).orElseThrow();
//		Appointment newApt = new Appointment(doctor,patient,lab,mapper.map(apt, Appointment.class ));
//		System.out.println("full apt"+newApt);
//		aptDao.save(newApt);
//		return "successfulyy";
//	
//	}

	
	@Override
	public String addAppoinment(Long patientId, Long doctorId, AppointmentDto apt) {

			Patient patient=patientDao.findById(patientId).orElseThrow();
			Doctor doctor = docDao.findById(doctorId).orElseThrow();
			System.out.println("apt dto "+ apt);
			
	Appointment newApt = new Appointment(doctor,patient,mapper.map(apt, Appointment.class));
	System.out.println("full apt"+newApt);
	aptDao.save(newApt);
	return "successfulyy";
	}
	
	
	// Method to update laboratory details for a specific appointment
    public void updateLaboratoryDetailsForAppointment(Long appointmentId, String laboratoryName, double amount)
    {
        Appointment appointment = aptDao.findById(appointmentId)
                .orElseThrow();

        Laboratory laboratory = appointment.getLaboratory();
        if (laboratory == null) {
            laboratory = new Laboratory();
            laboratory.setAppointment(appointment);
        }

        laboratory.setName(laboratoryName);
        laboratory.setAmount(amount);

        labDao.save(laboratory);
    }


	@Override
	public List<Appointment> getAllappointServ() {
	
		return null;
	}
	
	
	
	
	
	
}
