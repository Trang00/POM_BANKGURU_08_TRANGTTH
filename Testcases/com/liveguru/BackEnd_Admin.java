package com.liveguru;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import liveguruPageObjects.LiveAdminPageObject;
import liveguruPageObjects.LivePageFactoryManager;


public class BackEnd_Admin extends AbstractTest{
	private WebDriver driver;
	private LiveAdminPageObject liveAdminPage;
	private String USER, PASS; 
	@Test
	public void TC_01_VerifyInvoiceCanBePrinted(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");
		liveAdminPage = LivePageFactoryManager.getAdminPageLive(driver);
		
		log.info("Step 2: Login");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, USER, "username");
		liveAdminPage.inputDynamicTextBoxTextArea(driver, PASS, "login");
		liveAdminPage.clickDynamicButton(driver, "Login");
		
		liveAdminPage.clickCloseIncomingMessage(driver);
		
		log.info("Step 3: Goto Sales -> Orders menu");
		liveAdminPage.clickDynamicMenu(driver, "Sales");
		liveAdminPage.clickDynamicMenu(driver, "Orders");
		
		log.info("Step 4:  In the status field select 'Canceled'. Click Search");
		liveAdminPage.inputDynamicDropdown(driver, "Canceled", "status");
		liveAdminPage.clickDynamicButton(driver, "Search");
		
		log.info("Step 5: Select checkbox next to first order");
		liveAdminPage.clickCheckboxOrder2(driver);
		
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

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = opentMultiBrowser(browserName, url);
		
		USER="user01";
		PASS="guru99com";
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
