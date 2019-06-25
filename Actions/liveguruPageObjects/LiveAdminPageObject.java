package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageUIs.AbstractLivePageUI;
import liveguruPageUIs.LiveAdminUI;

public class LiveAdminPageObject extends AbstractPage{
	WebDriver driver;
	public LiveAdminPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public void clickLogin(WebDriver driver) {
		waitForControlVisible(driver, LiveAdminUI.BUTTON_LOGIN);
		clickToElementByJS(driver, LiveAdminUI.BUTTON_LOGIN);
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
