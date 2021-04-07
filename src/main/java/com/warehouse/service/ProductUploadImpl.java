/**
 * 
 */
package com.warehouse.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse.model.InventryVo;
import com.warehouse.model.ProductsVo;
import com.warehouse.repository.InventryRepository;
import com.warehouse.repository.ProductRepository;

/**
 * Service to upload the Product/Article information.
 * 
 * @author AVSIN3
 *
 */
@Service
public class ProductUploadImpl implements ProductUploadService {

	private static final String CLASS_NAME = "com.warehouse.service.ProductUploadImpl";
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

	@Autowired
	private ProductRepository pRepository;

	@Autowired
	private InventryRepository iRepository;

	public ProductUploadImpl() {
		
	}
	public ProductUploadImpl(ProductRepository repository, InventryRepository invenRepository) {

		this.pRepository = repository;
		this.iRepository = invenRepository;
	}

	/**
	 * This service will be called from the file uploader application. This will be
	 * used to write the logic for converting the JSON file data to the value
	 * object. Once we have Object, using the repository, we will upload the
	 * Articles data in database.
	 * 
	 * @Assume - This application has to maintain a separate list of failure upload so not throwing the 
	 * exception back to the caller service.
	 */
	@Override
	public void loadArticles() {

		LOGGER.info("Article upload in progress...");
		ObjectMapper objectMapper = new ObjectMapper();

		List<InventryVo> inventryList = null;

		// JSON file to Java object
		try {
			// TODO - below file location needs to be change with some network drive. It can be read from the PUB/SUB topic.			
			inventryList = objectMapper.readValue(new URL("c:\\product\\Article.json"),
					new TypeReference<List<InventryVo>>() {
					});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ValidateArtilcesData(inventryList);
		// Step 3 - Update the repository
		//iRepository.saveAll(inventryList);
	}

	/**
	 * This service will be called from the file uploader application. This will be
	 * used to write the logic for converting the JSON file data to the value
	 * object. Once we have Object, using the repository, we will upload the product
	 * data in database.
	 * 
	 * @Assume - This application has to maintain a separate list of failure upload so not throwing the 
	 * exception back to the caller service.
	 */
	@Override
	public void loadProducts() {

		LOGGER.info("Producct upload in progress...");
		ObjectMapper objectMapper = new ObjectMapper();
		List<ProductsVo> prodList = null;
		try {
			// Step1 - JSON URL to Java object
			// TODO - below file location needs to be change with some network drive
			prodList = objectMapper.readValue(new URL("c:\\product\\Product.json"),
					new TypeReference<List<ProductsVo>>() {
					});

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TODO Step 2 - Validate the JSON object
		ValidateProductsData(prodList);
		
		// Step 3 - Update the repository
		//pRepository.saveAll(prodList);
	}

	/**
	 *  Part of project extensibility
	 * @param inventryObj
	 */
	private void ValidateArtilcesData(List<InventryVo> inventryObj) {
		LOGGER.info("Article validation in progress...");
		// TODO Step 2 - Validate the JSON object

	}

	/**
	 *  Part of project extensibility
	 * @param inventryObj
	 */
	private void ValidateProductsData(List<ProductsVo> prodList) {
		LOGGER.info("Product validation in progress...");
		// TODO Step 2 - Validate the JSON object

	}

}
