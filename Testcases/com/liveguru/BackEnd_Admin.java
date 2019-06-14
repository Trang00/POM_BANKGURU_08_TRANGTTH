package com.liveguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commons.AbstractTest;


public class BackEnd_Admin extends AbstractTest{
	private WebDriver driver;
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("============== START:  ============== ");
		driver = opentMultiBrowser(browserName, url);
		log.info("============== AND: ============== ");
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
