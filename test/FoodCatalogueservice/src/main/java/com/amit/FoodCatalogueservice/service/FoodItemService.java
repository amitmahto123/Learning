package com.amit.FoodCatalogueservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amit.FoodCatalogueservice.DTO.FoodCateloguePage;
import com.amit.FoodCatalogueservice.DTO.FoodItemDTO;
import com.amit.FoodCatalogueservice.DTO.Restaurant;
import com.amit.FoodCatalogueservice.ModelMapper.FoodItemModelMapper;
import com.amit.FoodCatalogueservice.configuration.RestaurantClient;
import com.amit.FoodCatalogueservice.entity.FoodItem;
import com.amit.FoodCatalogueservice.repository.FoodItemRepo;

@Service
public class FoodItemService {
	
	@Autowired
	RestaurantClient restaurantClient;
	
	private FoodItemRepo foodItemRepo;
	private FoodItemModelMapper foodItemModelMapper;
	private RestTemplate restTemplate;

	public FoodItemService(FoodItemRepo foodItemRepo,RestTemplate restTemplate, FoodItemModelMapper foodItemModelMapper) {
		super();
		this.foodItemRepo = foodItemRepo;
		this.foodItemModelMapper=foodItemModelMapper;
		this.restTemplate=restTemplate;
	}
	
	
	public FoodItemDTO saveFoodItem(FoodItemDTO foodItemDTO)
	{
		FoodItem savedFoodItem = foodItemRepo.save(foodItemModelMapper.mapFoodItemDTOtoFoodItem(foodItemDTO));
		 
		return foodItemModelMapper.mapFoodItemtoFoodItemDTO(savedFoodItem);
		  
		
	}

	public List<FoodItemDTO> getAllFoodItems()
	{
		List<FoodItem> AllFoodItem = foodItemRepo.findAll();
		List<FoodItemDTO> listAllFoodItemDTO = AllFoodItem.stream()
				.map(foodItemModelMapper::mapFoodItemtoFoodItemDTO)
				.toList();		
		 return listAllFoodItemDTO;
	}
	
	private List<FoodItem> fetchFoodItemsByDtosRestaurantId(Integer restaurantId){
		return foodItemRepo.findByRestaurantId(restaurantId);
	}
	
//	private Restaurant fetchRestaurantByRestaurantIdUsingRestTemplate(Integer restaurantId)
//	{
//		Restaurant restaurant = restTemplate.getForObject("http://RESTAURANTLISTING/restaurant/getRestaurantById/"+restaurantId, Restaurant.class);
//		return restaurant;
//	}
	
	private Restaurant fetchRestaurantByRestaurantIdUsingFeignClient(Integer restaurantId)
	{
		Restaurant restaurant = restaurantClient.getRestaurantById(restaurantId);
		return restaurant;
	}
	
	private FoodCateloguePage createFoodCateloguePage(List<FoodItem> foodItemslist, Restaurant restaurant) {
		
		FoodCateloguePage foodCateloguePage= new FoodCateloguePage();
		foodCateloguePage.setFoodItems(foodItemslist);
		foodCateloguePage.setRestaurant(restaurant);
		return foodCateloguePage;
	}
	
	public FoodCateloguePage fetchFoodCateloguePageDetails(Integer restaurantId) {
		Restaurant fetchRestaurantByRestaurantId = fetchRestaurantByRestaurantIdUsingFeignClient(restaurantId);
		List<FoodItem> fetchFoodItemsByDtosRestaurantId = fetchFoodItemsByDtosRestaurantId(restaurantId);
		 FoodCateloguePage foodCateloguePage = createFoodCateloguePage(fetchFoodItemsByDtosRestaurantId, fetchRestaurantByRestaurantId);
		 return foodCateloguePage;
	}
}
