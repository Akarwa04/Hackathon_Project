package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;
 
 
public class extentReport implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
 
	String repName;
 
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
 
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
 
		sparkReporter.config().setDocumentTitle(" Automation Report"); // Title of report
		sparkReporter.config().setReportName("Practo Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
 
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
	}
 
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
		
		String imgPath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
	}
 
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());

		String imgPath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);

		
	}
 
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
 
	public void onFinish(ITestContext testContext) {
		extent.flush();
 
		
	}
 
}