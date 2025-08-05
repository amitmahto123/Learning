package com.amit.restaurantListing.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.restaurantListing.DTO.RestaurantDTO;
import com.amit.restaurantListing.entity.Restaurant;
import com.amit.restaurantListing.exception.ProductNotFoundException;
import com.amit.restaurantListing.mapper.RestaurantModelMapper;
import com.amit.restaurantListing.respository.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepo restaurantRepo;
	
	@Autowired
	private RestaurantModelMapper restaurantModelMapper;


	
	public List<RestaurantDTO> findAllRestaurant() {
		List<Restaurant> restaurants=restaurantRepo.findAll();
		List<RestaurantDTO> restaurantslist = restaurants.stream()
				.map(restaurantModelMapper::mapRestaurantToRestaurantDTO)
				.toList();
				
				return restaurantslist;	
	
	}
	
	
		
	
	public RestaurantDTO saveRestaurantInDB(RestaurantDTO restaurantDTO)
	{
		Restaurant savedRestaurant= restaurantRepo.save(restaurantModelMapper.mapRestaurantDTOToRestaurant(restaurantDTO));
		
		return restaurantModelMapper.mapRestaurantToRestaurantDTO(savedRestaurant);
		
	}
	
	public RestaurantDTO getRestaurantById(Integer id) {
		 Optional<Restaurant> restaurantbyId = restaurantRepo.findById(id);
		 if(restaurantbyId.isPresent())
		 {
			 return restaurantModelMapper.mapRestaurantToRestaurantDTO(restaurantbyId.get());
		 }
		 else {
	            throw new ProductNotFoundException("Restaurant not found with Restaurant Id " + id);
	        }
	}

}
