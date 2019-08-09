package com.si.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
