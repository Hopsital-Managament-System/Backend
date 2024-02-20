package com.app.service;

import java.util.List;

import com.app.entities.Laboratory;

public interface LaboratoryService {

	Laboratory addLab(Laboratory lab);
	
	List<Laboratory> getAllLab();
}
