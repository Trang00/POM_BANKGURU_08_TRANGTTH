package com.bankguru.customer;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global;

import commons.AbstractTest;
import commons.Constansts;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;

public class Customer_01_NewCustomer extends AbstractTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;

	@Test
	public void TC_01_NameCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Name");
		newCustomerPage.inputNameText(Constansts.BLANK_SENKEY);
		
		log.info("Step 02: Press Tab");
		newCustomerPage.namePressTab();
	
		log.info("Step 03: Verify Name");
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Customer name must not be blank"), "Customer name must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_02_NameCannotNumeric(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in Name");
		newCustomerPage.inputNameText(Constansts.NUMBER_SENKEY);
		
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Numbers are not allowed"), "Numbers are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_03_NameCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Name");
		newCustomerPage.inputNameText(Constansts.SPECIAL_SENKEY);
		
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_04_NameCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Name");
		newCustomerPage.inputNameText(Constansts.FIRST_SPAGE_SENKEY);
		
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_05_AddressCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Address");
		newCustomerPage.inputAdressTextArea(Constansts.BLANK_SENKEY);
		
		log.info("Step 02: Press Tab");
		newCustomerPage.addressPressTab();
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Address Field must not be blank"), "Address Field must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_06_AddressCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Address");
		newCustomerPage.inputAdressTextArea(Constansts.FIRST_SPAGE_SENKEY);
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_07_AddressCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Address");
		newCustomerPage.inputAdressTextArea(Constansts.SPECIAL_SENKEY);
		
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_08_CityCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value City");
		newCustomerPage.inputCityText(Constansts.BLANK_SENKEY);
		
		log.info("Step 02: Press Tab");
		newCustomerPage.cityPressTab();
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "City Field must not be blank"), "City Field must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_09_CityCannotNumeric(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in City");
		newCustomerPage.inputCityText(Constansts.NUMBER_SENKEY);
		
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Numbers are not allowed"), "Numbers are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_10_CityCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in City");
		newCustomerPage.inputCityText(Constansts.SPECIAL_SENKEY);
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_11_CityCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in City");
		newCustomerPage.inputCityText(Constansts.FIRST_SPAGE_SENKEY);
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_12_StateCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value State");
		newCustomerPage.inputStateText(Constansts.BLANK_SENKEY);
		
		log.info("Step 02: Press Tab");
		newCustomerPage.statePressTab();
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "State must not be blank"), "State must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_13_StateCannotNumeric(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in State");
		newCustomerPage.inputStateText(Constansts.NUMBER_SENKEY);
			
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Numbers are not allowed"), "Numbers are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_14_StateCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in State");
		newCustomerPage.inputStateText(Constansts.SPECIAL_SENKEY);
		
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_15_StateCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in State");
		newCustomerPage.inputStateText(Constansts.FIRST_SPAGE_SENKEY);
				
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_16_PinIsNumeric(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Pin");
		newCustomerPage.inputPinText(Constansts.CHARACTER_SENKEY);
			
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_17_PinCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Pin");
		newCustomerPage.inputPinText(Constansts.BLANK_SENKEY);
		
		log.info("Step 02: Pin Press Tab");
		newCustomerPage.pinPressTab();
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "PIN Code must not be blank"), "PIN Code must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_18_PinHave6Digits(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in Pin");
		newCustomerPage.inputPinText(Constansts.NUMBER_MIN_SENKEY);
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "PIN Code must have 6 Digits"), "PIN Code must have 6 Digits");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Numeric value in Pin ");
		newCustomerPage.inputPinText(Constansts.NUMBER_MAX_SENKEY);
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "PIN Code must have 6 Digits"), "PIN Code must have 6 Digits");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_19_PinCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Pin");
		newCustomerPage.inputPinText(Constansts.SPECIAL_SENKEY);
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_20_PinCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Pin");
		newCustomerPage.inputPinText(Constansts.FIRST_SPAGE_SENKEY);

		verifyEquals(newCustomerPage.getNameDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_21_PinCannotHaveSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Pin");
		newCustomerPage.inputPinText(Constansts.NUMBER_SPAGE_SENKEY);
			
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_22_TelephoneCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Telephone");
		newCustomerPage.inputTelephoneText(Constansts.BLANK_SENKEY);
		
		log.info("Step 02: Press Tab");
		newCustomerPage.telephonePressTab();
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Mobile no must not be blank"), "Mobile no must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_23_TelephoneCannotHaveFirstCharacterBlankSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Telephone");
		newCustomerPage.inputTelephoneText(Constansts.FIRST_SPAGE_SENKEY);
				
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "First character can not have space"), "First character can not have space");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_24_TelephoneCannotHaveSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Telephone");
		newCustomerPage.inputTelephoneText(Constansts.NUMBER_SPAGE_SENKEY);
			
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_25_TelephoneCannotSpecialCharacter(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot Special Character value in Telephone");
		newCustomerPage.inputTelephoneText(Constansts.SPECIAL_SENKEY);
		
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Special characters are not allowed"), "Special characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_26_EmailCannotEmpty(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Do not enter a value Telephone");
		newCustomerPage.inputEmailText(Constansts.BLANK_SENKEY);
		
		log.info("Step 02: Press Tab");
		newCustomerPage.emailPressTab();
	
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Email-ID must not be blank"), "Email-ID must not be blank");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test
	public void TC_27_EmailMustCorrectFormat(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Email must be in correct format");
		newCustomerPage.inputEmailText(Constansts.EMAIL1_SENKEY);
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		newCustomerPage.inputEmailText(Constansts.EMAIL2_SENKEY);
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		newCustomerPage.inputEmailText(Constansts.EMAIL3_SENKEY);
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		newCustomerPage.inputEmailText(Constansts.EMAIL4_SENKEY);
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		newCustomerPage.inputEmailText(Constansts.EMAIL5_SENKEY);
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Email-ID is not valid"), "Email-ID is not valid");
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	//@Test 
	public void TC_29_EmailCannotHaveSpace(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Cannot have first Character Blank Space value in Email");
		newCustomerPage.inputEmailText(Constansts.NUMBER_SPAGE_SENKEY);
			
		verifyEquals(newCustomerPage.getNameDynamicText(driver, "Characters are not allowed"), "Characters are not allowed");
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	@Test 
	public void TC_30_VerifyFaileLabels(Method testMethod) {
		log.info("============== START: "+testMethod.getName()+" ============== ");
		
		log.info("Step 01: Verify Faile Label Customer Name");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Customer Name"),"Customer Name");
		
		log.info("Step 02: Verify Faile Label Gender");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Gender"),"Gender");
		
		log.info("Step 03: Verify Faile Label Date of Birth");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Date of Birth"),"Date of Birth");
		
		log.info("Step 04: Verify Faile Label Address");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Address"),"Address");
		
		log.info("Step 05: Verify Faile Label City");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "City"),"City");
		
		log.info("Step 06: Verify Faile Label State");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "State"),"State");
		
		log.info("Step 07: Verify Faile Label PIN");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "PIN"),"PIN");
		
		log.info("Step 08: Verify Faile Label Mobile Number");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Mobile Number"),"Mobile Number");
		
		log.info("Step 09: Verify Faile Label E-mail");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "E-mail"),"E-mail");
		
		log.info("Step 10: Verify Faile Label Password");
		verifyEquals(newCustomerPage.getLabelDynamicText(driver, "Password"),"Password");
		
		log.info("============== AND: "+testMethod.getName()+" ============== ");
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("============== START: LOGIN ============== ");
		driver=opentMultiBrowser(browserName);
		loginPage =PageFactoryManager.getLoginPage(driver);
		
		log.info("Step 01: Input data to UserID");
		loginPage.inputToUserIDTextbox(RegisterLogin_Global.USER_ID);
		
		log.info("Step 02: Input data to Password");
		loginPage.inputToPasswordTextbox(RegisterLogin_Global.PASSWORD);
		
		log.info("Step 03: Click to Submit button");
		homePage=loginPage.clickToLoginButton();
		
		log.info("Step 04: verify Home Page");
		verifyTrue(homePage.isHomePageDisplayed());
		
		log.info("============== AND: LOGIN ============== ");
		
		log.info("Step: Click New Customer");
		newCustomerPage=(NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());


	}
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
