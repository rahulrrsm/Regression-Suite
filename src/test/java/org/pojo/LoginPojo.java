package org.pojo;

import org.baseclass.BC;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BC {
	
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement userName;
	@FindBy(id="pass")
	private WebElement password;
	@FindBy(name="login")
	private WebElement login;
	@FindBy(xpath="//*[text()='Contacts']")
	private WebElement contacts;
	@FindBy(xpath="//*[@aria-label='Account']")
	private WebElement account;
	@FindBy(xpath="//*[@data-nocookies='true']")
	private WebElement logout;
	
	
	public WebElement getAccount() {
		return account;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getContacts() {
		return contacts;
	}
	
	

	

}
