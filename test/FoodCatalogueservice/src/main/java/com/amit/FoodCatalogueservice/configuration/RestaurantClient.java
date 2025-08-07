package com.amit.FoodCatalogueservice.configuration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.amit.FoodCatalogueservice.DTO.Restaurant;




@FeignClient(name="Restaurant-Client", url="${application.services.restaurants.url}")
public interface RestaurantClient {
	

	@GetMapping("/fetchAllRestuarants")
	 List<Restaurant> fetchAllRestaurants();
	
	
	@PostMapping("/saveRestaurant")
	 Restaurant saveRestaurant(@RequestBody Restaurant restaurantDTO);
	
	
	@GetMapping("/getRestaurantById/{id}")
	 Restaurant getRestaurantById(@PathVariable Integer id);
	
	




}
