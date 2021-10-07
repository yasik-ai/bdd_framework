package com.farnell.bdd_framework.stepDefinitions;

import org.junit.Assert;
import com.farnell.bdd_framework.helper.WebDriverUtil;
import com.farnell.bdd_framework.pageObjects.LoginHomePage;
import com.farnell.bdd_framework.testBase.TestBase;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginHomePageSteps extends TestBase {

	LoginHomePage loginPage = new LoginHomePage(driver);
	WebDriverUtil webUtil = new WebDriverUtil();

	@Given("^User launch browser and navigate to Farnell \"([^\"]*)\" site$")
	public void user_launch_browser_to_navigate_farnell_sites(String url) throws Throwable {
		webUtil.launchBrowser(url);

	}

	@When("^User verify and accepts cookies on the page$")
	public void user_verify_and_accepts_cookies_on_the_page() throws Throwable {
		loginPage.click_Accept_Cookies();

	}

	@Then("^User landed on Farnell Home Page$")
	public void user_landed_on_Farnell_Home_Page() throws Throwable {
		Assert.assertEquals(true, loginPage.get_Home_Page_Title());

	}

	@Given("^User clicks on Register button on home page$")
	public void user_clicks_on_Register_button_on_home_page() throws Throwable {
		loginPage.click_Register_link();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" on register page$")
	public void user_enters_username_and_password_register_page(String userName, String password) throws Throwable {
		loginPage.enter_UserName_Password(userName, password);
	}

	@When("^User clicks on Register button$")
	public void user_clicks_on_Register_button() throws Throwable {
		loginPage.click_Register_Validate_Button();
	}

	@Then("^User should register successfully on Farnell application$")
	public void user_should_register_successfully_on_Farnell_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("User clicks Login button and navigates to Login page")
	public void user_clicks_login_button_and_navigates_to_login_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should get error message for {string} and {string} fields")
	public void user_should_get_error_message_for_and_fields(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User selects {string} checkbox and clicks login button")
	public void user_selects_checkbox_and_clicks_login_button(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should login successfully to the Farnell site and navigate to account summary")
	public void user_should_login_successfully_to_the_farnell_site_and_navigate_to_account_summary() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User should logout from Farnell site and retry login")
	public void user_should_logout_from_farnell_site_and_retry_login() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User validates {string} auto populate username {string} feature")
	public void user_validates_auto_populate_username_feature(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should login to the Farnell site and navigate to user accounts summary")
	public void user_should_login_to_the_farnell_site_and_navigate_to_user_accounts_summary() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should logout from Farnell site")
	public void user_should_logout_from_farnell_site() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
