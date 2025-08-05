package com.amit.FoodCatalogueservice.DTO;

import java.util.List;

import com.amit.FoodCatalogueservice.entity.FoodItem;

public class FoodCateloguePage {
	
	private List<FoodItem> foodItems;
	private Restaurant restaurant;
	
	
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public FoodCateloguePage(List<FoodItem> foodItems, Restaurant restaurant) {
		super();
		this.foodItems = foodItems;
		this.restaurant = restaurant;
	}
	public FoodCateloguePage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FoodCateloguePage [foodItems=" + foodItems + ", restaurant=" + restaurant + "]";
	}
	
	

}
