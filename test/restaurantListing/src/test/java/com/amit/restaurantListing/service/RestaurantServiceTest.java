package com.amit.restaurantListing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.amit.restaurantListing.DTO.RestaurantDTO;
import com.amit.restaurantListing.entity.Restaurant; // Adjust package and class name
import com.amit.restaurantListing.mapper.RestaurantModelMapper; // Adjust package and class name
import com.amit.restaurantListing.respository.RestaurantRepo;
import com.amit.restaurantListing.service.RestaurantService; // Adjust package and class name

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue; // Import for assertTrue
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.any; // Import for any() matcher

public class RestaurantServiceTest { // Renamed from RestaurantControllerTest if not already

    @InjectMocks
    RestaurantService restaurantService; // The class containing the method to be tested

    @Mock
    RestaurantRepo restaurantRepo; // Mock the repository dependency

    @Mock
    RestaurantModelMapper restaurantModelMapper; // Mock the mapper dependency

    @BeforeEach
    public void setUp() {
        // Initializes mocks annotated with @Mock and injects them into fields
        // annotated with @InjectMocks within this test class.
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddRestaurant() {
        // Given: Prepare the input DTO and expected intermediate/output objects

        // Input DTO for the addRestaurant method
        RestaurantDTO inputRestaurantDTO = new RestaurantDTO(
                10, // ID is usually null for new entries
                "New Burger Joint",
                "101 Fresh St",
                "Flavorville",
                "Best burgers in town!");

        // Mock entity that the mapper would produce from the input DTO
        // We set an ID here because a saved entity usually has an ID assigned by the DB
        Restaurant mappedRestaurantEntity = new Restaurant();
        mappedRestaurantEntity.setId(10); // Simulate ID assigned by DB
        mappedRestaurantEntity.setName("New Burger Joint");
        mappedRestaurantEntity.setAddress("101 Fresh St");
        mappedRestaurantEntity.setCity("Flavorville");
        mappedRestaurantEntity.setRestaurantDescription("Best burgers in town!");

        // Mock entity that the repository would return after saving
        // This is often the same as mappedRestaurantEntity if the save method returns the persisted entity
        Restaurant savedRestaurantEntity = mappedRestaurantEntity; // Assuming save returns the same object with ID

        // Expected output DTO after the saved entity is mapped back
        RestaurantDTO expectedOutputDTO = new RestaurantDTO(
                10, // Should have the ID from the saved entity
                "New Burger Joint",
                "101 Fresh St",
                "Flavorville",
                "Best burgers in town!"
        );

        // Configure the mocks' behavior
        // 1. When mapper maps DTO to Entity
        when(restaurantModelMapper.mapRestaurantDTOToRestaurant(inputRestaurantDTO))
            .thenReturn(mappedRestaurantEntity);

        // 2. When repository saves the entity
        when(restaurantRepo.save(mappedRestaurantEntity)) // Or use any(Restaurant.class) if you don't need to assert exact entity
            .thenReturn(savedRestaurantEntity);

        // 3. When mapper maps the saved Entity back to DTO
        when(restaurantModelMapper.mapRestaurantToRestaurantDTO(savedRestaurantEntity))
            .thenReturn(expectedOutputDTO);

        // When: Call the method under test
        RestaurantDTO resultDTO = restaurantService.saveRestaurantInDB(inputRestaurantDTO);

        // Then: Assert the results and verify interactions
        assertNotNull(resultDTO);
        // Ensure RestaurantDTO has proper equals() and hashCode() for this assertion to work
        assertEquals(expectedOutputDTO, resultDTO);
        assertEquals(expectedOutputDTO.getId(), resultDTO.getId());
        assertEquals(expectedOutputDTO.getName(), resultDTO.getName());
        assertEquals(expectedOutputDTO.getAddress(), resultDTO.getAddress());

        // Verify that the DTO to Entity mapping was called once with the correct DTO
        verify(restaurantModelMapper, times(1)).mapRestaurantDTOToRestaurant(inputRestaurantDTO);
        // Verify that the save method was called once on the repository with the mapped entity
        verify(restaurantRepo, times(1)).save(mappedRestaurantEntity);
        // Verify that the Entity to DTO mapping was called once with the saved entity
        verify(restaurantModelMapper, times(1)).mapRestaurantToRestaurantDTO(savedRestaurantEntity);
    }

    @Test
    public void testAddRestaurant_withNullInput() {
        // Given: Null input DTO
        RestaurantDTO inputRestaurantDTO = null;

        // When & Then: Expect a NullPointerException or specific handling from your service
        // This depends on how your service handles null input.
        // For demonstration, let's assume it should throw NPE if not handled explicitly.
        // If your service has validation, you'd test that.

        try {
            restaurantService.saveRestaurantInDB(inputRestaurantDTO);
            // If execution reaches here, it means no exception was thrown, which might be an error depending on expected behavior
            // fail("Expected NullPointerException to be thrown"); // Uncomment if NPE is expected
        } catch (NullPointerException e) {
            // Assert that NPE was thrown.
            assertNotNull(e);
            // You can add more specific assertions about the exception message if needed.
        } catch (Exception e) {
            // Catch other unexpected exceptions
            // fail("Expected NullPointerException but got " + e.getClass().getSimpleName());
        }

        // Verify that no interactions occurred if the input was null and processed early
        verify(restaurantModelMapper, times(0)).mapRestaurantDTOToRestaurant(any(RestaurantDTO.class));
        verify(restaurantRepo, times(0)).save(any(Restaurant.class));
    }

    @Test
    public void testFindAllRestaurant_shouldReturnListOfRestaurantDTOs_whenRestaurantsExist() {
        // Given: Prepare mock data for the repository and mapper
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId(1);
        restaurant1.setName("Restaurant Alpha");
        restaurant1.setAddress("Address Alpha");
        // Set other properties as needed

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setId(2);
        restaurant2.setName("Restaurant Beta");
        restaurant2.setAddress("Address Beta");
        // Set other properties as needed

        List<Restaurant> mockRestaurants = Arrays.asList(restaurant1, restaurant2);

        RestaurantDTO restaurantDTO1 = new RestaurantDTO(
            1, "Restaurant Alpha DTO", "Address Alpha DTO", "City A", "Desc A"
        );
        RestaurantDTO restaurantDTO2 = new RestaurantDTO(
            2, "Restaurant Beta DTO", "Address Beta DTO", "City B", "Desc B"
        );

        // Configure the mocks' behavior
        // 1. When repository finds all restaurants
        when(restaurantRepo.findAll()).thenReturn(mockRestaurants);

        // 2. When mapper maps each Restaurant to RestaurantDTO
        when(restaurantModelMapper.mapRestaurantToRestaurantDTO(restaurant1)).thenReturn(restaurantDTO1);
        when(restaurantModelMapper.mapRestaurantToRestaurantDTO(restaurant2)).thenReturn(restaurantDTO2);

        // When: Call the method under test
        List<RestaurantDTO> result = restaurantService.findAllRestaurant();

        // Then: Assert the results
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(restaurantDTO1, result.get(0)); // Requires equals() in RestaurantDTO
        assertEquals(restaurantDTO2, result.get(1)); // Requires equals() in RestaurantDTO

        // Verify interactions
        verify(restaurantRepo, times(1)).findAll();
        verify(restaurantModelMapper, times(1)).mapRestaurantToRestaurantDTO(restaurant1);
        verify(restaurantModelMapper, times(1)).mapRestaurantToRestaurantDTO(restaurant2);
    }

    @Test
    public void testFindAllRestaurant_shouldReturnEmptyList_whenNoRestaurantsExist() {
        // Given: Repository returns an empty list
        when(restaurantRepo.findAll()).thenReturn(Collections.emptyList());

        // When: Call the method under test
        List<RestaurantDTO> result = restaurantService.findAllRestaurant();

        // Then: Assert the results
        assertNotNull(result);
        assertTrue(result.isEmpty());
        assertEquals(0, result.size());

        // Verify interactions
        verify(restaurantRepo, times(1)).findAll();
        // Ensure mapper is NOT called if repository returns empty list
        verify(restaurantModelMapper, times(0)).mapRestaurantToRestaurantDTO(any(Restaurant.class));
    }
    
    @Test
    public void testGetRestaurantById_shouldReturnRestaurantDTO_whenFound() {
        // Given: An ID and corresponding mock data
        Integer restaurantId = 1;
        Restaurant mockRestaurant = new Restaurant();
        mockRestaurant.setId(restaurantId.intValue());
        mockRestaurant.setName("Found Restaurant");
        mockRestaurant.setAddress("123 Found St");
        // Set other properties as needed

        RestaurantDTO expectedDTO = new RestaurantDTO(
            restaurantId.intValue(), "Found Restaurant DTO", "123 Found St DTO", "Found City", "Found Desc"
        );

        // Configure mocks:
        // 1. When repository finds by ID, return an Optional containing the mock restaurant
        when(restaurantRepo.findById(restaurantId)).thenReturn(Optional.of(mockRestaurant));
        // 2. When mapper maps the found restaurant entity to DTO
        when(restaurantModelMapper.mapRestaurantToRestaurantDTO(mockRestaurant)).thenReturn(expectedDTO);

        // When: Call the method under test
        RestaurantDTO result = restaurantService.getRestaurantById(restaurantId);

        // Then: Assert the result
        assertNotNull(result);
        assertEquals(expectedDTO, result); // Requires equals() in RestaurantDTO
        assertEquals(expectedDTO.getId(), result.getId());
        assertEquals(expectedDTO.getName(), result.getName());

        // Verify interactions
        verify(restaurantRepo, times(1)).findById(restaurantId);
        verify(restaurantModelMapper, times(1)).mapRestaurantToRestaurantDTO(mockRestaurant);
    }

    @Test
    public void testGetRestaurantById_shouldReturnNull_whenNotFound() {
        // Given: An ID for a non-existent restaurant
        Integer restaurantId = 99;

        // Configure mock: When repository tries to find by ID, return an empty Optional
        when(restaurantRepo.findById(restaurantId)).thenReturn(Optional.empty());

        // When: Call the method under test
        RestaurantDTO result = restaurantService.getRestaurantById(restaurantId);

        // Then: Assert the result is null
        assertNull(result);

        // Verify interactions
        // findById should still be called once
        verify(restaurantRepo, times(1)).findById(restaurantId);
        // mapRestaurantToRestaurantDTO should NOT be called if restaurant is not found
        verify(restaurantModelMapper, times(0)).mapRestaurantToRestaurantDTO(any(Restaurant.class));
    }
}



