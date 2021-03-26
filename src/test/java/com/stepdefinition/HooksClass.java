package com.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.LibGlobal;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends LibGlobal{

	@Before
	public void before() {
		getDriver();
		launchUrl("http://adactinhotelapp.com/");

	}
	
	@After
	public void after(Scenario scenario) {
		TakesScreenshot tk = (TakesScreenshot)driver;
		
		byte [] b=tk.getScreenshotAs(OutputType.BYTES);
		
		scenario.embed(b,"img");

	}
}
