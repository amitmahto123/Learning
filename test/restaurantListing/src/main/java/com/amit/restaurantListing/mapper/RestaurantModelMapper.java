package com.amit.restaurantListing.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amit.restaurantListing.DTO.RestaurantDTO;
import com.amit.restaurantListing.entity.Restaurant;

@Component
public class RestaurantModelMapper {
	
	@Autowired
	public ModelMapper modelMapper;
	
	public Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO) {
		 Restaurant restaurant= this.modelMapper.map(restaurantDTO, Restaurant.class);
		 return restaurant;
		
		
	}
	
	
	public RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant)
	{
     return this.modelMapper.map(restaurant, RestaurantDTO.class);
	}
		
	
	

}
