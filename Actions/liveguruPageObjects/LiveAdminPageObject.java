package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageUIs.AbstractLivePageUI;
import liveguruPageUIs.LiveAdminUI;
import liveguruPageUIs.LiveHomePageUI;
import liveguruPageUIs.LiveMyAccountUI;
import pageUIs.HomePageUI;

public class LiveAdminPageObject extends AbstractPage{
	WebDriver driver;
	public LiveAdminPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public void clickCloseIncomingMessage(WebDriver driver) {
		waitForControlVisible(driver, AbstractLivePageUI.DYNAMIC_VERIFY_TEXT);
		clickToElementByJS(driver, AbstractLivePageUI.DYNAMIC_VERIFY_TEXT);
	}
	public void clickCheckboxOrder2(WebDriver driver) {
		waitForControlVisible(driver, LiveAdminUI.CHECKBOX_ORDER_2);
		clickToElementByJS(driver, LiveAdminUI.CHECKBOX_ORDER_2);
	}
	
	
}
