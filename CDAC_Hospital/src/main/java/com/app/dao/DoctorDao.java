package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Long> {

	@Query("select d from Doctor d where d.status=true")
	List<Doctor> getAllDoc();
	
}
