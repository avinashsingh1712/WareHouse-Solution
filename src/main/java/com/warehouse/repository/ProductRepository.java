package com.warehouse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.model.ProductsVo;

@Repository
public interface ProductRepository extends CrudRepository<ProductsVo, Long>{

}
