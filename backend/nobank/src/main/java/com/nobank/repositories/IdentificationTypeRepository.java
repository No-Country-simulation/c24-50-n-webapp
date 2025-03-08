package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.IdentificationType;

public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Long> {

}
