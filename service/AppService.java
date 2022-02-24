package com.pika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pika.api.AppClient;
import com.pika.api.AppProduct;
import com.pika.dao.ClientDao;
import com.pika.dao.ProductDao;

@Service
public class AppService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ClientDao clientDao;
	
	public List<AppProduct> loadAllProduct() {
		List<AppProduct> productlist = productDao.loadAllProduct();
		
		return productlist;
	}


	public List<AppProduct> loadClientProduct(String owner) {
		List<AppProduct> productlist = productDao.loadClientProduct(owner);
		
		return productlist;
	}


	public AppClient getClient(int id) {
		AppClient appClient = clientDao.getClient(id);
		return appClient;
	}


	public AppProduct getProduct(int pid) {
		AppProduct appProduct = productDao.getProduct(pid);
		return appProduct;
	}


	public void updateProduct(AppProduct product) {
		productDao.updateProduct(product);
		
	}


	public void deleteProduct(int pid) {
		productDao.deleteProduct(pid);
		
	}


	public void addProduct(AppProduct product) {
		productDao.addProduct(product);
		
	}

	
	
}
