package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}
