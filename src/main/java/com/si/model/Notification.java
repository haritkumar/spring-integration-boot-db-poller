package com.si.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="notification_type")
	private String notificationType;//SMS/EMAIL
	
	@Column(name="message")
	private String message;
	
	@Column(name="processed")
	private String processed;
	
	@Column(name="appear_time")
	private Date appearTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getAppearTime() {
		return appearTime;
	}

	public void setAppearTime(Date appearTime) {
		this.appearTime = appearTime;
	}

	public Notification(String notificationType, String message, Date appearTime, String processed) {
		super();
		this.notificationType = notificationType;
		this.message = message;
		this.appearTime = appearTime;
		this.processed = processed;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}
	
	
}
