package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;

public class BaseClass {
	
	public static WebDriver wd;
	
	@BeforeSuite
	public void databaseConnect() {
	Reporter.log("Database Connected",true);
	}
	
	
	@BeforeClass
	public void launchBrowser() {
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wd.navigate().to("https://demo.actitime.com/login.do");
		Reporter.log("browser launched succesfully",true);
	}
	
	@BeforeMethod
	public void Login() throws IOException {
		LoginPage lp = new LoginPage(wd);
		FileLibrary fl = new FileLibrary();
		String User = fl.readDataFromProperty("Username");
		lp.getUntxt().sendKeys(User);
		String Pass = fl.readDataFromProperty("Password");
		lp.getPassTxt().sendKeys(Pass);
		lp.getButton().click();
		Reporter.log("Login done successfully",true);
	}
	
	@AfterMethod
	public void Logout() {	
		HomePage hp = new HomePage(wd);
		hp.getLogOut().click();
		Reporter.log("Logout done successfully",true);
	}
	
	
	
	@AfterClass
	public void closeBrowser() {
		wd.close();
		Reporter.log("Browser closed succesfully",true);
	}
	
	
	
	@AfterSuite
	public void databaseDisconnect() {
		Reporter.log("Database Disconnected",true);
	}	
}
