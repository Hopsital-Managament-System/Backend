package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Laboratory;

public interface LaboratoryDao extends JpaRepository<Laboratory, Long> {

}
