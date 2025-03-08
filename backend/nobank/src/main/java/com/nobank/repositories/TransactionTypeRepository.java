package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.TransactionType;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {

}
