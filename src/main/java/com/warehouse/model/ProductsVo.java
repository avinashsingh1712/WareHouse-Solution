/**
 * 
 */
package com.warehouse.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author AVSIN3
 *
 */
@Entity(name = "ProductsVo")
@Table(name = "PRODUCTS")
public class ProductsVo implements Serializable{

	private static final long serialVersionUID = 5142116142556439160L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "prod_name", nullable = false)
	private String prod_name;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "prod_id", referencedColumnName = "id")
	private List<ItemListVo> itemList;
	
	@Column(name = "isBuyable", nullable = false)
	private boolean isBuyable = true;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the prod_name
	 */
	public String getProd_name() {
		return prod_name;
	}

	/**
	 * @param prod_name the prod_name to set
	 */
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	/**
	 * @return the itemList
	 */
	public List<ItemListVo> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<ItemListVo> itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return the isBuyable
	 */
	public boolean isBuyable() {
		return isBuyable;
	}

	/**
	 * @param isBuyable the isBuyable to set
	 */
	public void setBuyable(boolean isBuyable) {
		this.isBuyable = isBuyable;
	}
	



}
