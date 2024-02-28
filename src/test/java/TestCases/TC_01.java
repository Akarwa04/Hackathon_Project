package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectClass.FindDoctors;
import TestBase.BaseClass;
import Utilities.ExcelOutput;

public class TC_01 extends BaseClass{

	FindDoctors  obj;
	
	@Test(priority=0, groups= {"sanity","master"})
	public void Verify() {
		
		obj = new FindDoctors(driver);
		
		logger.info("*****TC_01 is starting*****");
		
		String Exp_Title = driver.getTitle();
		String Act_Title ="Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";
		System.out.println(Exp_Title);
		Assert.assertEquals(Exp_Title,Act_Title,"Title didn't match");
		logger.info("*****Title is done*****");
	}
	
	@Test(priority =1, groups= {"sanity","master"})
	public void SearchBoxIsDisplayed() {
		Assert.assertEquals(obj.searchBoxIsDisplayed(), true);
	}
	
	
	@Test(priority=2, groups= {"sanity","master"})	
	public void Dr() throws InterruptedException {
		
		
		obj.FindDR();
		logger.info("Find Doctors is clicked");
		
		obj.SearchBox(p.getProperty("location"));
		captureScreen("search");
		logger.info("*****City is entered*****");
	}
	
	@Test(priority=3, groups= {"sanity","master"})
		public void Expertise() throws InterruptedException{
		
		obj.Speciality(p.getProperty("speciality"));
		captureScreen("expert");
		logger.info("*****Expertise is choosed*****");
		}
	
	@Test(priority=4, groups= {"sanity","master"})
	public void StoryExp() throws InterruptedException {
		Assert.assertEquals(obj.patientstoryIsDisplayed(), true);
		obj.PatientStory();

		obj.TotalExp();
		captureScreen("yrsExp");
		logger.info("*****Patient story and experience are selected*****");
	}
	
	@Test(priority=5, groups= {"sanity","master"})
	public void Money() throws InterruptedException{
		obj.Price();
		captureScreen("MoneyDone");
	}
	
	@Test(priority=6, groups= {"sanity","master"})
	public void ThereOrNot() throws InterruptedException {
		obj.Available();
		captureScreen("AVailable");
		
		logger.info("*****Price and availability are selected*****");
		obj.AllFilter();
		captureScreen("filter");
		logger.info("*****SortBy is Selected*****");
	}
	
	@Test(priority=7, groups= {"sanity","master"})
	public void Names() {
		obj.DrName();
		logger.info("*****Doctors Name are Visible*****");
	}
	
	@Test(priority=8, groups= {"sanity","master"})
	public void Print() throws IOException {
		
		ExcelOutput.ExcelOutputData();
	}
	
}
