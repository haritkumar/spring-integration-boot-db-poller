package com.si.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.si.repo.NotificationRepository;

@Service
public class AsyncJob {

	@Autowired
	NotificationRepository notificationRepository;
	
	@Async
	public void updateProcessed(Long id) {
		System.out.println("Marked processed , Id: "+id);
		notificationRepository.setNotificationById(id);
	}
	
}
