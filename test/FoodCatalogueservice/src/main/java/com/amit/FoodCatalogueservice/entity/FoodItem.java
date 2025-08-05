package com.amit.FoodCatalogueservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String itemName;
	private String itemDescription;
	private Boolean isveg;
	private Integer price;
	private Integer restaurantId;
	
	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Boolean getIsveg() {
		return isveg;
	}

	public void setIsveg(Boolean isveg) {
		this.isveg = isveg;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", isveg="
				+ isveg + ", price=" + price + ", restaurantId=" + restaurantId + ", quantity=" + quantity + "]";
	}

	public FoodItem(Integer id, String itemName, String itemDescription, Boolean isveg, Integer price,
			Integer restaurantId, Integer quantity) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.isveg = isveg;
		this.price = price;
		this.restaurantId = restaurantId;
		this.quantity = quantity;
	}

	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	
}
