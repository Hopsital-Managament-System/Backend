package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LaboratoryDao;
import com.app.entities.Laboratory;

@Service
@Transactional
public class LaboratoryServiceImpl implements LaboratoryService {

	@Autowired
	private LaboratoryDao labDao;

	@Override
	public Laboratory addLab(Laboratory lab) {
		return labDao.save(lab);
	}

	@Override
	public List<Laboratory> getAllLab() {
		return labDao.findAll();
	}
	
	
	
}
