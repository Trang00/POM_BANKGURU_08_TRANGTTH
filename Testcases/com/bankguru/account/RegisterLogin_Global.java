package com.bankguru.account;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Global extends AbstractTest {
	private WebDriver driver;
	//private String email;
	public static String USER_ID, PASSWORD,EMAIL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;



	@Test
	public void TC_01_RegisterToSystem(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("TC_01 - Step 01: Click to hete link");
		registerPage=loginPage.clickToHereLink();
		
		log.info("TC_01 - Step 02: Input data to Email textbox");
		registerPage.inputToEmailIDTextbox(EMAIL);
		
		log.info("TC_01 - Step 03: Click to Submit button");
		registerPage.clickToSubmitButton();
		
		log.info("TC_01 - Step 04: Get User/ Pass information");
		
		USER_ID=registerPage.getUserIDText();
		log.info("USER_ID:  "+ USER_ID);
	
		PASSWORD=registerPage.getPasswordText();
		log.info("PASSWORD:  "+ PASSWORD);
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver=opentMultiBrowser(browserName);
		EMAIL = "seleniumonline" + randomNumber() + "@gmail.com";
		
		loginPage =PageFactoryManager.getLoginPage(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
