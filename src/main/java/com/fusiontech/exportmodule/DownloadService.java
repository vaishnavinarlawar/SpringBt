package com.fusiontech.exportmodule;

import java.io.IOException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fusiontech.dto.Product;
import com.fusiontech.dto.ProductDetails;
import com.fusiontech.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class DownloadService {

	@Autowired
	ProductService productService;

	public ResponseEntity<byte[]> downloadExcel(HttpServletResponse response) {

		try {
			List<Product> products = productService.getAllProduct();
			List<ProductDetails> productDetails = productService.getAllProductdetails();

			Workbook workbook = ExcelGenerator.createExcel(products, productDetails);

			// Convert workbook to byte array
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			workbook.write(byteArrayOutputStream);
			byte[] excelBytes = byteArrayOutputStream.toByteArray();

			// Set the file name and headers
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=product.xlsx");
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

			SplitDataController sd = new SplitDataController();
			sd.deleteSpecificFile("C:/Users/aaa/Downloads/product.xlsx", "products.xlsx");
			sd.Splitter();

			return ResponseEntity.ok().headers(headers).body(excelBytes);

		} catch (IOException e) {
			e.printStackTrace();

			return null;
		}
	}

}
