/**
 * 
 */
package com.warehouse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author AVSIN3
 *
 */
@Entity(name = "ItemListVo")
@Table(name = "ITEM_LIST")
public class ItemListVo {
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
	private long prod_id;

	@Column(name = "art_id", nullable = false)
	private String art_id;

	@Column(name = "price", nullable = false)
	private String price;
	
	@ManyToOne
	private ProductsVo prodVo;

	/**
	 * @return the prod_id
	 */
	public long getProd_id() {
		return prod_id;
	}

	/**
	 * @param prod_id the prod_id to set
	 */
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
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
