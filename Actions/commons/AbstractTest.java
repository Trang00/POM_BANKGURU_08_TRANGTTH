package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	private WebDriver driver;
public WebDriver opentMultiBrowser(String browserName) {
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browserName.equals("firefox")) {
		// System.setProperty("webdriver.gecko.driver", ".\\Resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	} else if (browserName.equals("chromeheadless")) {
		System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
	}

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	System.out.println("Driver in Abstract Test: "+driver.toString());
	return driver;
}
}
