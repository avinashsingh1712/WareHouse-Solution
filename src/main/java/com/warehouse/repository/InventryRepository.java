package com.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.model.InventryVo;

@Repository
public interface InventryRepository extends JpaRepository<InventryVo, String>{

	
	
}
