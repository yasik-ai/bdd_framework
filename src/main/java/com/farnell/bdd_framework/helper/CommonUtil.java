package com.farnell.bdd_framework.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonUtil {

	/**
	 * @Desscription Method to Take screenshot and convert the File to Byte format
	 * @return screenshot byte
	 * @throws IOException
	 */

	public byte[] getByteScreenShot() throws IOException {
		File src = ((TakesScreenshot) WebDriverUtil.driver).getScreenshotAs(OutputType.FILE);

		final byte[] screenshot = FileUtils.readFileToByteArray(src);

		return screenshot;

	}

}
