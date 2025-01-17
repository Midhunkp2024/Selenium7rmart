package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public static FileInputStream f;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	
	public static String readExcelData(int row, int col, String filePath, String sheetName) throws IOException{
		f = new FileInputStream(filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		String value = formatter.formatCellValue(c);
		return value;	
	}
	
	public static String readStringData(int row, int column, String filePath, String sheetName)throws IOException{
		f = new FileInputStream(filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		return c.getStringCellValue();
		
	}
	
	public static String readIntegerData(int row, int column, String filePath, String sheetName)throws IOException{
		f = new FileInputStream(filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		int value=(int) c.getNumericCellValue();
		return String.valueOf(value); 
	}	
	
}
