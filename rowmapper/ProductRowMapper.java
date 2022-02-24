package com.pika.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pika.api.AppProduct;

public class ProductRowMapper implements RowMapper<AppProduct> {

	@Override
	public AppProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AppProduct product = new AppProduct();
		
		product.setProductid(rs.getInt("productid"));
		product.setProductname(rs.getString("productname"));
		product.setProductowner(rs.getString("productowner"));
		product.setProductversion(rs.getInt("productversion"));
		
		return product;
	}
	
}
