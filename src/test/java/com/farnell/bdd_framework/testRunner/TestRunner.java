package com.farnell.bdd_framework.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/farnell/bdd_framework/resources/features", glue = {
		"com/farnell/bdd_framework/stepDefinitions" }, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = ("@regression"), monochrome = true, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

}
