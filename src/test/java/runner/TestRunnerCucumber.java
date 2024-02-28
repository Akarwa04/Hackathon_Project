package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//FeatureFiles",
		glue="cucumber",
		plugin= {"pretty","html:cucumber-report/report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunnerCucumber {

	
}
