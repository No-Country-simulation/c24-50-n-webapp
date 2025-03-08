package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
