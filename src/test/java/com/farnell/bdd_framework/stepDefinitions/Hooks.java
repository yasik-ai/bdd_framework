package com.farnell.bdd_framework.stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import com.farnell.bdd_framework.enums.Browsers;
import com.farnell.bdd_framework.helper.CommonUtil;
import com.farnell.bdd_framework.helper.LoggerHelper;
import com.farnell.bdd_framework.helper.WebDriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriverUtil wdUtil;
	
	CommonUtil commonUtil = new CommonUtil();
	Logger logger = LoggerHelper.getLogger(Hooks.class);

	@Before
	public void initializeTest() {
		wdUtil = new WebDriverUtil();
		wdUtil.selectBrowser(Browsers.CHROME.name());

	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				logger.info(scenario.getName() + " is Failed");
				
				scenario.attach(commonUtil.getByteScreenShot(), "image/png", scenario.getName() + "screenshot");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.info(scenario.getName() + " is Passed");
		}
		WebDriverUtil.driver.manage().deleteAllCookies();
		WebDriverUtil.driver.quit();
		
	}

}
