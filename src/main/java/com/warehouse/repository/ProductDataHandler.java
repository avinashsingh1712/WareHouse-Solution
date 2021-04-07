package com.warehouse.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.warehouse.model.InventryVo;
import com.warehouse.model.ItemListVo;
import com.warehouse.model.ProductsVo;

@Service
public class ProductDataHandler {

	public ProductDataHandler() {

	}

	/**
	 * 
	 * @return
	 */
	public List<ProductsVo> manageProductData1() {

		List<ProductsVo> products = new ArrayList<>();
		ProductsVo vo = new ProductsVo();

		List<ItemListVo> itemList = new ArrayList<ItemListVo>();
		ItemListVo itemVO = new ItemListVo();

		itemVO.setId(101L);
		itemVO.setArt_id("100001");
		itemVO.setPrice("99.99");
		itemVO.setProdVo(vo);

		ItemListVo itemVO1 = new ItemListVo();
		itemVO1.setId(103L);
		itemVO1.setArt_id("100003");
		itemVO1.setPrice("75.09");
		itemVO1.setProdVo(vo);

		ItemListVo itemVO2 = new ItemListVo();
		itemVO2.setId(102L);
		itemVO2.setArt_id("100002");
		itemVO2.setPrice("9.19");
		itemVO2.setProdVo(vo);

		itemList.add(itemVO);
		itemList.add(itemVO1);
		itemList.add(itemVO2);

		ProductsVo vo2 = new ProductsVo();
		vo2.setId(5001L);
		vo2.setProd_name("Dining Chair");
		vo2.setBuyable(true);
		vo2.setItemList(itemList);

		vo.setId(5002L);
		vo.setProd_name("Sofa Set");
		vo.setBuyable(true);
		vo.setItemList(itemList);

		products.add(vo);
		products.add(vo2);

		return products;
	}

	/**
	 * 
	 * @return
	 */
	public ProductsVo handleProductData1(Long id) {
		ProductsVo vo2 = new ProductsVo();

		if(id==5001) {
		List<ItemListVo> itemList = new ArrayList<ItemListVo>();
		ItemListVo itemVO = new ItemListVo();

		itemVO.setId(101L);
		itemVO.setArt_id("100001");
		itemVO.setPrice("99.99");
		itemVO.setProdVo(vo2);

		ItemListVo itemVO1 = new ItemListVo();
		itemVO1.setId(103L);
		itemVO1.setArt_id("100003");
		itemVO1.setPrice("75.09");
		itemVO1.setProdVo(vo2);

		ItemListVo itemVO2 = new ItemListVo();
		itemVO2.setId(102L);
		itemVO2.setArt_id("100002");
		itemVO2.setPrice("9.19");
		itemVO2.setProdVo(vo2);

		itemList.add(itemVO);
		itemList.add(itemVO1);
		itemList.add(itemVO2);

		vo2.setId(5001L);
		vo2.setProd_name("Dining Chair");
		vo2.setBuyable(true);
		vo2.setItemList(itemList);
		}else if(id==5002) {
			List<ItemListVo> itemList = new ArrayList<ItemListVo>();
			ItemListVo itemVO = new ItemListVo();

			itemVO.setId(101L);
			itemVO.setArt_id("100001");
			itemVO.setPrice("99.99");
			itemVO.setProdVo(vo2);

			ItemListVo itemVO1 = new ItemListVo();
			itemVO1.setId(103L);
			itemVO1.setArt_id("100003");
			itemVO1.setPrice("75.09");
			itemVO1.setProdVo(vo2);

			ItemListVo itemVO2 = new ItemListVo();
			itemVO2.setId(102L);
			itemVO2.setArt_id("100002");
			itemVO2.setPrice("9.19");
			itemVO2.setProdVo(vo2);

			itemList.add(itemVO);
			itemList.add(itemVO1);
			itemList.add(itemVO2);

			vo2.setId(5002L);
			vo2.setProd_name("Dining Chair");
			vo2.setBuyable(true);
			vo2.setItemList(itemList);
		} else {
			vo2 = null;
		}
		return vo2;
	}

	/**
	 * 
	 * @return
	 */
//	public InventryVo handleInventryData1(String artilceId) {
////		InventryVo inventryVo = new InventryVo();
////		inventryVo.setArt_id("100001");
////		inventryVo.setName("table top");
////		inventryVo.setQuantity(1);
//		
//		return inventryVo;
//	}

}
