package NetCoreTest.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class BaseClass {
	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void initalisingBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Practice_Project\\Assignment\\chromedriver_win32\\chromedriver.exe");
	   	driver = new ChromeDriver();
	   	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	   	driver.manage().window().maximize();
//	   	driver.get("https://www.makemytrip.com/");
	   	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
