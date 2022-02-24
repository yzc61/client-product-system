package com.pika.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pika.api.AppClient;
import com.pika.rowmapper.ClientRowMapper;

@Repository
public class ClientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public AppClient getClient(int id) {
		
		String sql = "SELECT * FROM clientlist WHERE CLIENTID=?";
		AppClient appClient = jdbcTemplate.queryForObject(sql,new ClientRowMapper(),id);
		
		return appClient;
	}

}
