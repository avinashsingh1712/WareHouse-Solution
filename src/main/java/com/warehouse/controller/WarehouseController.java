package com.warehouse.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.warehouse.Exception.ProductNotFoundException;
import com.warehouse.model.InventryVo;
import com.warehouse.model.ProductsVo;
import com.warehouse.service.ProductService;

@RestController
@RequestMapping("api/v1/")
public class WarehouseController {

	private static final String CLASS_NAME = "com.warehouse.WarehouseController";
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

	@Autowired
	private ProductService warehouseService;

	public WarehouseController() {

	}
	

	@RequestMapping("/welcome")
	public String test() {

		return "Welcome to the Warehouse solution...";
	}

	/**
	 * This will return all the Articles stored.
	 * 
	 * @return List of product
	 */
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public List<InventryVo> getArticles() {
		LOGGER.info("Fetching Article data.... ");

		List<InventryVo> articles = warehouseService.getAllArticle();

		LOGGER.info("Fetching Inventry data. List Size ::" + articles.size());
		return articles;
	}

	/**
	 * This will return all the products.
	 * 
	 * @return List of product
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public List<ProductsVo> getProductsData() {
		LOGGER.info("Fetching Product data.... ");

		List<ProductsVo> productList = warehouseService.getAllProducts();

		LOGGER.info("Fetching Product data. List Size ::" + productList.size());
		return productList;
	}

	/**
	 * This will check the product availability.
	 * 
	 * @return List of product
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public String productAvailability(@PathVariable Long id) {
		Boolean isAvailable = false;
		try {
			isAvailable = warehouseService.isProductAvailable(id);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		LOGGER.info("Checking product availability:: " + isAvailable);

		return (isAvailable ? "Product is buyable" : "Product is not buyable");
	}

	/**
	 * This will be used for to update the quantity and making the product as
	 * buyable/non-buyable (remove) data.
	 *
	 * @param id the product id
	 * @return the map
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	public ProductsVo updateProductStatus(@PathVariable Long id, @RequestBody ProductsVo prodVo)
			throws ProductNotFoundException {

		ProductsVo pVo = warehouseService.updateProductStatus(id);

		LOGGER.info("Updating the product staus of Product id:: " + id);

		return pVo;
	}

}
