/**
 * 
 */
package com.warehouse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.Exception.ProductNotFoundException;
import com.warehouse.model.InventryVo;
import com.warehouse.model.ItemListVo;
import com.warehouse.model.ProductsVo;
import com.warehouse.repository.InventryRepository;
import com.warehouse.repository.ProductRepository;

/**
 * Sample service to demonstrate what the API would use to get things done in
 * order to fetch/update the Product information.
 * 
 * @author AVSIN3
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private static final String CLASS_NAME = "com.warehouse.service.ProductServiceImpl";
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

	@Autowired
	private ProductRepository pRepository;

	@Autowired
	private InventryRepository iRepository;

	public ProductServiceImpl(ProductRepository prodRepository, InventryRepository invenRepository) {

		this.pRepository = prodRepository;
		this.iRepository = invenRepository;
	}

	/**
	 * This will be called when customer will land on the market page to display all
	 * the available products.
	 * 
	 * @return List of products
	 */
	@Override
	public List<ProductsVo> getAllProducts() {

		List<ProductsVo> products = new ArrayList<>();
		products = (List<ProductsVo>) pRepository.findAll();

		products.forEach(products::add);

		LOGGER.info("Fetching Product Object. List Size ::" + products.size()+ " Class :"+CLASS_NAME);
		return products;
	}

	/**
	 * This will be called immediately before the Order checkout to check the
	 * product and articles availability.
	 * 
	 * @exception : ResourceNotFoundException
	 * @return Boolean flag
	 */
	@Override
	public Boolean isProductAvailable(Long id) throws ProductNotFoundException {
		
		LOGGER.info("Checking product availability for id ::" + id);
		
		// Step 1 - Check the product availability and if its not available, through the exception back as product not available.
		ProductsVo vo = findProductByProductId(id);

		// Step 2 - Check the artiles availability.
		return articleAvailabilityCheck(vo);
	}

	/**
	 * This method will be called for to mark the product as buyable or non-buyable
	 * when product is sold-out and also reduce the count from the inventory.
	 * 
	 * @exception : ResourceNotFoundException
	 * @return Map<String, Boolean> : Object of Map
	 */
	@Override
	public Map<String, Boolean> removeProduct(Long id) throws ProductNotFoundException {

		// Step 1 - Get the product and there associated Articles.
		ProductsVo prodVO = findProductByProductId(id);

		// Step2 - Reduce the count of the articles from inventory.
		inventryCountUpdate(prodVO);

		// Step 3 - Check the articles availability.
		boolean isAvailable = articleAvailabilityCheck(prodVO);

		// Step 4 - making product as non buyable if any of the article's quantity
		// become zero. If quantity > 0, no change needed.
		if (!isAvailable) {
			prodVO.setBuyable(false);
			pRepository.save(prodVO);
		}

		Map<String, Boolean> response = new HashMap<>();
		response.put("buyable", prodVO.isBuyable());

		LOGGER.info("Product has been updated and is buyable: " + prodVO.isBuyable());
		return response;
	}

	/**
	 * This method will find the Product from the product id.
	 * 
	 * @param id
	 * @return ProductsVo
	 * @throws ProductNotFoundException
	 */
	private ProductsVo findProductByProductId(Long id) throws ProductNotFoundException {
		
		LOGGER.info("Fetching the Product data for product id: " + id);
		
		return pRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found :: " + id));
	}

	/**
	 * Check if Article available.
	 * 
	 * @param prodVO : Object of {@link ProductsVo}
	 */
	private boolean articleAvailabilityCheck(ProductsVo prodVO) throws ProductNotFoundException {

		List<ItemListVo> prodItemList = prodVO.getItemList();

		boolean isAvailable = true;

		for (ItemListVo item : prodItemList) {

			String itemId = item.getArt_id();

			InventryVo inventryVO = findArticleCount(itemId);

			int itemQuantity = inventryVO.getQuantity();

			if (itemQuantity == 0) {

				isAvailable = false;
				break;
			}
		}

		return isAvailable;

	}

	/**
	 * This method will update the Articles count.
	 * 
	 * @param prodVO : ProductsVo
	 * @throws ProductNotFoundException : Exception
	 */
	private void inventryCountUpdate(ProductsVo prodVO) throws ProductNotFoundException {

		List<ItemListVo> prodItemList = prodVO.getItemList();

		for (ItemListVo prodItem : prodItemList) {

			String prodArticleId = prodItem.getArt_id();

			InventryVo inventryVo = findArticleCount(prodArticleId);

			// Assume, customer is buying the product having each article count 1.
			inventryVo.setQuantity(inventryVo.getQuantity() - 1);
		}
	}

	/**
	 * This will be used for to get the inventory.
	 * 
	 * @param artilceId
	 * @return InventryVo
	 * @throws ProductNotFoundException : Exception
	 */
	private InventryVo findArticleCount(String articleId) throws ProductNotFoundException {

		LOGGER.info("Fetching the Article details for Article id: " + articleId);

		InventryVo inventryVO = iRepository.findById(articleId)
				.orElseThrow(() -> new ProductNotFoundException("Article not found :: " + articleId));

		return inventryVO;
	}

}
