package com.amit.FoodCatalogueservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FoodItemConfiguration {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();

	}

	@Bean
	@LoadBalanced
	public RestTemplate geRestTemplate() {
		return new RestTemplate();

	}
	
}
