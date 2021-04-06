package com.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.warehouse.service.ProductUploadImpl;

@SpringBootApplication
public class WarehouseApplication {


	@Autowired
	ProductUploadImpl impl;
	
	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

}
