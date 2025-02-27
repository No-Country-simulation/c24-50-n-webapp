package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
