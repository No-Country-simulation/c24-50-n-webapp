package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
