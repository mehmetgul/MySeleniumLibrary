package vasyl.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import java.util.concurrent.TimeUnit;
public class CalendarEventsTests {
	private WebDriver driver;
	private WebDriverWait wait;
	@BeforeMethod
	public void setup(){
		driver = BrowserFactory.getDriver("chrome");
		//explicit wait
		wait = new WebDriverWait(driver, 10);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximize browser
		driver.manage().window().maximize();
		driver.get("https://qa1.vytrack.com/");
		driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
		driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
		WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
		wait.until(ExpectedConditions.visibilityOf(activitiesElement));
		wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
		activitiesElement.click();
		WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
		wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
		wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
		calendarEventsElement.click();
		WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
		wait.until(ExpectedConditions.invisibilityOf(loaderMask));
	}
	@Test(description = "Verify page subtitle")
	public void test1(){
		String expectedSubtitle = "All Calendar Events";
		String actualSubtitle = driver.findElement(By.className("oro-subtitle")).getText();
		Assert.assertEquals(actualSubtitle, expectedSubtitle, "Subtitle is wrong!");
	}
	@Test(description = "Verify that 'Create Calendar event' button is displayed")
	public void test2(){
		Assert.assertTrue(driver.findElement(By.cssSelector("[title='Create Calendar event']")).isDisplayed());
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}