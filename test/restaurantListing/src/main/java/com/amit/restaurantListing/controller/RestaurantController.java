package com.amit.restaurantListing.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.restaurantListing.DTO.RestaurantDTO;
import com.amit.restaurantListing.entity.Restaurant;
import com.amit.restaurantListing.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/fetchAllRestuarants")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants()
	{
		List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurant();
//		return ResponseEntity.ok(allRestaurants); 
		return new ResponseEntity<>(allRestaurants, org.springframework.http.HttpStatus.OK);
		
		
	}
	
//	@GetMapping("/fetchAllRestuarants")
//	public ResponseEntity<List<Restaurant>> fetchAllRestaurants()
//	{
//		List<Restaurant> allRestaurants = restaurantService.findAllRestaurant();
////		return ResponseEntity.ok(allRestaurants); 
//		return new ResponseEntity<>(allRestaurants, org.springframework.http.HttpStatus.OK);
//		
		
	//}
	
	@PostMapping("/saveRestaurant")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO)
	{
		RestaurantDTO saveRestaurantInDB = restaurantService.saveRestaurantInDB(restaurantDTO);
		return new ResponseEntity<>(saveRestaurantInDB, org.springframework.http.HttpStatus.CREATED);
	}
	
	@GetMapping("/getRestaurantById/{id}")
	public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Integer id)
	{
		RestaurantDTO restaurantById = restaurantService.getRestaurantById(id);
		return new ResponseEntity<>(restaurantById, org.springframework.http.HttpStatus.OK);
	}
	
}

