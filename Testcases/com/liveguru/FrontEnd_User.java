package com.liveguru;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constansts;
import liveguruPageObjects.LiveHomePageObject;
import liveguruPageObjects.LiveMyAccountPageObject;
import liveguruPageObjects.LiveMyWishListPageObject;
import liveguruPageObjects.LivePageFactoryManager;
import liveguruPageObjects.LiveRegisterPageObject;
import liveguruPageUIs.AbstractLivePageUI;
import pageObjects.PageFactoryManager;

public class FrontEnd_User extends AbstractTest {
	private WebDriver driver;
	public static String EMAIL;
	
	private LiveHomePageObject liveHomePage;
	private LiveRegisterPageObject liveRegisterPage;
	private LiveMyAccountPageObject liveMyAccountPage;
	private LiveMyWishListPageObject liveMyWishListPage;
	private String firstName, middleName, lastName, password, confirmPass, fullName;

	@Test
	public void TC_01_Register(Method testMethod) {

		log.info("============== START: " + testMethod.getName() + " ============== ");
		
		log.info("Step 1: Click ACCOUNT menu");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		liveHomePage.clickAccountMenu();

		log.info("Step 2: Choose Register link");
		liveRegisterPage=liveHomePage.clickRegisterMenu();

		log.info("Step 3: Input data");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, firstName, "firstname");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, middleName, "middlename");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, lastName, "lastname");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, EMAIL, "email");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, password, "password");
		liveRegisterPage.inputDynamicTextBoxTextArea(driver, confirmPass, "confirmation");

		log.info("Step 4: Click button REGISTER");
		liveRegisterPage.clickDynamicButton(driver, "Register");

		log.info("Step 5: Verify text displayed after register successelly");
		verifyEquals(liveRegisterPage.getDynamicTextDisplayedLive(driver,"Thank you for registering with Main Website Store."),"Thank you for registering with Main Website Store.");

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	public void TC_02_VerifyUser(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click MY ACCOUNT ");
		liveMyAccountPage=liveHomePage.clickMyAccountMenu();
		
		log.info("Step 3: Verify user information displayed");
		String VerifyMyAccount=liveMyAccountPage.getTextDisplayedVerifyMyAccountLive(driver);
		verifyTrue(VerifyMyAccount.contains(fullName) && VerifyMyAccount.contains(EMAIL));
		
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	public void TC_03_VerifyCostProduct(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu Mobile");
		liveHomePage.clickDynamicLink(driver, "Mobile");
		
		log.info("Step 3: Get cost Sony Xperia");
		String CostList=liveHomePage.getDynamicCostListLive(driver, "Sony Xperia");
		
		log.info("Step 4: Click detail");
		liveHomePage.clickDynamicLink(driver, "Sony Xperia");
		
		log.info("Step 5: Get cost detail");
		String CostDetail=liveHomePage.getDynamicCostDetailLive(driver, "price");
		
		verifyTrue(CostList.contains("$100")&&CostDetail.contains("$100"));

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	public void TC_04_DiscountCoupon(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu Mobile");
		liveHomePage.clickDynamicLink(driver, "Mobile");
		
		log.info("Step 3: Add Iphone to cart ");
		liveHomePage.clickDynamicAddToCart(driver, "IPhone");
		
		log.info("Step 4: Verify ");
		liveHomePage.getDynamicTextDisplayedLive(driver, "IPhone was added to your shopping cart.");
		
		log.info("Step 5: Input Discount codes ");
		liveHomePage.inputDynamicTextBoxTextArea(driver, "GURU50", "coupon_code");
		
		log.info("Step 6: Click button apply ");
		liveHomePage.clickDynamicButton(driver, "Apply");
		
		log.info("Step 7: Verify Discount and Grand total");
		verifyEquals(liveHomePage.getDiscountLive(), "-$25.00");
		verifyEquals(liveHomePage.getGrandTotalLive(), "$500.00");///
		
		
		liveHomePage.clickDynamicButton(driver, "Empty Cart");// phuc vu cho TC 5

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	// Chết ko hiển thị button Update
	public void TC_05_VerifyCannotAddMore500Items(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu Mobile");
		liveHomePage.clickDynamicLink(driver, "Mobile");
		
		log.info("Step 3: Add Iphone to cart ");
		liveHomePage.clickDynamicAddToCart(driver, "Sony Xperia");
		
		log.info("Step 4: Verify ");
		liveHomePage.getDynamicTextDisplayedLive(driver, "Sony Xperia was added to your shopping cart.");
		
		log.info("Step 5: Input QTY value 501 ");
		//liveHomePage.sendKeyboardToElement(driver, AbstractLivePageUI.QTY_TEXTBOX, Keys.TAB);
		liveHomePage.inputDynamicTextBoxQTY(driver, "501", "Sony Xperia");
		
		log.info("Step 6:Click button Update ");
		liveHomePage.clickDynamicButton(driver, "Update");
		
		log.info("Step 7:Verify Message error ");
		verifyEquals(liveHomePage.getMsgErrorQTYLive(),"* The maximum quantity allowed for purchase is 500. ");
		
		log.info("Step 8: Click link Empty cart");
		liveHomePage.clickDynamicButton(driver, "Empty Cart");
		
		log.info("Step 9: Verify Empty cart");
		verifyEquals(liveHomePage.getEmptyCartLive(),"SHOPPING CART IS EMPTY");

		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}

	public void TC_06_VerifyCompareTwoProduct(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu Mobile");
		liveHomePage.clickDynamicLink(driver, "Mobile");
		
		log.info("Step 3: Add to compare Sony Xperia ");
		liveHomePage.clickDynamicCompare(driver, "Sony Xperia");
		verifyEquals(liveHomePage.getDynamicTextDisplayedLive(driver, "The product Sony Xperia has been added to comparison list."),"The product Sony Xperia has been added to comparison list.");
	
		log.info("Step 4: Add to compare IPhone ");
		liveHomePage.clickDynamicCompare(driver, "IPhone");
		verifyEquals(liveHomePage.getDynamicTextDisplayedLive(driver, "The product IPhone has been added to comparison list."),"The product IPhone has been added to comparison list.");
		
		log.info("Step 5: Click Compare ");
		String parentWindow = driver.getWindowHandle();
		liveHomePage.clickDynamicButton(driver, "Compare");
		
		log.info("Step 6: Verify Pop- up Window");
		
		liveHomePage.switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
		verifyEquals(liveHomePage.getDynamicTextH1Live(driver, "Compare Products"),"COMPARE PRODUCTS");
		
		liveHomePage.closeAllWithoutParentWindows(driver, parentWindow);
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_07_ShareWishlist(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu TV");
		liveHomePage.clickDynamicLink(driver, "TV");
		
		log.info("Step 3: Add LG LCD product your wishlist and Msg display");
		liveHomePage.clickDynamicWishList(driver, "LG LCD");
		
		verifyTrue(liveHomePage.isTextWishListDisplayed());
		
		log.info("Step 4: Click button Share Wishlist ");
		liveHomePage.clickDynamicButton(driver, "Share Wishlist");
		
		log.info("Step 5: Input Email and msg ");////////////////////////////
		liveHomePage.inputDynamicTextBoxTextArea(driver, "TrangHC0938@gmail.com", "email_address");
		
		liveHomePage.inputDynamicTextBoxTextArea(driver, "Message WishList", "message");
		
		
		log.info("Step 6: Click button Share Wishlist ");
		liveHomePage.clickDynamicButton(driver, "Share Wishlist");
		
		verifyTrue(liveHomePage.isTextWishListDisplayed());
		
		liveMyWishListPage=(LiveMyWishListPageObject) liveHomePage.openDynamicLivePage(driver, "My Wishlist");
		verifyEquals(liveMyWishListPage.getDynamicTextH1Live(driver, "My Wishlist"),"MY WISHLIST");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	
	public void TC_08_AddYourReview(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu TV");
		liveHomePage.clickDynamicLink(driver, "TV");
		
		log.info("Step 3: Click detail Samsung LCD");
		liveHomePage.clickDynamicLink(driver, "Samsung LCD");
		
		log.info("Step 4: Click link 'Add Your Review'");
		liveHomePage.clickDynamicLink(driver, "Add Your Review");
		
		log.info("Step 5: Input data 3 field");//////////////
		
		log.info("Step 6: Click button Submit Review ");
		liveHomePage.clickDynamicButton(driver, "Submit Review");
		
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	
	public void TC_09_UserIsAblePuschaseProduct(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu TV");
		liveHomePage.clickDynamicLink(driver, "TV");
		
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	
	public void TC_10_VerifySearchFuntionality(Method testMethod) {
		
		log.info("============== START: " + testMethod.getName() + " ============== ");
		log.info("Step 1: Open URL ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 2: Click menu TV");
		liveHomePage.clickDynamicLink(driver, "TV");
		
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("============== START:  ============== ");
		driver = opentMultiBrowser(browserName, url);

		

		log.info("============== AND: ============== ");

		firstName = "Trang";
		middleName = "";
		lastName = "Tran";
		EMAIL = "seleniumonline" + randomNumber() + "@gmail.com";
		password = "123456";
		confirmPass = "123456";
		fullName = firstName +" "+ lastName;

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}
}
