package com.bankguru.account;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.DepositPageObject;
import pageObjects.FundTransterPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level_10_DynamicPageObject_PageElement_PageUI extends AbstractTest {
	private WebDriver driver;
	private String email, UserID, passwordID, LoginURL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private String customerName, gender, dateOfBirth, address, city, state, pin, phone,password;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransterPageObject fundTransferPage;
	public static String CUSTOMER_ID;
	
	@Test(description="TC_01_Register to System ")
	public void TC_01_RegisterToSystem() {
		LoginURL =loginPage.getLoginPageUrl();
		registerPage=loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		UserID=registerPage.getUserIDText();
		passwordID=registerPage.getPasswordText();
	}

	@Test(description ="TC_02Login to system")
	public void TC_02_LoginWithAboveInformation() {
		loginPage=registerPage.openLoginPage(LoginURL);
		loginPage.inputToUserIDTextbox(UserID);
		loginPage.inputToPasswordTextbox(passwordID);
		homePage=loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	@Test(description="TC_03_ New Customer")
	public void TC_03_DynamicPageObjectPageElementPageUI(Method testMethod) {
		newCustomerPage=(NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		verifyTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		log.info("============== START: "+testMethod.getName()+" ============== ");
		log.info("Step 01: Enter valid Customer Name");
		newCustomerPage.inputDynamicText(driver, customerName, "name");
		log.info("Step 02: Enter valid  Date of birth");
		newCustomerPage.inputDynamicText(driver, dateOfBirth, "dob");
		log.info("Step 01: Enter valid Address");
		newCustomerPage.inputDynamicTextArea(driver, address, "addr");
		log.info("Step 01: Enter valid city");
		newCustomerPage.inputDynamicText(driver, city, "city");
		log.info("Step 01: Enter valid State");
		newCustomerPage.inputDynamicText(driver,state, "state");
		log.info("Step 01: Enter valid PIN");
		newCustomerPage.inputDynamicText(driver,pin, "pinno");
		log.info("Step 01: Enter valid Mobile");
		newCustomerPage.inputDynamicText(driver, phone, "telephoneno");
		log.info("Step 01: Enter valid Email");
		newCustomerPage.inputDynamicText(driver, RegisterLogin_Global.EMAIL, "emailid");
		log.info("Step 01: Enter valid Password");
		newCustomerPage.inputDynamicText(driver, password, "password");
		log.info("Step 01: Click button submit");
		newCustomerPage.clickDynamicSubmit(driver, "sub");
		log.info("Step 01: Verify successfully new Customer");
		verifyTrue(newCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Customer Registered Successfully!!!"));
		CUSTOMER_ID=newCustomerPage.getDynamicTextDisplayed(driver, "Customer ID");
		log.info("CUSTOMER_ID : "+CUSTOMER_ID);
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}

	public void TC_04_OpenDynamicCheckPageDisplayed() {
		//NewCustomer > newAccount > Depsit > FundTransfer > homepage > newAccount
		
				newCustomerPage=(NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
				verifyTrue(newCustomerPage.isDynamicSuccessfullyPageDisplayed(driver, "Add New Customer"));
			
				
				newAccountPage=(NewAccountPageObject) newCustomerPage.openDynamicPage(driver, "New Account");
				verifyTrue(newAccountPage.isDynamicSuccessfullyPageDisplayed(driver, "Add new account form"));
			
				depositPage=(DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
				verifyTrue(depositPage.isDynamicSuccessfullyPageDisplayed(driver, "Amount Deposit Form"));

				fundTransferPage=(FundTransterPageObject) depositPage.openDynamicPage(driver, "Fund Transfer");
				verifyTrue(fundTransferPage.isDynamicSuccessfullyPageDisplayed(driver, "Fund transfer"));
			
	}
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver=opentMultiBrowser(browserName);
		email = "seleniumonline" + randomNumber() + "@gmail.com";
		loginPage =PageFactoryManager.getLoginPage(driver);
		
		customerName ="Selenium Online"; 
		gender ="f"; 
		dateOfBirth ="01/01/2000"; 
		address ="258 Le Duan"; 
		city ="Sai Gon"; 
		state =" Thu Duwc"; 
		pin ="258435"; 
		phone ="0163245987";
		password="123456";
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
