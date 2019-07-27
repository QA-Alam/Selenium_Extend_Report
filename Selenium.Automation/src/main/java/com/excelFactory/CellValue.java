package com.excelFactory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellValue {
	
	static XSSFWorkbook wb;
	public static String getData (int sheetIndex,int row,int column, String path) throws Throwable{
		File src = new File(path);
		
			FileInputStream fis =new FileInputStream(src);
			 wb= new XSSFWorkbook(fis);
		String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).toString();
		return data;
	}
	}
	

