package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;

public interface AppointmentService {

	String addAppoinment(Long patientId, Long doctorId, AppointmentDto apt);

//	String addAppoinment(Long patientId, Long doctorId,Long labId, AppointmentDto apt);
    public void updateLaboratoryDetailsForAppointment(Long appointmentId, String laboratoryName, 
    		double amount);

	List<Appointment> getAllappointServ();
}
