package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilites {
	
	public static List<String>Mydata=new ArrayList<String>();
	public static List<String>Mydata1 = new ArrayList<String>();
	
	public static List<String> InvalidData() throws IOException{
		FileInputStream filepath =new FileInputStream(".//ProjectInputData//Input.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(filepath);
		XSSFSheet sheet1= workbook.getSheet("Sheet1");
		for (int i=1;i<=4;i++) {
			String cellData=sheet1.getRow(i).getCell(0).toString();
			Mydata.add(cellData);
		}
		filepath.close();
		workbook.close();
		return Mydata;
	}
	public static List<String> ValidData() throws IOException{
		FileInputStream filepath =new FileInputStream(".//ProjectInputData//Input.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(filepath);
		XSSFSheet sheet1= workbook.getSheet("Sheet1");
		for (int i=1;i<=4;i++) {
			
			DataFormatter format = new DataFormatter();
			
			String cellData=format.formatCellValue(sheet1.getRow(i).getCell(1));
			Mydata1.add(cellData);
		}
		filepath.close();
		workbook.close();
		return Mydata1;
	}

}
