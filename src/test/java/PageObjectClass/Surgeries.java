package PageObjectClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Surgeries extends BasePage {

	public Surgeries(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Locators
	
	@FindBy(xpath="//div[contains(text(),'Surgeries')]")
	WebElement SurgeryPart;
	
	@FindBy(xpath="//h1[@data-qa-id='surgical-solution-header']")
    WebElement title;
	
	@FindBy(xpath="//div[@class='SurgicalSolutions-module_ailmentItemWrapper__Krx-u']")
	List<WebElement> topsurgery;
	
	//Methods
	
	public static List<String>AllSurgery = new ArrayList<>();
	
	public void Surgery() throws InterruptedException {
		
		SurgeryPart.click();
		
        Thread.sleep(3000);	
	}
	
	public void ScrollDown() {
	
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	     js.executeScript("arguments[0].scrollIntoView();", title);
	     
	}
	
	public void AllSurgery() {
		AllSurgery.clear();
		for(int i=0;i<topsurgery.size();i++) {
		   	  String data= topsurgery.get(i).getText();
		   	  AllSurgery.add(data);
		   	  }
	}
	
}
