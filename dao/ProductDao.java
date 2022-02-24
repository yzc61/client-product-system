package com.pika.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pika.api.AppProduct;
import com.pika.rowmapper.ProductRowMapper;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<AppProduct> loadAllProduct() {
		
		String sql="SELECT * FROM productlist";
		List<AppProduct> listofallproducts = jdbcTemplate.query(sql, new ProductRowMapper());
			
		return listofallproducts;
	}

	public List<AppProduct> loadClientProduct(String owner) {
		
		String sql = "SELECT * FROM productlist WHERE PRODUCTOWNER=?";
		List<AppProduct> listofallproducts = jdbcTemplate.query(sql,new ProductRowMapper(),owner);
		return listofallproducts;
	}

	public AppProduct getProduct(int pid) {
		String sql = "SELECT * FROM productlist WHERE PRODUCTID=?";
		AppProduct appProduct = jdbcTemplate.queryForObject(sql,new ProductRowMapper(),pid);
		return appProduct;
	}

	public void updateProduct(AppProduct product) {
		String sql = "UPDATE `ayroayro`.`productlist` SET `productname` = ?, `productowner` = ?, `productversion` = ? WHERE (`productid` = ?)";
		jdbcTemplate.update(sql, product.getProductname(),product.getProductowner(),product.getProductversion(),product.getProductid());
	}

	public void deleteProduct(int pid) {
		String sql = "DELETE FROM `ayroayro`.`productlist` WHERE (`productid` = ?)";
		jdbcTemplate.update(sql,pid);
	}

	public void addProduct(AppProduct product) {
		String sql = "INSERT INTO `ayroayro`.`productlist` (`productname`, `productowner`, `productversion`) VALUES (?, ?, ?)";
		Object[] sqlparam = {product.getProductname() , product.getProductowner(), product.getProductversion()	};
		jdbcTemplate.update(sql, sqlparam);
	}

}
