package com.amit.FoodCatalogueservice.ModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amit.FoodCatalogueservice.DTO.FoodItemDTO;
import com.amit.FoodCatalogueservice.entity.FoodItem;

@Component
public class FoodItemModelMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public FoodItem mapFoodItemDTOtoFoodItem(FoodItemDTO foodItemDTO)
	{
		return this.modelMapper.map(foodItemDTO, FoodItem.class);
	}
	
	public FoodItemDTO mapFoodItemtoFoodItemDTO(FoodItem foodItem) {
		return this.modelMapper.map(foodItem, FoodItemDTO.class);
		
	}

}
