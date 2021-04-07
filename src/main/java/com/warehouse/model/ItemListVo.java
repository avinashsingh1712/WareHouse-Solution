/**
 * 
 */
package com.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author AVSIN3
 *
 */
@Entity(name = "ItemListVo")
@Table(name = "ITEM_LIST")
public class ItemListVo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "art_id", nullable = false)
	private String art_id;

	@Column(name = "price", nullable = false)
	private String price;
	
	@ManyToOne
	@JsonBackReference
	private ProductsVo prodVo;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the art_id
	 */
	public String getArt_id() {
		return art_id;
	}

	/**
	 * @param art_id the art_id to set
	 */
	public void setArt_id(String art_id) {
		this.art_id = art_id;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the prodVo
	 */
	public ProductsVo getProdVo() {
		return prodVo;
	}

	/**
	 * @param prodVo the prodVo to set
	 */
	public void setProdVo(ProductsVo prodVo) {
		this.prodVo = prodVo;
	}

}
