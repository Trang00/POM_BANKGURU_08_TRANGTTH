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
	public LiveHomePageObject openHomePage(String HomePageUrl) {
		openURL(driver, HomePageUrl);
		return LivePageFactoryManager.getHomePageLive(driver);
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
	public void clickCheckboxTableReview(WebDriver driver) {
		waitForControlVisible(driver, LiveAdminUI.TABLE_CHECK_PENDING_REVIEW);
		clickToElement(driver, LiveAdminUI.TABLE_CHECK_PENDING_REVIEW);
	}
	public void clickEditTableReview(WebDriver driver) {
		waitForControlVisible(driver, LiveAdminUI.TABLE_EDIT_PENDING_REVIEW);
		clickToElement(driver, LiveAdminUI.TABLE_EDIT_PENDING_REVIEW);
	}
	public void clickButtonSaveReview(WebDriver driver) {
		waitForControlVisible(driver, LiveAdminUI.BUTTON_SAVE_REVIEW);
		clickToElement(driver, LiveAdminUI.BUTTON_SAVE_REVIEW);
	}
	
	
}
