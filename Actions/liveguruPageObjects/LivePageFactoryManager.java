package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import liveguruPageObjects.LiveRegisterPageObject;

public class LivePageFactoryManager {

	public static LiveRegisterPageObject getRegisterLivePage(WebDriver driver) {
		return new LiveRegisterPageObject(driver);
	}
	
	public static LiveHomePageObject getHomePageLive(WebDriver driver) {
		return new LiveHomePageObject(driver);
	}
	
	public static LiveMyAccountPageObject getMyAccountPageLive(WebDriver driver) {
		return new LiveMyAccountPageObject(driver);
	}
	
}
