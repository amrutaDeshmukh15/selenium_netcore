package NetCoreTest.Assignment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase1 extends BaseClass {
	
	BaseClass baseClass = new BaseClass();
	WebDriver driver;
	//WebDriverWait wait;
	
	@Test
	public void beforeClass() {
		initalisingBrowser();
		driver = getDriver();
		
		//wait = new WebDriverWait(driver,100);
	}
	
	@Test
	public void selectCity() {
		//initalisingBrowser();
		driver.navigate().to("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"SW\"]//a[contains(@href,'flights')][contains(@class,'makeFlex')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'fsw_inputBox searchCity inactiveWidget')]//label")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]//input[contains(@placeholder,'From')]")).sendKeys("mumbai");
		driver.findElement(By.xpath("//*[@id=\"root\"]//p[contains(text(),'Mumbai,')]")).click();
		//driver.findElement(By.xpath("//div[contains(@class,'fsw_inputBox searchToCity inactiveWidget')]//label")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]//div//input[contains(@placeholder,'To')]")).sendKeys("Delhi");
		driver.findElement(By.xpath("//*[@id=\"root\"]//p[contains(text(),'Delhi,')]")).click();
	}
	
	@Test
	public void validateDate() {
//		Date currentDate = new Date();
//		int today = currentDate.getDate();
//		int yesterday = today-1;
//		int startandReturnDate = today+1;
		driver.findElement(By.xpath("//*[@id=\"root\"]//div[contains(@class,'DayPicker-Day--selected')]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]//div[contains(@class,'fsw_inputBox dates reDates inactiveWidget ')]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]//div[contains(@class,'DayPicker-Day--selected')][1]")).click();	
	}
	
	@Test
	public void validatePassengers() {
		driver.findElement(By.xpath("//*[contains(@data-cy,'travellerText')]")).click();
		driver.findElement(By.xpath("//li[contains(@data-cy,'adults-2')]")).click();
		driver.findElement(By.xpath("//li[contains(@data-cy,'children-1')]")).click();
		driver.findElement(By.xpath("//li[contains(@data-cy,'infants-1')]")).click();
		driver.findElement(By.xpath("//li[contains(@data-cy,'travelClass-2')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'primaryBtn btnApply pushRight')]")).click();
		String TravellerSelected = driver.findElement(By.xpath("//*[@id=\"root\"]//label//p[1]//span[contains(@data-cy,'travellerText')]//span")).getText();
		System.out.println(TravellerSelected);
		
		Assert.assertEquals("4",TravellerSelected.trim());
		boolean elementPresent = driver.findElement(By.xpath("//label//p[contains(text(),'Business')]")).isDisplayed();
		Assert.assertEquals(true, elementPresent);
		//driver.findElement(By.xpath("//p[contains(@data-cy,'submit')]//a[contains(text(),'Search')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
	}


}
