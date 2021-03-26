package com.runner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.JVMReport;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", glue = {"com.stepdefinition"}, plugin = {
"json:C:\\Users\\admin\\eclipse-workspace_UptoMaven\\CucumberDay7\\src\\test\\resources\\Report.json" })

public class TestRunnerClass {
	@AfterClass
	public static void afterClass() {
		JVMReport.generateReport(
				"C:\\Users\\admin\\eclipse-workspace_UptoMaven\\CucumberDay7\\src\\test\\resources\\Report.json");

	}

	
}
