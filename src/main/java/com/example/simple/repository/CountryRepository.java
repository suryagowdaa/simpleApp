package com.example.simple.repository;

import com.example.simple.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, String> {
    List<Country> findByName(String name);
}
