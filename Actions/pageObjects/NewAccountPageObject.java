package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;
import pageUIs.NewAccountPageUI;
import pageUIs.NewCustomerPageUI;

public class NewAccountPageObject extends AbstractPage{
	WebDriver driver;
	public NewAccountPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isNewAccountPageDisplayed() {
		waitForControlVisible(driver,NewAccountPageUI.NEW_ACCOUNT_TEXT);
		return isControlDisplayed(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
	}
	
}
