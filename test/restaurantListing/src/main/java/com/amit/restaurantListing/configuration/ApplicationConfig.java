package com.amit.restaurantListing.configuration;


import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
//	public static final ModelMapper modelMapper = new ModelMapper();
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
	

}
