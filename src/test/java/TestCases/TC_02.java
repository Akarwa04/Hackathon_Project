package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjectClass.Surgeries;
import TestBase.BaseClass;
import Utilities.ExcelOutput;

public class TC_02 extends BaseClass {

	Surgeries surg;
	@Test(priority=0, groups = {"sanity","master" })
	public void Check2() throws InterruptedException {
		
		 surg= new Surgeries(driver);
			
		logger.info("*****TC_02 is starting*****");
		
	surg.Surgery();
	logger.info("*****Click on surgeries*****");
	surg.ScrollDown();
	logger.info("*****Page Is Scrolled Down*****");
	}
	
	@Test(priority=2, groups = {"sanity","master" })
	public void Surg() {
	surg.AllSurgery();
	captureScreen("surgeries");
	logger.info("Surgeries are visible*****");
	}
	
	@Test(priority=3, groups = {"sanity","master" })
	public void Print() throws IOException {
		
		ExcelOutput.ExcelOutputData1();
	}
}