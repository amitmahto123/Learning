package com.amit.FoodCatalogueservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.FoodCatalogueservice.DTO.FoodCateloguePage;
import com.amit.FoodCatalogueservice.DTO.FoodItemDTO;
import com.amit.FoodCatalogueservice.entity.FoodItem;
import com.amit.FoodCatalogueservice.service.FoodItemService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodItemController {
	
	
	private FoodItemService foodItemService;
	
	
	
	public FoodItemController(FoodItemService foodItemService) {
		super();
		this.foodItemService = foodItemService;
	}

	@PostMapping("/saveFoodItem")
	public ResponseEntity<FoodItemDTO> saveFoodItem(FoodItemDTO foodItemDTO)
	{
		FoodItemDTO saveFoodItem = foodItemService.saveFoodItem(foodItemDTO);
		return new ResponseEntity<>(saveFoodItem, HttpStatus.CREATED);
	
	}

	@GetMapping("/getAllFoodItems")
	public ResponseEntity<List<FoodItemDTO>> getAllFoodItems(){
		
	List<FoodItemDTO> allFoodItems = foodItemService.getAllFoodItems();
	return new ResponseEntity<>(allFoodItems, HttpStatus.OK);
	
	}
	
	@GetMapping("fetchRestaurantAndFoodDetails/{id}")
	public ResponseEntity<FoodCateloguePage> getFoodCateloguePageUsingRestClient(@PathVariable Integer id)
	{
		FoodCateloguePage fetchFoodCateloguePageDetails = foodItemService.fetchFoodCateloguePageDetails(id);
		return new ResponseEntity<FoodCateloguePage>(fetchFoodCateloguePageDetails, HttpStatus.OK);
	}
}
	
	
