package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import PageObjectClass.FindDoctors;
import PageObjectClass.Surgeries;

public class ExcelOutput {

	public static void ExcelOutputData() throws IOException 
	{
	 List<String>DrData=FindDoctors.AllDr;
	 List<String>exp=FindDoctors.Review;
	 List<String>Clinicname = FindDoctors.ClinicName;
	 List<String> Way =FindDoctors.Address;
	 
	 FileOutputStream filepath =new FileOutputStream(".//ProjectOutputData//Fileoutput.xlsx");
     XSSFWorkbook workbook=new XSSFWorkbook();
     XSSFSheet sheet1=workbook.createSheet("All Doctors list");
     XSSFRow row=sheet1.createRow(0);
     row.createCell(0).setCellValue("List of All Doctors Available");
     row.createCell(1).setCellValue("List of  Their Experince ");
     row.createCell(2).setCellValue("Clinic Name");
     row.createCell(3).setCellValue("Address Of Clinic ");
     
     for(int i=0;i<DrData.size();i++)
     {
    	 sheet1.createRow(i+1).createCell(0).setCellValue(DrData.get(i));
     }
     
     for(int i=0;i<exp.size();i++)
     {
    	 sheet1.getRow(i+1).createCell(1).setCellValue(exp.get(i));
     }
     
     for(int i=0;i<Clinicname.size();i++)
     {
    	 sheet1.getRow(i+1).createCell(2).setCellValue(Clinicname.get(i));
     }
     
     for(int i=0;i<Way.size();i++)
     {
    	 sheet1.getRow(i+1).createCell(3).setCellValue(Way.get(i));
     }
     
     workbook.write(filepath);
     filepath.close();
     workbook.close();
	}
	public static void ExcelOutputData1() throws IOException 
	{
	 List<String>SurgeryData=Surgeries.AllSurgery;
	 FileOutputStream filepath1 =new FileOutputStream(".//ProjectOutputData//Fileoutput1.xlsx");
     XSSFWorkbook workbook=new XSSFWorkbook();
     XSSFSheet sheet1=workbook.createSheet("All surgeries list");
     XSSFRow row=sheet1.createRow(0);
     row.createCell(0).setCellValue("List of All Surgeries Available");
     System.out.println(SurgeryData);
     for(int i=0;i<SurgeryData.size();i++)
     {
    	 sheet1.createRow(i+1).createCell(0).setCellValue(SurgeryData.get(i));
     }
     workbook.write(filepath1);
     filepath1.close();
     workbook.close();
	}
}
