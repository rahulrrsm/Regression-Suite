package org.stepdefinition;

import java.awt.AWTException;

import org.baseclass.BC;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pojo.LoginPojo;

import io.cucumber.java.en.*;

public class LoginPageSteps extends BC {
	public LoginPojo e;

	@Given("user has to launch chrome and enter fb url")
	public void user_has_to_launch_chrome_and_enter_fb_url() {
		getDriver("chrome", "https://www.facebook.com/");
	}

	@When("user has to enter the username and password")
	public void user_has_to_enter_the_username_and_password() {
		e = new LoginPojo();
		type(e.getUserName(), "rahulrrsm@gmail.com");
		type(e.getPassword(), "RRsm@123");

	}

	@When("click the login button")
	public void click_the_login_button() throws Throwable {
		e = new LoginPojo();
		btnClick(e.getLogin());

	}

	@Then("user able to view the home page")
	public void user_able_to_view_the_home_page() {
		e = new LoginPojo();
		dynamicWait1(20);
		Assert.assertTrue("check the login page", e.getContacts().getText().contains("Contacts"));
		btnClick(e.getAccount());
		btnClick(e.getLogout());
		
	}

}
