package com.si.flow;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class NotificationMessageHandler implements MessageHandler{

	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		System.out.println(message.toString());
		
	}
}
