package org.runner.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.reports.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", glue = "org\\stepdefinition",
plugin = "json:src\\test\\resources\\Reports\\fb.json")

public class TestRunner {

	@AfterClass
	public static void reportGeneration() {

		JVMReport.generateJvmReport(System.getProperty("user.dir") +
				"\\src\\test\\resources\\Reports\\fb.json");

	}

}
