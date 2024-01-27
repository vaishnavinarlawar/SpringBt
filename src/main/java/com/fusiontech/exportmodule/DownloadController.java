package com.fusiontech.exportmodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fusiontech.dto.Product;
import com.fusiontech.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DownloadController {

	@Autowired
	private DownloadService downloadService;

	@Autowired
	private ProductService productservice;

	@GetMapping("/all")
	public List<Product> getAllProducts(Product product) {
		System.out.println("Inside Get all Product Details ");
		List<Product> prlist = productservice.getAllProduct();
		return prlist;
	}

	@GetMapping("/downloadExcel")
	public ResponseEntity<byte[]> downloadExcel(HttpServletResponse response) {
		System.out.println("inside downloadService downloadExcel");
		ResponseEntity<byte[]> responseEntity = downloadService.downloadExcel(response);

		return responseEntity;
	}
}