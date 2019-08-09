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
	
	@Autowired
	NotificationRowMapper notificationRowMapper;
	
	//Channel 'notificationChannel'
	@Bean
    public MessageChannel notificationChannel() {
        return new DirectChannel();
    }
	
	//InboundChannelAdapter (subscribe to notificationChannel and put messages to this channel)
	@Bean
	@InboundChannelAdapter(value = "notificationChannel", poller = @Poller(fixedDelay="10000"))//10 Seconds
	public MessageSource<?> notificationPoller(DataSource dataSource) {
		JdbcPollingChannelAdapter jdbcPollingChannelAdapter = new JdbcPollingChannelAdapter(dataSource, "SELECT * FROM notification where processed = 'NO' ORDER BY appear_time ASC LIMIT 2");
		jdbcPollingChannelAdapter.setRowMapper(notificationRowMapper);
		return jdbcPollingChannelAdapter;
	}
	
	//handling a message on notificationChannel
	@Bean
    @ServiceActivator(inputChannel= "notificationChannel")
    public MessageHandler dbMessageHandler() {
        return notificationMessageHandler;
    }
}
