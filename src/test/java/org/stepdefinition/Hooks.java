package org.stepdefinition;

import org.baseclass.BC;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BC {

	@Before
	public void beforeScenario() {

		System.out.println("***********Scenario Starts***********");
	}

	@After
	public void afterScenario(Scenario s) {
 
		if (s.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			s.embed(screenshotAs, "image/png");

			System.out.println(s.getName() + "******Scenario Failed***********");

		}
        
		System.out.println("*********Scenario Ends***********");
	
	}
	@AfterClass
	public static void closeBrowser() {
		closeBrowser();
		

	}

}
