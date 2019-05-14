package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constansts;
import pageUIs.EditCustomerPageUI;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isNewCustomerPageDisplayed() {
		waitForControlVisible(driver,NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}
	public boolean isHomePageUnDisplayed() {
		waitForControlNotVisible(driver,HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlUndisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}
	
	public boolean isAddCustomerFormUndisplayed() {
		waitForControlNotVisible(driver, NewCustomerPageUI.CUSTOMER_FORM);
		return isControlUndisplayed(driver, NewCustomerPageUI.CUSTOMER_FORM);
	}
	
	public boolean isNewCustomerSuccessfullyPageDisplayed() {
		waitForControlVisible(driver,NewCustomerPageUI.NEW_CUSTOMER_SUCCESSFULLY_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_SUCCESSFULLY_TEXT);
	}
	public  void inputAdressTextArea() {
		waitForControlVisible(driver, NewCustomerPageUI.ADDRESS_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.ADDRESS_SENKEY, Constansts.ADDRESS_SENKEY);
	}
	public  void inputDateOfBirthText() {
		waitForControlVisible(driver, NewCustomerPageUI.DATEOFBIRTH_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.DATEOFBIRTH_SENKEY, Constansts.DATEOFBIRTH_SENKEY);
	}
	public  void inputCityText() {
		waitForControlVisible(driver, NewCustomerPageUI.CITY_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.CITY_SENKEY, Constansts.CITY_SENKEY);
	}
	public  void inputStateText() {
		waitForControlVisible(driver, NewCustomerPageUI.STATE_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.STATE_SENKEY, Constansts.STATE_SENKEY);
	}
	public  void inputPinText() {
		waitForControlVisible(driver, NewCustomerPageUI.PIN_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.PIN_SENKEY, Constansts.PIN_SENKEY);
	}
	public  void inputMobileText() {
		waitForControlVisible(driver, NewCustomerPageUI.MOBILE_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.MOBILE_SENKEY, Constansts.MOBILE_SENKEY);
	}
	public  void inputEmailText(String email) {
		waitForControlVisible(driver, NewCustomerPageUI.EMAIL_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.EMAIL_SENKEY, email);
	}
	public  void inputPasswordText() {
		waitForControlVisible(driver, NewCustomerPageUI.PASSWORD_SENKEY);
		senkeyToElement(driver, NewCustomerPageUI.PASSWORD_SENKEY, Constansts.PASSWORD_SENKEY);
	}
	
	public  void clicksubmitButton() {
		waitForControlVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElementByJS(driver,NewCustomerPageUI.SUBMIT_BUTTON);
	}
	public String getCustomerIDText() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_NAME_TEXT);
		return getTextInElement(driver, EditCustomerPageUI.EDIT_CUSTOMER_NAME_TEXT);
	}

}
