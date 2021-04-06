/**
 * 
 */
package com.warehouse.service;

import java.util.List;
import java.util.Map;

import com.warehouse.Exception.ProductNotFoundException;
import com.warehouse.model.ProductsVo;

/**
 * @author AVSIN3
 *
 */
public interface ProductService {

	public List<ProductsVo> getAllProducts();

	public Boolean isProductAvailable(Long id) throws ProductNotFoundException;

	public Map<String, Boolean> removeProduct(Long id) throws ProductNotFoundException;

}
