package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constansts;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransterPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class PaymentFunction extends AbstractTest {
	private WebDriver driver;
		private AbstractPage abstractPage;
	private String email, userID, password, loginURL,customerID;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransterPageObject fundTransferPage;
	
	@Test
	public void TC_01_NewCustomer() {
		
		newCustomerPage=(NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		newCustomerPage.senkeyDynamicPage(driver, "name");
		newCustomerPage.inputDateOfBirthText();
		newCustomerPage.inputAdressTextArea();
		newCustomerPage.inputCityText();
		newCustomerPage.inputStateText();
		newCustomerPage.inputPinText();
		newCustomerPage.inputMobileText();
		newCustomerPage.inputEmailText(email);
		newCustomerPage.inputPasswordText();
		newCustomerPage.clicksubmitButton();
		Assert.assertTrue(newCustomerPage.isNewCustomerSuccessfullyPageDisplayed());
		customerID=newCustomerPage.getCustomerIDText();
	}
	@Test
	public void TC_02_EditCustomerAndCheckSuccessfully() {
		editCustomerPage=(EditCustomerPageObject) newCustomerPage.openDynamicPage(driver, "Edit Customer");
		Assert.assertTrue(editCustomerPage.isEditCustomerPageDisplayed());
		
		editCustomerPage.inputCustomerIDText(customerID);
		editCustomerPage.clickCustomerIDSubmit();
		
		editCustomerPage.inputEditAdressTextArea();
		editCustomerPage.inputEditCityText();
		editCustomerPage.inputEditStateText();
		editCustomerPage.inputEditMobileText();
		editCustomerPage.inputEditEmailText(email);
		editCustomerPage.clickCustomerIDSubmit();
		Assert.assertTrue(editCustomerPage.isEditCustomerSuccessfullyPageDisplayed());
	}
	@Test
	public void TC_03_NewAccountAndCheckSuccessfullyThenCurrentAmountEqualInitialDeposit() {
		newAccountPage=(NewAccountPageObject) editCustomerPage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
		
		newAccountPage.inputCustomerID(customerID);
		newAccountPage.inputAccountType();
		newAccountPage.inpuInitialDeposit();
		newAccountPage.clickNewAccountSubmit();
		
		newAccountPage.isNewAccountSuccessefullyPageDisplayed();
		newAccountPage.isCurrentAmountPageDisplayed();
		Assert.assertEquals(newAccountPage.getCurrentAmount(), Constansts.INITIAL_DEPOSIT_SENKEY);
	}
	@Test
	public void TC_04_TransferAndCheck() {
		
	}
	
	@Test
	public void TC_05_WithdrawAndCheck() {
		
	}
	@Test
	public void TC_06_TransferIntoAnotherAccountAndCheck() {
		
	}
	@Test
	public void TC_07_CheckBalance() {
		
	}
	@Test
	public void TC_08_DeleteAllAccountAndCheck() {
		
	}
	@Test
	public void TC_09_DeleteExistCustomerAccountAndCheck() {
		
	}
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver=opentMultiBrowser(browserName);
		
		email = "seleniumonline" + randomNumber() + "@gmail.com";
		loginPage =PageFactoryManager.getLoginPage(driver);
		
		loginURL =loginPage.getLoginPageUrl();
	
		loginPage=loginPage.openLoginPage(loginURL);
		loginPage.inputToUserIDTextbox(Constansts.USER);
		loginPage.inputToPasswordTextbox(Constansts.PASS);
		homePage=loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
