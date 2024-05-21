package com.example.simple.controller;

import com.example.simple.model.Country;
import com.example.simple.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DataControllerTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private DataController dataController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCountry() {
        Country country = new Country();
        country.setId("1");
        country.setName("Test Country");
        country.setStates(10);
        country.setPopulation(1000000L);
        country.setLanguage("English");

        when(countryRepository.save(country)).thenReturn(country);

        String expectedResponse = "Country information saved successfully.";

        // Call the addCountry method
        String response = dataController.addCountry(country);

        // Since the method returns a String, compare it directly
        assertEquals(expectedResponse, response);
        verify(countryRepository, times(1)).save(country);
    }

    @Test
    public void testGetCountries() {
        List<Country> countries = new ArrayList<>();
        Country country1 = new Country();
        country1.setId("1");
        country1.setName("Country 1");
        country1.setStates(10);
        country1.setPopulation(1000000L);
        country1.setLanguage("English");
        countries.add(country1);

        when(countryRepository.findAll()).thenReturn(countries);

        List<Country> response = dataController.getCountries();

        assertEquals(1, response.size());
        assertEquals(country1.getName(), response.get(0).getName());
        verify(countryRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteCountry() {
        String countryName = "Test Country";
        Country country = new Country();
        country.setId("1");
        country.setName(countryName);
        country.setStates(10);
        country.setPopulation(1000000L);
        country.setLanguage("English");

        // Simulating the repository behavior
        when(countryRepository.findAll()).thenReturn(List.of(country));
        doNothing().when(countryRepository).deleteById(country.getId());

        // Calling the deleteCountry method
        String response = dataController.deleteCountry(countryName);


        System.out.println("Actual Response: " + response);


        assertEquals("Country " + countryName + " deleted successfully.", response);
        verify(countryRepository, times(1)).findAll();
        verify(countryRepository, times(1)).deleteById(country.getId());
    }
}
