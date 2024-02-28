package PageObjectClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindDoctors extends BasePage {

	public FindDoctors(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	
	@FindBy(xpath="//a/div[normalize-space()='Find Doctors']")
	WebElement FindDoctor;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	WebElement searchbox;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-entire-city']")
	WebElement city;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement searchbox2;
	
	@FindBy(xpath="//div[@class='c-omni-suggestion-item__content__title']")
	List<WebElement> doct;
	
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']")
	WebElement patientstory;
	
	@FindBy(xpath="//li[@tabindex='0']")
	List<WebElement> clickpatientStory;
	
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']")
	WebElement exp;
	
	@FindBy(xpath="//li[@tabindex='0']")
	List<WebElement> yrsexperience;
	
	@FindBy(xpath="//span[normalize-space()='All Filters']")
	WebElement filter;
	
	@FindBy(xpath="//*[text()='₹0-₹500']")
	WebElement price;
	
	@FindBy(xpath="//span[normalize-space()='All Filters']")
	WebElement allfilter;
	
	@FindBy(xpath="//*[text()='Available Tomorrow']")
	WebElement available;
	
	@FindBy(xpath="//span[@data-qa-id='sort_by_selected']")
	WebElement sortBy;
	
	@FindBy (xpath="//li[@tabindex='0']")
	List<WebElement> hightolow;
	
	@FindBy(xpath="//h2[@data-qa-id='doctor_name']")
	List<WebElement> drName;
	
	@FindBy(xpath="//div[@data-qa-id='doctor_experience']")
	List<WebElement> experience;
	
	@FindBy(xpath = "//span[@data-qa-id='doctor_clinic_name']")
	List<WebElement> Clinic;
 
	@FindBy(xpath="//span[@data-qa-id='practice_locality']")
	List<WebElement>practice;
	
	
	// METHODS
	
	public static List<String>AllDr = new ArrayList<>();
	public static List<String>Review = new ArrayList<>();
	public static List<String>ClinicName = new ArrayList<>();
	public static List<String>Address= new ArrayList<>();
	
	public void FindDR() {
		FindDoctor.click();
	}
	
	public void SearchBox(String loc) throws InterruptedException {
		
		searchbox.click();
		searchbox.clear();

		searchbox.sendKeys(loc);
		city.click();
		Thread.sleep(2000);
	}
	
	public boolean searchBoxIsDisplayed() {
		return searchbox.isDisplayed();
	}
	
	public void Speciality(String doc) throws InterruptedException {
		searchbox2.sendKeys(doc);
		Thread.sleep(3000);
		for(int i=0;i<doct.size();i++) {
	    	String text=doct.get(i).getText();
	    	if(text.equalsIgnoreCase("dentist")){
	    		doct.get(i).click();
	    		break;
	    	}
	}
	}
	
	public void PatientStory() throws InterruptedException {
		patientstory.click();
		for(int i=0;i<clickpatientStory.size();i++) {
			  String story=clickpatientStory.get(i).getText();
			  if(story.equalsIgnoreCase("10+ Patient Stories")){
				  clickpatientStory.get(i).click();
		  	      break;
		  	}
	}
		Thread.sleep(2000);
	}
	
	public boolean patientstoryIsDisplayed() {
		return patientstory.isDisplayed();
	}
	
	public void TotalExp() throws InterruptedException {
		exp.click();
		 for(int i=0;i<yrsexperience.size();i++) {
			  String exp=yrsexperience.get(i).getText();
			  if(exp.equalsIgnoreCase("5+ Years of experience")){
				  yrsexperience.get(i).click();
		  	      break;
		  	}
		 }
		 
		 Thread.sleep(3000);
		 
	}
	
	public void Price() throws InterruptedException {
		 filter.click();
		 price.click();
		 Thread.sleep(3000);
	}
	
	public void Available() throws InterruptedException {
		 filter.click();
		 available.click();
		 Thread.sleep(2000);
	}
	
	public void AllFilter() throws InterruptedException {
		 sortBy.click();
		 for(int i=0;i<hightolow.size();i++) {
			  String sorting=hightolow.get(i).getText();
			  if(sorting.equalsIgnoreCase("Experience - High to Low")){
				  hightolow.get(i).click();
		  	      break;
		  	}
		  }
		
		 Thread.sleep(3000);
	}

	public void DrName() {
		AllDr.clear();
		Review.clear();
		ClinicName.clear();
		Address.clear();
		  for(int i=0;i<5;i++) {
			String name= drName.get(i).getText();
			AllDr.add(name);
			System.out.println(name);
		  }
		  
		  for(int i=0;i<5;i++) {
			 String exp= experience.get(i).getText();
			 Review.add(exp);
			 System.out.println(exp);
		  }
		  
		  for(int i=0;i<5;i++) {
				 String Clinicname= Clinic.get(i).getText();
				 ClinicName.add(Clinicname);
				 System.out.println(Clinicname);
			  }
		  
		  for(int i=0;i<5;i++) {
				 String route= practice.get(i).getText();
				 Address.add(route);
				 System.out.println(route);
			  }
	}
}
