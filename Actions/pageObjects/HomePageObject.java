package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	public HomePageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public boolean isHomePageDisplayed() {
		waitForControlVisible(driver,HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}
}
