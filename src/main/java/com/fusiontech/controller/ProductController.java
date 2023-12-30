package com.fusiontech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fusiontech.dto.Product;
import com.fusiontech.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	public ProductController() {
		System.out.println("inside ProductController const");
	}

	@PostMapping("/createproduct")
	public Product createproduct(@RequestBody Product product) {
		System.out.println("inside createProduct");
		Product pro = productService.createProduct(product);
		return pro;

	}

	@GetMapping("/findActive")
	public List<Product> activeProduct(String status) {
		List<Product> list = productService.activeProduct(status);
		return list;
	}

	@GetMapping("/getall")
	public List<Product> getAllProducts(Product product) {
		System.out.println("Inside Get all Product Details ");
		List<Product> prlist = productService.getAllProduct();
		return prlist;
	}
}
