package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageUIs.AbstractLivePageUI;
import liveguruPageUIs.LiveHomePageUI;
import pageUIs.AbstractPageUI;

public class LiveHomePageObject extends AbstractPage{
	WebDriver driver;
	public LiveHomePageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	public void clickAccountMenu() {
		waitForControlVisible(driver, LiveHomePageUI.ACCOUNT_MENU_HEADER);
		clickToElement(driver, LiveHomePageUI.ACCOUNT_MENU_HEADER);
	
	}
	public LiveRegisterPageObject clickRegisterMenu() {
		waitForControlVisible(driver, LiveHomePageUI.REGISTER_MENU_HEADER);
		clickToElement(driver, LiveHomePageUI.REGISTER_MENU_HEADER);
		return new LiveRegisterPageObject(driver);
	}
	public LiveMyAccountPageObject clickMyAccountMenu() {
		waitForControlVisible(driver, LiveHomePageUI.MYACCOUNT_MENU_FOOTER);
		clickToElement(driver, LiveHomePageUI.MYACCOUNT_MENU_FOOTER);
		return new LiveMyAccountPageObject(driver);
	}
	public String getDiscountLive() {
		waitForControlVisible(driver, LiveHomePageUI.DISCOUNT);
		return getTextInElement(driver, LiveHomePageUI.DISCOUNT);
	}
	
	public String getGrandTotalLive() {
		waitForControlVisible(driver, LiveHomePageUI.GRAND_TOTAL);
		return getTextInElement(driver, LiveHomePageUI.GRAND_TOTAL);
	}
	public String getMsgErrorQTYLive() {
		waitForControlVisible(driver, LiveHomePageUI.MSG_ERROR_QTY);
		return getTextInElement(driver, LiveHomePageUI.MSG_ERROR_QTY);
	}
	public String getEmptyCartLive() {
		waitForControlVisible(driver, LiveHomePageUI.VERIFY_EMPTY_CART);
		return getTextInElement(driver, LiveHomePageUI.VERIFY_EMPTY_CART);
	}
	
	public boolean isTextWishListDisplayed() {
		waitForControlVisible(driver, LiveHomePageUI.MSG_WISHLIT);
		return isControlDisplayed(driver, LiveHomePageUI.MSG_WISHLIT);
	}
	
	
	
}
