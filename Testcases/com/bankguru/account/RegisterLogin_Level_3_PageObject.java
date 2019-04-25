package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level_3_PageObject extends AbstractTest {
	private WebDriver driver;
	private AbstractPage abstractPage;
	private String email, UserID, password, LoginURL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	@Test
	public void TC_01_RegisterToSystem() {
		LoginURL =loginPage.getLoginPageUrl();
		loginPage.clickToHereLink();
		
		registerPage=new RegisterPageObject(driver);
		
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		UserID=registerPage.getUserIDText();
		password=registerPage.getPasswordText();
		
		

	}

	@Test
	public void TC_02_LoginWithAboveInformation() {
		registerPage.openLoginPage(LoginURL);
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToUserIDTextbox(UserID);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage=new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed());
		
		
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver=opentMultiBrowser(browserName);
		email = "seleniumonline" + randomNumber() + "@gmail.com";

		loginPage = new LoginPageObject(driver);
		
	}
	public int randomNumber() {
		  Random random= new Random();
		  int number=random.nextInt(999);
		  return number;
	  }
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
