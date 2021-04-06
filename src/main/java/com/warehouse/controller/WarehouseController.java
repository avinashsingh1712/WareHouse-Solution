package com.warehouse.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.Exception.ProductNotFoundException;
import com.warehouse.model.ProductsVo;
import com.warehouse.service.ProductService;

@RestController
public class WarehouseController {

	private static final String CLASS_NAME = "com.warehouse.WarehouseController";
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

	@Autowired
	private ProductService warehouseService;

	/**
	 * This will return all the products.
	 * 
	 * @return List of product
	 */
	@GET
	@Path("/products")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public List<ProductsVo> getProductsData() {
		List<ProductsVo> productList = warehouseService.getAllProducts();

		LOGGER.info("Fetching Product data. List Size ::" + productList.size());
		return productList;
	}
	
	/**
	 * This will check the product availability.
	 * 
	 * @return List of product
	 */
	@GET
	@Path("/productsavailability")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Boolean productAvailability(Long id) {
		Boolean isAvailable = false;
		try {
			isAvailable = warehouseService.isProductAvailable(id);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}

		LOGGER.info("Checking product availability");
		return isAvailable;
	}

	/**
	 * This will be used for to update the quantity and making the product as buyable/non-buyable (remove) data.
	 *
	 * @param id the product id
	 * @return the map
	 * @throws Exception the exception
	 */
	@PUT
	@Path("/removeproducts")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Map<String, Boolean> removeProductData(@PathVariable("id") Long id) throws ProductNotFoundException {
			
		Map<String, Boolean> response = warehouseService.removeProduct(id);

		LOGGER.info("Removing the product - Product id:: " + id);
		
		return response;
	}

}
