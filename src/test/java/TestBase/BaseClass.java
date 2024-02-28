package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import PageObjectClass.Surgeries;

public class BaseClass {
	
	public static WebDriver driver;
	public  static Logger logger;
	public static Properties p;
 
	@BeforeTest(groups= {"sanity","regression","master"})
	@Parameters({"Browser"})
	public void setUp(String br) throws InterruptedException, IOException
	{	
	        //Loading log4j files
		    logger=LogManager.getLogger(this.getClass());
		    
		    //Properties file
		    FileReader filepath= new FileReader(".//src//test//resources//ConfigFile.properties");
		    p=new Properties();
		    p.load(filepath);
		    
		    
		    if(br.equalsIgnoreCase("chrome"))
			{driver = new ChromeDriver() ;	}
			else if(br.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}

		    
		    // For grid 
		    
		   /* if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
				DesiredCapabilities capabalities = new DesiredCapabilities();
				//os
				if(os.equalsIgnoreCase("windows")) {
					capabalities.setPlatform(Platform.WIN11);
				}
				else if (os.equalsIgnoreCase("mac")) {
					capabalities.setPlatform(Platform.MAC);
				}
				else {
					System.out.println("no matching os .....");
					return;
				}
				//browser
				if(br.equalsIgnoreCase("chrome")) {
					capabalities.setBrowserName("chrome");
				}
				else if(br.equalsIgnoreCase("edge")) {
					capabalities.setBrowserName("MicrosoftEdge");
				}
				else {
					System.out.println("no matching browser .....");
					return;
				}
	 
				 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
			}
			else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
				// launching browser based on condition - locally
				if(br.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
					logger.info("Chrome browser opened successfully");
				}
				else if(br.equalsIgnoreCase("edge")){
					driver = new EdgeDriver();
					logger.info("Edge browser opened successfully");
				}
				else {
					System.out.println("no matching browser......");
					logger.info("no matching browser......");
					return;
				}
	 
			}
			*/
			driver.get(p.getProperty("appUrl"));
			Thread.sleep(3000);
			driver.manage().window().maximize();
			logger.info("---Window maximized---");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 

	}
	@AfterTest(groups= {"sanity","regression","master"})
	public void tearDown() 
	{
		driver.quit();
		
	}
	
	public String captureScreen(String name) 
	{
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	
	
	// for initializing browser in cucumber tests.
	
	     
	public static WebDriver initilizeBrowser() throws IOException
	{
		
		
				switch(getProperties().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			
		 driver.manage().deleteAllCookies(); 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 return driver;
		 
	}
	
	
	public static WebDriver getDriver() {
		return driver;
	}

public static Properties getProperties() throws IOException
{		 
    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFile.properties");
   		
    p=new Properties();
	p.load(file);
	return p;
}

public static Logger getLogger() 
{		 
	logger=LogManager.getLogger(); //Log4j
	return logger;
}


 }
