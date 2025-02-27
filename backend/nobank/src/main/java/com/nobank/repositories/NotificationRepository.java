package com.nobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
