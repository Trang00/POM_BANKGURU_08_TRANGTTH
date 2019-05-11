package bankguru.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import bsh.This;
import commons.AbstractPage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;
import pageUIs.LoginPageUI;

public class LoginPageFactory extends AbstractPage {
	private WebDriver driver;
	
	@FindBy(how= How.XPATH, using="//form[@name='frmLogin']")
	private WebElement loginForm;
	
	@FindBy(how= How.NAME, using="uid")
	private WebElement userIDtextbox;
	
	@FindBy(how= How.NAME, using="password")
	private WebElement passwordtextbox;
	
	@FindBy(how= How.CSS, using="//input[@name='btnLogin']")
	private WebElement loginButton;
	
	@FindBy(how= How.XPATH, using="//a[text()='here']")
	private WebElement hereLink;
	
	public LoginPageFactory(WebDriver mappingDriver) {
		this.driver=mappingDriver;
		PageFactory.initElements(driver, this.getClass());
	}
	public String getLoginPageUrl() {
		return getCurrenUrl(driver);
	}
	
	public LoginPageObject openLoginPage(String loginPageUrl) {
		openURL(driver, loginPageUrl);
		return new LoginPageObject(driver);
		//return PageFactoryManager.getLoginPage(driver);
	}
	public void inputToUserIDTextbox(String userID) {
		waitForControlVisible(driver, LoginPageUI.USERID_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userID);
	}
	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public HomePageObject clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.getHomePage(driver);
	}
	public RegisterPageObject clickToHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return new RegisterPageObject(driver);
		//return PageFactoryManager.getRegisterPage(driver);
	}
	

}
