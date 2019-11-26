package vytruck;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class VyTruckTestCases {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.getDriver("chrome");
		//explicit wait
		wait = new WebDriverWait(driver, 10);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximize browser
		//driver.manage().window().maximize();
		driver.get("https://qa1.vytrack.com/");
		driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
		driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
		BrowserUtils.wait(5000);
	/*	WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
		wait.until(ExpectedConditions.visibilityOf(activitiesElement));
		wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
		activitiesElement.click();
		WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
		wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
		wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
		calendarEventsElement.click();
		WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
		wait.until(ExpectedConditions.invisibilityOf(loaderMask));*/
	}


	@Test(description = "Navigate to Activities-Calendar Events-Hover on three dots for testr meeting")
	public void testCase1_1() {
		testCase1();

	}

	public void testCase1() {

		//Creating actions object to perform mouse hover
		Actions a = new Actions(driver);

		BrowserUtils.wait(1000);
		//locating the Activites link
		WebElement move = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]"));
		BrowserUtils.wait(1000);

		//Moving out object on Activities link.
		a.moveToElement(move).build().perform();
		BrowserUtils.wait(1000);

		//Clicking the activities link
		driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
		BrowserUtils.wait(1000);

		// Narrowing the target location..
		WebElement minimizeTheTarget = driver.findElement(By.xpath("//tr[13]//td[9]"));

		//we are using actions class to mouse hover on the target link.
		WebElement verifyViewEditDelete = minimizeTheTarget.findElement(By.className("dropdown-toggle"));
		a.moveToElement(verifyViewEditDelete).build().perform();

		BrowserUtils.wait(1000);

		// Narrowing the target location..
		WebElement minimizeTheTargetView = driver.findElement(By.xpath("//tr[13]"));

		//To move our object to VIEW. we are using actions class to mouse hover on the target link.
		WebElement view = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-eye hide-text']"));
		a.moveToElement(view).build().perform();

		//Using Assert to verify that target is displayed.
		Assert.assertTrue(view.isDisplayed());
		BrowserUtils.wait(1000);

		//To move our object to EDIT. we are using actions class to mouse hover on the target link.
		WebElement edit = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"));
		a.moveToElement(edit).build().perform();

		//Using Assert to verify that target is displayed.
		Assert.assertTrue(edit.isDisplayed());
		BrowserUtils.wait(1000);

		//To move our object to DELETE. we are using actions class to mouse hover on the target link.
		WebElement delete = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"));
		a.moveToElement(delete).build().perform();

		//Using Assert to verify that target is displayed.
		Assert.assertTrue(delete.isDisplayed());
		BrowserUtils.wait(3000);

	}

	public void testCase2() {


	}

	public void testCase3() {


	}

	public void testCase4() {


	}

	public void testCase5() {


	}

	public void testCase6() {


	}

	public void testCase7() {


	}

	public void testCase8() {


	}

	public void testCase9() {


	}

	public void testCase10() {


	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
