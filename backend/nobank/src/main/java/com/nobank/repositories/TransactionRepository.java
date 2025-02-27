package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
