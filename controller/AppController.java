package com.pika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pika.api.AppProduct;
import com.pika.service.AppService;

@Controller
public class AppController {

	@Autowired
	private AppService appService;

	@GetMapping("")
	public String mainPage() {

		return "main-page";
	}

	@PostMapping("/client-main")
	public String clientMainPage(@RequestParam("clientid") int id, @RequestParam("clientpassword") String password,
			Model model) {

		// þifre kontrol etme
		String pass = appService.getClient(id).getClientpassword();
		if (pass.equals(password)) {
			model.addAttribute("clientid", id);
			model.addAttribute("clientpassword", password);
			return "client-main-page";
		} else {
			return "main-page";
		}
	}

	@PostMapping("/all-products")
	public String allProducts(@RequestParam("clientid") int id, @RequestParam("clientpassword") String password,
			Model model) {

		model.addAttribute("clientid", id);
		model.addAttribute("clientpassword", password);
		// bring all products
		List<AppProduct> productlist = appService.loadAllProduct();
		model.addAttribute("listofap", productlist);

		return "all-products-page";
	}

	@PostMapping("/client-products")
	public String clientProducts(@RequestParam("clientid") int id, @RequestParam("clientpassword") String password,
			Model model) {

		model.addAttribute("clientid", id);
		model.addAttribute("clientpassword", password);

		// getting client
		String owner = appService.getClient(id).getClientname();

		// getting list of selected client's products
		List<AppProduct> productlist = appService.loadClientProduct(owner);
		model.addAttribute("listofcp", productlist);

		return "client-products-page";
	}

	@PostMapping("/update-product-info")
	public String updateProductPage(@RequestParam("clientid") int id, @RequestParam("clientpassword") String password,
			Model model, @RequestParam("productid") int pid) {

		model.addAttribute("clientid", id);
		model.addAttribute("clientpassword", password);
		

		// get product by id
		AppProduct product = appService.getProduct(pid);
		model.addAttribute("product", product);

		return "update-product-page";
	}

	@PostMapping("/update-product")
	public String updateProduct(@RequestParam("clientid") int id, @RequestParam("clientpassword") String password,
			@RequestParam("productid") int pid, @RequestParam("productname") String pname,
			@RequestParam("productversion") int pvers, @RequestParam("productowner") String powner, Model model) {

		model.addAttribute("clientid", id);
		model.addAttribute("clientpassword", password);

		// create product with updated info
		AppProduct product = new AppProduct();
		product.setProductid(pid);
		product.setProductname(pname);
		product.setProductowner(powner);
		product.setProductversion(pvers);

		// update the product
		appService.updateProduct(product);

		// getting client
		String owner = appService.getClient(id).getClientname();

		// getting list of selected client's products
		List<AppProduct> productlist = appService.loadClientProduct(owner);
		model.addAttribute("listofcp", productlist);

		return "client-products-page";
	}

	@PostMapping("/delete-product")
	public String deleteProduct(@RequestParam("clientid") int id, @RequestParam("clientpassword") String password,
			@RequestParam("productid") int pid, Model model) {

		model.addAttribute("clientid", id);
		model.addAttribute("clientpassword", password);

		// delete product
		appService.deleteProduct(pid);

		// getting client
		String owner = appService.getClient(id).getClientname();

		// getting list of selected client's products
		List<AppProduct> productlist = appService.loadClientProduct(owner);
		model.addAttribute("listofcp", productlist);

		return "client-products-page";
	}

	@PostMapping("/add-product-page")
	public String addProductPage(@RequestParam("clientid") int id, @RequestParam("clientpassword") String password,
			Model model) {

		model.addAttribute("clientid", id);
		model.addAttribute("clientpassword", password);
		
		// getting client
		String owner = appService.getClient(id).getClientname();
		model.addAttribute("clientname", owner);

		return "add-product-page";
	}

	@PostMapping("/add-product")
	public String addProduct(@RequestParam("clientid") int id, @RequestParam("clientpassword") String password,
			@RequestParam("productname") String pname, @RequestParam("productversion") int pvers,
			@RequestParam("productowner") String powner, Model model) {

		model.addAttribute("clientid", id);
		model.addAttribute("clientpassword", password);

		// creating product with info
		AppProduct product = new AppProduct();
		product.setProductname(pname);
		product.setProductowner(powner);
		product.setProductversion(pvers);

		// adding product
		appService.addProduct(product);

		// getting client
		String owner = appService.getClient(id).getClientname();

		// getting list of selected client's products
		List<AppProduct> productlist = appService.loadClientProduct(owner);
		model.addAttribute("listofcp", productlist);

		return "client-products-page";
	}

}
