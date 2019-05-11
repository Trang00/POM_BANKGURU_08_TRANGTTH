package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AbstractTest {
	private WebDriver driver;
protected WebDriver opentMultiBrowser(String browserName) {
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browserName.equals("firefox")) {
		// System.setProperty("webdriver.gecko.driver", ".\\Resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	}  else if (browserName.equals("ie")) {
		System.setProperty("webdriver.ie.driver", ".\\Resources\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
	}else if (browserName.equals("chromeheadless")) {
		System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
	}
	
	driver.get(Constansts.DEV_URL);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	//System.out.println("Driver in Abstract Test: "+driver.toString());
	return driver;
}
protected int randomNumber() {
	  Random random= new Random();
	  int number=random.nextInt(999);
	  return number;
}
}
