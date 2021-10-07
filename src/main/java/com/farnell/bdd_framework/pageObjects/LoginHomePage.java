package com.farnell.bdd_framework.pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.farnell.bdd_framework.helper.WaitUtil;
import com.farnell.bdd_framework.helper.WebDriverUtil;

public class LoginHomePage {

	WebDriver driver;
	static WebDriverUtil webUtil = new WebDriverUtil();
	WaitUtil waitUtil = new WaitUtil();

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement btn_Accept_All_Cookies;

	@FindBy(id = "enhanceGeoCancelButton")
	public WebElement btn_Geo_Cancel;

	@FindBy(id = "enhanceGeoContinueButton")
	public WebElement btn_Geo_Continue;

	@FindBy(id = "geoRememberMe")
	public WebElement chkBox_Remember_Geo;

	@FindBy(linkText = "Register")
	public WebElement link_Register;

	@FindBy(id = "logonId")
	public WebElement txtBox_UserName;

	@FindBy(id = "logonPassword")
	public WebElement txtBox_Password;

	@FindBy(id = "firstName")
	public WebElement txtBox_FullName;

	@FindBy(id = "email1")
	public WebElement txtBox_Email;

	@FindBy(xpath = "//span[contains(text(), 'Remember me')]")
	public WebElement chkBox_RememberMe_Register;

	@FindBy(id = "registerValidate")
	public WebElement btn_Register_Validate;

	// Page Operations are written below

	public LoginHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void click_Accept_Cookies() {
		webUtil.element_click(btn_Accept_All_Cookies);
		waitUtil.pause(2000);

	}

	public void click_Cancel_Geo_Location() {
		webUtil.element_click(btn_Geo_Cancel);
	}

	public void click_Register_link() {
		webUtil.element_click(link_Register);
		waitUtil.pause(2000);
	}

	public boolean get_Home_Page_Title() {
		String titleHomePage = "Farnell UK - Electronic Components Distributor";
		return (webUtil.get_title().equals(titleHomePage.trim())) ? true : false;
	}

	public void enter_UserName_Password(String userName, String password) {
		try {
			webUtil.enter_Text(txtBox_UserName, userName);
			waitUtil.pause(2000);
			webUtil.enter_Text(txtBox_Password, password);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	public void enter_FullName_Email(String fullName, String email) {
		try {

			webUtil.enter_Text(txtBox_FullName, fullName);
			waitUtil.pause(2000);
			webUtil.enter_Text(txtBox_Email, email);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void click_Register_Validate_Button() {
		webUtil.element_click(btn_Register_Validate);
		waitUtil.pause(2000);
	}
	
	public void validate_User_Registration() {
		System.out.println("Validate User Registration");
	}

}