package cucumber;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestBase.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	static WebDriver driver;
	
	@BeforeAll
	public static void Setup() throws IOException {
	
		driver= BaseClass.initilizeBrowser();
	}
	
	@AfterAll
	public static void TearDown() {
		driver.quit();
	}
	
	@AfterStep
    public void addScreenshot(Scenario scenario) {
        
    	// this is for cucumber junit report
        
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        
      
    }
   
}
