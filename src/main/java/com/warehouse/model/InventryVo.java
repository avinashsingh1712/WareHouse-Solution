/**
 * 
 */
package com.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author AVSIN3
 *
 */
@Entity(name = "InventryVo")
@Table(name = "Inventry")
public class InventryVo {

	@Id
	@Column(name = "art_id", nullable = false)
	private String art_id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;


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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InventryVo [art_id=" + art_id + ", name=" + name + ", quantity=" + quantity + ", getArt_id()="
				+ getArt_id() + ", getName()=" + getName() + ", getQuantity()=" + getQuantity() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
