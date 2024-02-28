package cucumber;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjectClass.FindDoctors;
import PageObjectClass.HealthWellness;
import PageObjectClass.Surgeries;
import TestBase.BaseClass;
import Utilities.ExcelOutput;
import Utilities.ExcelUtilites;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testCase {

	static WebDriver driver;
	Properties p;
	Logger logger;
	FindDoctors  obj;
	Surgeries surg;
	HealthWellness healthwell;
	
	@Given("the user is on the practo page")
	public void the_user_is_on_the_practo_page() throws IOException {
	   
		driver = BaseClass.getDriver();
		p=BaseClass.getProperties();
		logger=BaseClass.getLogger();
		driver.get(p.getProperty("appUrl"));
	}

	@When("the user enters credentials \\(city: {string} , speciality: {string})")
	public void the_user_enters_credentials_city_speciality(String city, String expert) throws InterruptedException {
		obj = new FindDoctors(driver);
		obj.FindDR();
		logger.info("Find Doctors is clicked");
		
		obj.SearchBox(p.getProperty("location"));
		obj.Speciality(p.getProperty("speciality"));
		logger.info("*****City is entered*****");
	}

	@When("the user select patient stories")
	public void the_user_select_patient_stories() throws InterruptedException {
	   
		Assert.assertEquals(obj.patientstoryIsDisplayed(), true);
		obj.PatientStory();
	}

	@When("the user select the experience from the options")
	public void the_user_select_the_experience_from_the_options() throws InterruptedException {
	    
		obj.TotalExp();
		logger.info("*****Patient story and experience are selected*****");
	}

	@When("the user select the price and availability options from all filters")
	public void the_user_select_the_price_and_availability_options_from_all_filters() throws InterruptedException {
	    
		obj.Price();
		obj.Available();
		logger.info("*****Price and availability are selected*****");
		
	}

	@Then("the user click on the sort by option")
	public void the_user_click_on_the_sort_by_option() throws InterruptedException {
	    
		obj.AllFilter();
		logger.info("*****SortBy is Selected*****");
		
	}

	@Then("the user should capture the first five doctor details")
	public void the_user_should_capture_the_first_five_doctor_details() throws IOException {
	    
		obj.DrName();
		logger.info("*****Doctors Name are Visible*****");
		
		ExcelOutput.ExcelOutputData();
	}

	@Given("the user click on surgeries")
	public void the_user_click_on_surgeries() throws InterruptedException, IOException {
		driver = BaseClass.getDriver();
		p=BaseClass.getProperties();
		logger=BaseClass.getLogger();
		 surg= new Surgeries(driver);
		 
		 surg.Surgery();
			logger.info("*****Click on surgeries*****");
		
	}

	@When("the user is on surgeries page he should scroll down")
	public void the_user_is_on_surgeries_page_he_should_scroll_down() {
	   
		surg.ScrollDown();
		logger.info("*****Page Is Scrolled Down*****");
		
	}

	@Then("the user should take all surgeries available in the list")
	public void the_user_should_take_all_surgeries_available_in_the_list() throws IOException {
	  
		surg.AllSurgery();
		logger.info("Surgeries are visible*****");
		ExcelOutput.ExcelOutputData1();
		
	}

	@Given("the user click on corporate")
	public void the_user_click_on_corporate() {
	    	
		healthwell= new HealthWellness(driver);
		
		healthwell.corporate();
	}

	@Given("the user click on health&wellness")
	public void the_user_click_on_health_wellness() {
	    
		healthwell.healer();
		
	}

	@Then("the user should fill the form with invalid details")
	public void the_user_should_fill_the_form_with_invalid_details() throws InterruptedException, IOException {
	    
		List<String>ExcelInputData = ExcelUtilites.InvalidData();
		System.out.println(ExcelInputData);
		boolean Actual=healthwell.Details(ExcelInputData);
		Assert.assertEquals(Actual,false);
		
	}

	@Then("the user should fill the required form with valid details and click on schedule button")
	public void the_user_should_fill_the_required_form_with_valid_details_and_click_on_schedule_button() throws IOException, InterruptedException {
	    
		List<String>ExcelInputData1 = ExcelUtilites.ValidData();
		System.out.println(ExcelInputData1);
		healthwell.Details2(ExcelInputData1);
	}

	
}
