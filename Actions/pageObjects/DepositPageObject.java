package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;
import pageUIs.NewAccountPageUI;

public class DepositPageObject extends AbstractPage{
	WebDriver driver;
	public DepositPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isNewDepositPageDisplayed() {
		waitForControlVisible(driver,DepositPageUI.DEPOSIT_TEXT);
		return isControlDisplayed(driver, DepositPageUI.DEPOSIT_TEXT);
	}
	
}
