package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author ATHARVA SURVE
 *
 */

public class FileLibrary {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
		public String readDataFromProperty(String key) throws IOException {
			FileInputStream fis = new FileInputStream("./TestData/commondata.property");
			Properties p = new Properties();
			p.load(fis);
			String Value = p.getProperty(key);
			return Value;
		}	
		
		/**
		 * 
		 * @param Sheetname
		 * @param row
		 * @param cell
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		
		
		public String readDataFromExcelSheet(String Sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./TestData/BANKINGINFO.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String Value = wb.getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
			return Value;
		}
}
