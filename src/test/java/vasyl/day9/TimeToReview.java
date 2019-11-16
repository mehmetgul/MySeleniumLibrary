package vasyl.day9;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TimeToReview {
	private WebDriver driver;

	@BeforeMethod
	public void setup(){
		 driver= BrowserFactory.getDriver("chrome");
		System.out.println("Before Method");
	}

	@Test
	public void test1(){
		System.out.println("Test 1");
		driver.get("http://www.google.com");
	}

	@AfterTest
	public void teardown(){
		System.out.println("After Method");
		driver.quit();

	}
}
