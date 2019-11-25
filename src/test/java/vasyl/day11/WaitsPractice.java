package vasyl.day11;
	/*	Agenda: Synchronization
		Waits in selenium: Implicit, Explicit, Fluent
		If selenium is coming before element appear - you will get NoSuchElementException
		Synchronization is one the biggest issues in Selenium WebDriver. Selenium doesn't adjust automatically. To overcome these issues we used to use Thread.sleep(2000)
		What's the problem with this solution?
		Thread.sleep(2000) will stop your test script, no matter element is available or no for fixed amount of time.
		Thread.sleep(20000) let's say we put on pause our test  for 20 seconds. Even though element was available after 3 seconds, still your script will be on hold for 20 seconds. We are increasing execution time, thus we are loosing money.
		ImplicitWait - will help to wait for appearance of element, within given time-frame.
		let's say you specified implicit wait time for 10 seconds, and If element was found faster, let's say in 2 seconds, your test will continue running and will not wait for extra 8 seconds. If after 10 seconds, element was not found, you will get NoSuchElementException.
		ImplicitWait should be specified only once, at the beginning. It will apply automatically before every findElement() method call, but not findElements()
		Thread.sleep(10000) ---> always and only 10 seconds wait
		implicitWait(10, TimeUnits.SECONDS) --> UP TO 10 seconds
		next is Explicit Wait ---> It works in similar way as an implicit wait, but explicit wait targets specific element with a specific condition.
		Implicit resolves only one problem: presence of element.
		Explicit wait resolves more problems:  presence of element, visibility, clickability, staleness of element, etc...
		Every 500 milliseconds selenium will check if condition is met. If no, it will keep checking withing given time frame.
		wait until page is loaded handled automatically by selenium, but other conditions - no (like visibility or clickability).
		Page is fully loaded, but element can delay, or be invisible, or not intractable.
		Element can be visible but not clickable. And implicit wait will not help you with this problem. THat's why we can use explicit wait.
		####Fluent wait - it work like explicit wait, but except one difference - you can change polling time. Explicit wait checks condition every 500 milliseconds. With a fluent wait, you can change this polling time. I would say that Fluent wait it's like custom explicit wait.
*/
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
public class WaitsPractice {
	private WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = BrowserFactory.getDriver("chrome");
		driver.get("http://practice.cybertekschool.com/");
	}
	@Test
	public void test1(){
		//this line should be before all findElement() methods
		//to wait within 10 seconds, until element is present
		//we apply it once, and it always works
		//put this line into @BeforeMethod and it will work for all tests
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Dynamic Loading")).click();
		//partialLinkText we match only part of the link text
		//partialLinkText it's like contains text
		//Example 2: Element on the page that is rendered after the trigger - link text
		//Example 2 - only part of the link text
		//we can use partialLinkText locator to find element by partial text
		driver.findElement(By.partialLinkText("Example 2")).click();
		driver.findElement(By.tagName("button")).click();
		//this is for "Hello World!"
		WebElement finishElement = driver.findElement(By.id("finish"));
		System.out.println(finishElement.getText());
	}
	@Test
	public void test2(){
		driver.findElement(By.linkText("Dynamic Loading")).click();
		//select Example #1 | xpath alternative: //a[contains(text(),'Example 2')]
		driver.findElement(By.partialLinkText("Example 1")).click();
		//click on start button
		driver.findElement(By.tagName("button")).click();
		//enter username
		//explicit wait
		//we find element first
		//but, the problem is element can be present but not visible
		WebElement userNameInputBox = driver.findElement(By.id("username"));
		//we create object of WebDriverWait to apply explicit wait
		//we must provide webdriver object and period of time
		//within this period of time selenium will check every 500 milliseconds
		//if condition is true, if condition has met, no need to wait longer
		//your script will continue executing| in this case waiting period is 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//how to apply condition | ExpectedConditions.condition
		//in this example, selenium webdriver will wait up to 10 seconds, until element is visible
		//if wait timeout will expire, your test will fail (due to exception)
		wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
		userNameInputBox.sendKeys("tomsmith");
		WebElement passwordInputBox = driver.findElement(By.id("pwd"));
		wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
		passwordInputBox.sendKeys("SuperSecretPassword");
		//this is a webelement that represents submit button
		WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
		//wait, within 10 seconds, until that button is available for click
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		WebElement message = driver.findElement(By.tagName("h4"));
		wait.until(ExpectedConditions.visibilityOf(message));
		String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
		String actualMessage = message.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	@Test
	public void test3(){
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.partialLinkText("Example 5")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
		//wait until overlay screen disappear
		//otherwise, we will have issue to click or enter the text
		wait.until(ExpectedConditions.invisibilityOf(overlayScreen));
		//find webelement of user input box
		WebElement userNameInputBox = driver.findElement(By.id("username"));
		//wait for user name input box to become visible
		wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
		//enter user name
		userNameInputBox.sendKeys("tomsmith");
		//find webelement of password input box
		WebElement passwordInputBox = driver.findElement(By.id("pwd"));
		//wait for password input box to become visible
		wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
		passwordInputBox.sendKeys("SuperSecretPassword");
		//this is a webelement that represents submit button
		WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
		//wait, within 10 seconds, until that button is available for click
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		WebElement message = driver.findElement(By.tagName("h4"));
		wait.until(ExpectedConditions.visibilityOf(message));
		String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
		String actualMessage = message.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	@Test(description = "Fluent wait example")
	public void test4(){
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.partialLinkText("Example 2")).click();
		driver.findElement(By.tagName("button")).click();
		Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(ElementNotVisibleException.class);
		WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			                                             @Override
			                                             public WebElement apply(WebDriver driver) {
				                                             return driver.findElement(By.id("finish"));
			                                             }
		                                             }
		);
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}




