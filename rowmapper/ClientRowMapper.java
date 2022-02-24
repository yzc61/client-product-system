package com.pika.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pika.api.AppClient;



public class ClientRowMapper implements RowMapper<AppClient> {

	@Override
	public AppClient mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AppClient client = new AppClient();
		
		client.setClientid(rs.getInt("clientid"));
		client.setClientname(rs.getString("clientname"));
		client.setClientpassword(rs.getString("clientpassword"));
		
		return client;
	}


		
}
