package com.si.flow;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class DbPoller {

	@Autowired
	NotificationMessageHandler notificationMessageHandler;
	
	@Bean
    public MessageChannel notificationChannel() {
        return new DirectChannel();
    }
	
	@Bean
	@InboundChannelAdapter(value = "notificationChannel", poller = @Poller(fixedDelay="5000"))//5 Seconds
	public MessageSource<?> notificationPoller(DataSource dataSource) {
	    return new JdbcPollingChannelAdapter(dataSource, "SELECT * FROM notification where processed = 'NO'");
	}
	
	@Bean
    @ServiceActivator(inputChannel= "notificationChannel")
    public MessageHandler dbMessageHandler() {
        return notificationMessageHandler;
    }
}