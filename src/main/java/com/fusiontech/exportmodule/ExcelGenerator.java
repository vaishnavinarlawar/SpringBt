package com.fusiontech.exportmodule;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;

import com.fusiontech.dto.Product;
import com.fusiontech.dto.ProductDetails;

public class ExcelGenerator {

	 public static Workbook createExcel(List<Product> products, List<ProductDetails> productDetails) {
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Product Data");

	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Product ID");
	        headerRow.createCell(1).setCellValue("Product Name");
	        headerRow.createCell(2).setCellValue("Product Status");

	        Row detailsHeaderRow = sheet.createRow(1);
	        detailsHeaderRow.createCell(0).setCellValue("Product Details ID");
	        detailsHeaderRow.createCell(1).setCellValue("Details Name");
	        detailsHeaderRow.createCell(2).setCellValue("Details Price");
	        

	        int rowNum = 2;
	        for (Product product : products) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(product.getId());
	            row.createCell(1).setCellValue(product.getName());
	            row.createCell(2).setCellValue(product.getStatus());

	            for (ProductDetails details : product.getPd()) {
	                Row detailsRow = sheet.createRow(rowNum++);
	                detailsRow.createCell(0).setCellValue(details.getId());
	                detailsRow.createCell(1).setCellValue(details.getName());
	                detailsRow.createCell(2).setCellValue(details.getPrice());
	                	            }
	        }

	        return workbook;
	    }

}
