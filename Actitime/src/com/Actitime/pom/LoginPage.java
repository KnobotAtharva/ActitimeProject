package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class LoginPage {

	public WebElement getUntxt() {
		return Untxt;
	}

	public WebElement getPassTxt() {
		return PassTxt;
	}

	public WebElement getCheckbox() {
		return Checkbox;
	}

	public WebElement getButton() {
		return Button;
	}

	public WebElement getForgotPassLink() {
		return ForgotPassLink;
	}

	public WebElement getLink() {
		return link;
	}

	@FindBy(id="username")
	private WebElement Untxt;
	
	@FindBy(name="pwd")
	private WebElement PassTxt;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement Checkbox;
	
	@FindBy(id="loginButton")
	private WebElement Button;
	
	@FindBy(partialLinkText = "Forgot your password?")
	private WebElement ForgotPassLink;
	
	@FindBy(partialLinkText = "actiTIME Inc.")
	private WebElement link;
	
	
	public LoginPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	
}
