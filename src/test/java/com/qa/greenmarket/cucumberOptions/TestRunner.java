package com.qa.greenmarket.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/testresources/com/qa/greenmarket/features",
		glue={"com/qa/greenmarket/stepDefinitions","com/qa/greenmarket/appHooks"},
		tags= {"@Smoke"},
		stepNotifications = true,
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-html-report",
						"json:target/cucumber-reports/cucumber.json",
						"junit:target/cucumber-reports/cucumber.xml",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestRunner {
	
	


}
