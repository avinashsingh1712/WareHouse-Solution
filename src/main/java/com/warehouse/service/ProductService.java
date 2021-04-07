/**
 * 
 */
package com.warehouse.service;

import java.util.List;

import com.warehouse.Exception.ProductNotFoundException;
import com.warehouse.model.InventryVo;
import com.warehouse.model.ProductsVo;

/**
 * @author AVSIN3
 *
 */
public interface ProductService {

	public List<ProductsVo> getAllProducts();

	public Boolean isProductAvailable(Long id) throws ProductNotFoundException;

	public ProductsVo updateProductStatus(Long id) throws ProductNotFoundException;
	
	public List<InventryVo> getAllArticle();

}
