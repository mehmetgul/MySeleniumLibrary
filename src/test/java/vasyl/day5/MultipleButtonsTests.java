package vasyl.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class MultipleButtonsTests {
	private WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = BrowserFactory.getDriver("chrome");
		driver.get("http://practice.cybertekschool.com/multiple_buttons");
	}
	@Test
	public void verifyButton1(){
		String expectedResult = "Clicked on button one!";
		driver.findElement(By.xpath("//*[text()='Button 1']")).click();
		String actualResult = driver.findElement(By.cssSelector("#result")).getText();
		Assert.assertEquals(actualResult, expectedResult, "Result is wrong!");
	}

	@Test
	public void verifyButton2(){
		String expectedResult = "Clicked on button two!";
		driver.findElement(By.name("button2")).click();
		String actualResult = driver.findElement(By.cssSelector("#result")).getText();
		Assert.assertEquals(actualResult, expectedResult, "Result is wrong!");
	}

	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}