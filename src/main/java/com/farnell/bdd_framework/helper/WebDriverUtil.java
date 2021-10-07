package com.farnell.bdd_framework.helper;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.farnell.bdd_framework.enums.Browsers;
import com.farnell.bdd_framework.enums.OS;

public class WebDriverUtil {

	public static WebDriver driver;
	WaitUtil waitUtil = new WaitUtil();

	/**
	 * 
	 * 
	 * @Description: Method to select and execute scripts on desired browsers
	 * 
	 * @return : WebDriver
	 * 
	 */

	public WebDriver selectBrowser(String browser) {
		if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
			driver = getChromeDriver();
		} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
			driver = getFireFoxDriver();
		}
		return driver;
	}

	/**
	 * @Description: Method validates current Operating System and get Chrome driver
	 * 
	 * @return : ChromeDriver
	 */

	public WebDriver getChromeDriver() {
		if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOWS.name().toLowerCase())) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "/src/test/java/com/farnell/bdd_framework/resources/drivers/chromedriver.exe");
		} else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "/src/test/java/com/farnell/bdd_framework/resources/drivers/chromedriver");

		}

		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);

		return driver;
	}

	/**
	 * @Description: Method validates current Operating System and get FireFox
	 *               Driver
	 * 
	 * @return : FireFoxDriver
	 */

	public WebDriver getFireFoxDriver() {
		if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOWS.name().toLowerCase())) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
					+ "/src/test/java/com/farnell/bdd_framework/resources/drivers/geckodriver.exe");
		} else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
			System.setProperty("webdriver.firefox.marionette",
					System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
		}
		driver = new FirefoxDriver();

		return driver;
	}

	/**
	 * @Description Method to launch browsers with URL
	 * @param URL
	 */

	public void launchBrowser(String URL) {
		if (driver != null) {
			driver.manage().window().maximize();
			driver.get(URL);
			waitUtil.pause(3000);

		}
	}

	/**
	 * @Description Method to validate is given element is visible and intractable
	 * @param elem
	 * @return
	 */
	public boolean is_Element_Exist(WebElement elem) {

		boolean flag = false;
		try {
			if (elem != null)
				flag = (elem.isDisplayed() && elem.isEnabled()) ? true : false;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * @Description Method to validate is given element is clickable
	 * @param elem
	 */

	public void element_click(WebElement elem) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
			element.click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description Method to check the text box is intractable and enter input
	 * @param elem
	 * @param input
	 */
	public void enter_Text(WebElement elem, String input) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));

			element.clear();
			element.sendKeys(input);
			element.sendKeys(Keys.RETURN);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Description Method to get current page title
	 * @return
	 */
	public String get_title() {
		String title = driver.getTitle().trim();
		return title;
	}
}
