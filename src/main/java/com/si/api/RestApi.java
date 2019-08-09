package com.si.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.si.model.Notification;
import com.si.repo.NotificationRepository;

@RestController
public class RestApi {

	@Autowired
	NotificationRepository notificationRepository;
	
	@GetMapping("/ingest_notification")
	public String ingestNotification(@RequestParam(required=true) NotificationType notificationType,@RequestParam(required=true) String message ) {
		notificationRepository.save(new Notification(notificationType.name(), message, new Date(), "NO"));
		return "Notification Marked";
	}
	
	public enum NotificationType {
	      SMS,
	      EMAIL
	  }
}
