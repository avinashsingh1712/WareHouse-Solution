package com.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.model.ProductsVo;

@Repository
public interface ProductRepository extends  JpaRepository<ProductsVo, Long>{

}
