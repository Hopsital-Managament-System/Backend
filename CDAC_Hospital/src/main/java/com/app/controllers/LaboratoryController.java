package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Laboratory;
import com.app.service.LaboratoryService;

@RestController
@RequestMapping("/lab")
@CrossOrigin(origins = "http://localhost:3000")
public class LaboratoryController {

	@Autowired
	private LaboratoryService labServ;
	
	@PostMapping
	public Laboratory addLab(Laboratory lab)
	{
		return labServ.addLab(lab);
	}
	
//	@GetMapping
//	public List<Laboratory> listLab()
//	{
//		return labServ.getAllLab();
//	}
	
}
