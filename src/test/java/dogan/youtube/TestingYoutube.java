package dogan.youtube;

import dogan.resource.configuration.GetPropertyMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestingYoutube {
	WebDriver driver;

	@Test
	public void Test1() {


		driver= BrowserFactory.getDriver("chrome");

		driver.get(GetPropertyMethod.getProperty("url"));

		WebElement element= driver.findElement(By.xpath("//input[@id='search']"));

		element.sendKeys(GetPropertyMethod.getProperty("lookingFor"));
		element.sendKeys(Keys.ENTER);

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Java Tutorial for Beginners [2019]')]")).click();



	}

}
