package com.fusiontech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fusiontech.dao.ProductDetailRepository;
import com.fusiontech.dao.ProductRespository;
import com.fusiontech.dto.Product;
import com.fusiontech.dto.ProductDetails;

@Service
public class ProductService {

	@Autowired
	private ProductRespository productRepository;

	@Autowired
	ProductDetailRepository productDetailRepository;

	
	public Product createProduct(Product product) {
		System.out.println("inside CreateProduct");
		Product product1 =productRepository.save(product);
		return product1;
	}
	public List<Product> activeProduct(String status) {
		List<Product>list=productRepository.findByStatus(status);
		return list;
	}
	public List<Product> getAllProduct() {
		List<Product> productList = productRepository.findAll();
		return productList;
			}
	public List<ProductDetails> getAllProductdetails() {
		List<ProductDetails> productDetailsList = productDetailRepository.findAll();
		return productDetailsList;
	}
	

}
