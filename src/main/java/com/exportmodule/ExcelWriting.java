package com.exportmodule;

import java.util.List;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.fusiontech.dto.Product;
import com.fusiontech.dto.ProductDetails;


public class ExcelWriting {
	  public static Workbook createExcel(List<Product> products, List<ProductDetails> productDetails){
		  static String path="C:/Users/HP/Desktop/test.xlsx";
		  static  String sheetName = "Sheet1";

			public static void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
				File xfile = new File(path);
				if (!xfile.exists()) {
					Workbook workbook = new HSSFWorkbook();

					FileOutputStream fo = new FileOutputStream(path);
					workbook.write(fo);
				}
				FileInputStream fi = new FileInputStream(path);
				HSSFWorkbook Workbook = new HSSFWorkbook(fi);

				if (Workbook.getSheetIndex(sheetName) == 1)
					Workbook.createSheet(sheetName);
				HSSFSheet sheet = Workbook.getSheet(sheetName);
				System.out.println("End point here");

				
				
//				if (sheet.getRow(rownum) == null)
//					sheet.createRow(rownum);
//				HSSFRow row = sheet.getRow(rownum);
//				
				System.out.println("End2 point here");
				
				 HSSFRow row = sheet.getRow(rownum);
				 System.out.println(row);
					System.out.println("End3 point here");

			        if (row == null) {
			            row = sheet.createRow(rownum);
			        }
				
				
				
				

				HSSFCell cell = row.createCell(colnum);
				cell.setCellValue(data);

				FileOutputStream fo = new FileOutputStream(path);
				Workbook.write(fo);
				//Workbook.close();
				fi.close();
				fo.close();

			}

			public static void main(String[] args) throws IOException {
				// TODO Auto-generated method stub
				System.out.println("Swapnil here");
				
				setCellData("sheet1", 0, 0, "Id");
				setCellData("sheet1", 0, 1, "manufacturer");
				setCellData("sheet1", 0, 2, "manufacturer_date");
				setCellData("sheet1", 0, 3, "name");
				setCellData("sheet1", 0, 4, "pf_k");
			}
	  }
	  }
	  }
