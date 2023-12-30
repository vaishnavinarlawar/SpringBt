package com.exportmodule;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fusiontech.dto.Product;
import com.fusiontech.dto.ProductDetails;
import com.fusiontech.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/Product")
public class DownloadController {
	
	
	    @Autowired
    private ProductService productService;
  

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/downloadExcel")
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

        
           /* SplitData sd=new SplitData();
            sd.deleteSpecificFile("C:/Users/HP/Downloads/product.xlsx", "product.xlsx");
            sd.Splitter();
            
            return ResponseEntity.ok().headers(headers).body(excelBytes);

        } */
        }
        catch (IOException e) {
            e.printStackTrace();
          
            return null;
            } 
            
 
          
    }
  }
