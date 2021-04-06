package com.warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.model.InventryVo;

@Repository
public interface InventryRepository extends CrudRepository<InventryVo, String>{

}
