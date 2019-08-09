package com.si.flow;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.si.model.Notification;

@Component
public class NotificationRowMapper implements RowMapper<Notification> {

	@Override
	public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
		return  new Notification(
				rs.getLong("id"), 
				rs.getString("notification_type"), 
				rs.getString("message"), 
				rs.getDate("appear_time"), 
				rs.getString("processed"));
	}

}
