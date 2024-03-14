package mehmetgul.mylib.javaalerts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import mehmetgul.utils.BrowserFactory;


public class JavaAlertTest {
	@Test
	public void test() throws InterruptedException {


			WebDriver driver = BrowserFactory.getDriver("chrome");
			System.out.println(driver);
			driver.get("http://app.meetsky.net/index.php/login");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 Thread.sleep(3000);
			WebElement field = driver.findElement(By.cssSelector("#password"));
			String message = (String)js.executeScript("return arguments[0].validationMessage;", field);
			Assert.assertEquals(message,"Please fill out this field.");
			System.out.println(message);
			Thread.sleep(3000);
			driver.close();


	}
}
