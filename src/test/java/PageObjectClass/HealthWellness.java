package PageObjectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HealthWellness extends BasePage {

	public HealthWellness(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
		//Locators
		
		@FindBy(xpath="//span[normalize-space()='For Corporates']")
		WebElement Corporate;
		
		@FindBy(xpath="//a[normalize-space()='Health & Wellness Plans']")
		WebElement Healing;
		
		@FindBy(xpath="//input[@id='name']")
		WebElement name;
		
		@FindBy(xpath="//input[@id='organizationName']")
		WebElement organization;
		
		@FindBy(xpath="//input[@id='contactNumber']")
		WebElement contact;
		
		@FindBy(xpath="//input[@id='officialEmailId']")
		WebElement email;
		
		@FindBy(xpath="//select[@id='organizationSize']")
		WebElement size;
		
		@FindBy(xpath="//select[@id='interestedIn']")
		WebElement interested;
		
		@FindBy(xpath="//button[normalize-space()='Schedule a demo']")
		WebElement schedule;
		
		@FindBy(xpath="//div[@class='u-text--bold text-alpha']")
		WebElement msg;
		
		
		
		// Methods
		
		public void corporate() {
			
			Corporate.click();
		}
		
		public void healer() {
			Healing.click();
		}
		
		public boolean Details(List<String>InvalidData) throws InterruptedException {
			
			name.sendKeys(InvalidData.get(0));
			organization.sendKeys(InvalidData.get(1));
			contact.sendKeys(InvalidData.get(2));
			email.sendKeys(InvalidData.get(3));
			Select size2=new Select(size);
		    size2.selectByVisibleText("10001+");
		    Select interested2=new Select(interested);
		    interested2.selectByVisibleText("Taking a demo");
		    boolean check=schedule.isEnabled();
		    
		    name.clear();
		    organization.clear();
		    contact.clear();
		    email.clear();
		    
		    return check;
		}
		
		public void Details2(List<String>ValidData) throws InterruptedException {
			
			
			driver.navigate().refresh();
			
			name.sendKeys(ValidData.get(0));
			organization.sendKeys(ValidData.get(1));
			contact.sendKeys(ValidData.get(2));
			email.sendKeys(ValidData.get(3));
			Select size2=new Select(size);
		    size2.selectByVisibleText("10001+");
		    Select interested2=new Select(interested);
		    interested2.selectByVisibleText("Taking a demo");
		    boolean check=schedule.isEnabled();
		    if(check==true) {
			    schedule.click();
			    Thread.sleep(10000);
			    String message=msg.getText();
			    System.out.println(message);
			    }
			    else {
			    	System.out.println("not");
			    }
		    
		}
		
		
		
		

		
		
		
		
}


