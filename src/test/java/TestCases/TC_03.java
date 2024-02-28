package TestCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectClass.FindDoctors;
import PageObjectClass.HealthWellness;
import TestBase.BaseClass;
import Utilities.ExcelUtilites;

public class TC_03 extends BaseClass {
	
	HealthWellness healthwell;
	@Test(priority=0, groups = {"sanity","master" })
	public void Check3() {
		
	    healthwell= new HealthWellness(driver);
	    
	    logger.info("*****TC_03 is starting*****");
		
		healthwell.corporate();
	
		captureScreen("corpo");
	}
	
	@Test(priority=1, groups = {"sanity","master" })
	public void clickHealth() {
	   
		healthwell.healer();
		captureScreen("ss");
	}
	@Test(priority=2, groups = {"regression","master" })
	public void clickAgain() throws Exception {
		 
		List<String>ExcelInputData = ExcelUtilites.InvalidData();
		System.out.println(ExcelInputData);
		captureScreen("Invalid");
		boolean Actual=healthwell.Details(ExcelInputData);
		Assert.assertEquals(Actual,false);
		logger.info("************TEST CASE 8 SUCESSESFULLY EXECUTED***********");
		//captureScreen("Invalid");
	}
 
@Test(priority=3, groups = {"regression","master" })
public void clickOnceAgain() throws Exception {
	
	List<String>ExcelInputData1 = ExcelUtilites.ValidData();
	System.out.println(ExcelInputData1);
	healthwell.Details2(ExcelInputData1);
	captureScreen("Capture final Msg");
	logger.info("************TEST CASE 9 SUCESSESFULLY EXECUTED***********");
	
}

}
