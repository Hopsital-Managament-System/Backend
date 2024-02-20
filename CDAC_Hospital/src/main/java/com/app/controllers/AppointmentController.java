package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appoinment")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class AppointmentController {

	@Autowired
	private AppointmentService aptService;

	
	@GetMapping("/lab")
	public List<Appointment> getAllAppointment(){
		return aptService.getAllappointServ();
	}
	
//	@PostMapping()
//	public String doAppoinment(@RequestParam Long patientId, @RequestParam Long doctorId,
//		@RequestParam Long labId,@RequestBody @Valid AppointmentDto aptDto) {
//		System.out.println(aptDto);
//		return aptService.addAppoinment(patientId, doctorId, labId, aptDto);
//
//	}

	@PostMapping()
	public String doAppoinment(@RequestParam Long patientId, @RequestParam Long doctorId,
			@RequestBody @Valid AppointmentDto aptDto) {
		System.out.println(aptDto);
		return aptService.addAppoinment(patientId, doctorId, aptDto);

	}

	
	
//	@PutMapping("/{appointmentId}/laboratory")
//    public ResponseEntity<String> updateLaboratoryDetailsForAppointment(
//            @PathVariable("appointmentId") Long appointmentId,
//            @RequestParam("laboratoryName") String laboratoryName,
//            @RequestParam("amount") double amount) throws Exception {
//
//        try {
//        	aptService.updateLaboratoryDetailsForAppointment(appointmentId, laboratoryName, amount);
//            return ResponseEntity.ok("Laboratory details updated successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
	
	@PutMapping("/{appointmentId}/laboratory")
	public String updateLaboratoryDetailsForAppointment(
	        @PathVariable("appointmentId") Long appointmentId,
	        @RequestParam("laboratoryName") String laboratoryName,
	        @RequestParam("amount") double amount) {
	    
	    aptService.updateLaboratoryDetailsForAppointment(appointmentId, laboratoryName, amount);
	    
	    return "Laboratory details updated successfully.";
	}

    }
	
	


//	@GetMapping
//	public List<Appointment> getAllAppointment(){
//		return aptService.getAllappointServ();
//	}
//
//
//	@PutMapping("/{id}")
//	public void updateAppointmentStatus(@PathVariable Long id) {
//		
//		aptService.updateAppointmentStatusServ(id);
//	}
//	
//	@GetMapping("/{patientId}")
//	public List<Appointment> getAllAppointmentBypatientId(@PathVariable Long patientId){
//		return aptService.getAllAppointmentBypatientId(patientId);
//		
//
//	}

