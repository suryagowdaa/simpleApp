package com.example.simple.controller;

import com.example.simple.model.Country;
import com.example.simple.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private CountryRepository countryRRepository;

    @PostMapping("/country")
    public String addCountry(@RequestBody Country country) {
        countryRepository.save(country);
        return "Country information saved successfully.";
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        Iterable<Country> countryIterable = countryRepository.findAll();
        List<Country> countries = new ArrayList<>();
        countryIterable.forEach(countries::add);
        return countries;
    }

    @DeleteMapping("/country/{name}")
    public String deleteCountry(@PathVariable String name) {
        // Get all countries
        Iterable<Country> allCountries = countryRepository.findAll();

        // Flag to track if any countries were deleted
        boolean deleted = false;

        // Iterate through all countries
        for (Country country : allCountries) {
            // Check if the country name matches
            if (country.getName().equalsIgnoreCase(name)) {
                // Delete the country
                countryRepository.deleteById(country.getId());
                deleted = true;
            }
        }

        if (deleted) {
            return "Country " + name + " deleted successfully.";
        } else {
            return "Country " + name + " does not exist.";
        }
    }




}
