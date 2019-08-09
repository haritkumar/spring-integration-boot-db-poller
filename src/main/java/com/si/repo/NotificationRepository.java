package com.si.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.si.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

	@Transactional
	@Modifying
	@Query("update Notification n set n.processed = 'YES' where n.id = ?1")
	void setNotificationById(Long id);
}
