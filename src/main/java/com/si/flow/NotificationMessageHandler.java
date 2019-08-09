package com.si.flow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.si.async.AsyncJob;
import com.si.model.Notification;

@Component
public class NotificationMessageHandler implements MessageHandler{

	@Autowired
	AsyncJob asyncJob;
	
	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		List<Notification> ls = (List<Notification>) message.getPayload();
		System.out.println(ls.size()+" unprocessed entries found");
		if(null != ls && ls.size() > 0) {
			for(Notification n : ls) {
				System.out.println("Processing Notification, ID:"+n.getId());
				asyncJob.updateProcessed(n.getId());
			}
		}
	}
}
