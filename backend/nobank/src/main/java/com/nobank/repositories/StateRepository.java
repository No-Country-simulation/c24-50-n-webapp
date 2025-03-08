package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
