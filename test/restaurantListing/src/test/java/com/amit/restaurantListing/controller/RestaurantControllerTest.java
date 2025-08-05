package com.amit.restaurantListing.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.amit.restaurantListing.DTO.RestaurantDTO;
import com.amit.restaurantListing.service.RestaurantService;

import jakarta.persistence.Temporal;

public class RestaurantControllerTest {
	
	@InjectMocks
	RestaurantController restaurantController;
	
	@Mock
	RestaurantService restaurantService;
	
	@BeforeEach
	public void setUP()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testFetchAllRestaurants() {
		
		List<RestaurantDTO> mockRestaurants= Arrays.asList(
				new RestaurantDTO(1,"Restaurant 1","Address 1", "City 1", "Desc"),
				new RestaurantDTO(2,"Restaurant 2","Address 2", "City 2", "Desc2")
				);
		
		when(restaurantService.findAllRestaurant()).thenReturn(mockRestaurants);
		
		 ResponseEntity<List<RestaurantDTO>> response = restaurantController.fetchAllRestaurants();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockRestaurants, response.getBody());
		
		verify(restaurantService, times(1)).findAllRestaurant();
	}

}
