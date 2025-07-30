package com.amit.restaurantListing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.amit.restaurantListing.DTO.RestaurantDTO;
import com.amit.restaurantListing.entity.Restaurant;

@Mapper
public interface RestaurantMapper {
	
RestaurantMapper INSTANCE= Mappers.getMapper(RestaurantMapper.class);
	
	Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);
	
	RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
	

}
