package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
