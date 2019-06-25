package com.liveguru;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constansts;
import liveguruPageObjects.LiveAdminPageObject;
import liveguruPageObjects.LiveHomePageObject;
import liveguruPageObjects.LivePageFactoryManager;


public class BackEnd_Admin extends AbstractTest{
	private WebDriver driver;
	private LiveAdminPageObject liveAdminPage;
	private LiveHomePageObject liveHomePage;
	private String USER, PASS,review,summaryReview,nickReview; 
	
	public void TC_01_VerifyInvoiceCanBePrinted(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		
		
		log.info("Step 2: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);
		
		liveAdminPage.clickDynamicMenu(driver, "close");
		
		log.info("Step 3: Goto Sales -> Orders menu");
		liveAdminPage.clickDynamicMenu(driver, "Sales");
		liveAdminPage.clickDynamicMenu(driver, "Orders");
		
		log.info("Step 4:  In the status field select 'Canceled'. Click Search");
		liveAdminPage.inputDynamicDropdown(driver, "Canceled", "status");
		liveAdminPage.clickDynamicButton(driver, "Search");
		
		log.info("Step 5: Select checkbox next to first order");
		liveAdminPage.clickCheckboxOrder2(driver);
		liveAdminPage.sleepInSecond(3);
		
		log.info("Step 6: In action, select Print Invoices. Click button Submit");
		liveAdminPage.inputDynamicDropdown_ID(driver, "Print Invoices", "sales_order_grid_massaction-select");
		liveAdminPage.clickDynamicButton(driver, "Submit");
		
		log.info("Step 7: Verify error msg ");
		verifyTrue(liveAdminPage.isDynamicTextDisplayed_SPAN(driver, "There are no printable documents related to selected orders."));
		
		log.info("Step 8: Select Complete. Click search");
		liveAdminPage.inputDynamicDropdown(driver, "Complete", "status");
		liveAdminPage.clickDynamicButton(driver, "Search");
		
		log.info("Step 9: Select checkbox next to first order");
		liveAdminPage.clickCheckboxOrder2(driver);
		
		log.info("Step 10: In action, select Print Invoices. Click button Submit");
		liveAdminPage.inputDynamicDropdown_ID(driver, "Print Invoices", "sales_order_grid_massaction-select");
		liveAdminPage.clickDynamicButton(driver, "Submit");
		
		log.info("Step 11: Verify invoice is downloaded");
		liveAdminPage.acceptAlert(driver);
		
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void TC_02_VerifyProductReview(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		liveHomePage = LivePageFactoryManager.getHomePageLive(driver);
		
		log.info("Step 02: Go To Link - http:/live.guru99.com/index.php/review/productilist/id/1/");
		liveHomePage.openURL(driver, Constansts.LIVE_BACKEND_REVIEW_URL);
		
		log.info("Step 03: Fill the required review and submit it");
		liveHomePage.inputDynamicTextBoxTextArea(driver, review, "review_field");
		liveHomePage.inputDynamicTextBoxTextArea(driver, summaryReview, "summary_field");
		liveHomePage.inputDynamicTextBoxTextArea(driver, nickReview, "nickname_field");
		
		liveHomePage.clickDynamicButton(driver, "Submit Review");
		
		log.info("Step 04: Go to http: //live.guru99.com/index.php/backendlogin");
		liveAdminPage = LivePageFactoryManager.getAdminPageLive(driver);
		

		log.info("Step 05: Go to http: //live.guru99.com/index.php/backendlogin");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickLogin(driver);
		
		liveAdminPage.clickDynamicMenu(driver, "close");
		
		log.info("Step 5: Go to Catalogue -> Reviews and Ratings \r\n" + 
				"-> Customer Reviews ->Pending Reviews Menu");
		liveAdminPage.clickDynamicMenu(driver, "Sales");
		
		
		
		
		
		
		
		log.info("==============END: " + testMethod.getName() + " ============== ");
	}

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = opentMultiBrowser(browserName, url);
		liveAdminPage = LivePageFactoryManager.getAdminPageLive(driver);
		
		USER="user01";
		PASS="guru99com";
		review="This is good prouct";
		summaryReview="Good";
		nickReview="";
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}
}
