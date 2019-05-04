package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;
import pageUIs.FundTransterPageUI;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class FundTransterPageObject extends AbstractPage{
	WebDriver driver;
	public FundTransterPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isFundTransferDisplayed() {
		waitForControlVisible(driver,FundTransterPageUI.FUND_TRANSFER_TEXT);
		return isControlDisplayed(driver, FundTransterPageUI.FUND_TRANSFER_TEXT);
	}
}
