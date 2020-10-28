package mehmetgul.mylib.screenshot;


import mehmetgul.utils.BrowserUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import mehmetgul.utils.BrowserFactory;


import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.getDriver("chrome");
		//driver.get("http://www.google.com");
		driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void teardown() {
		BrowserUtils.wait(3000);
		driver.close();
	}

	@Test
	public void addRemoveElement() {
		driver.findElement(By.xpath("//a[contains(text(),'Add/Remove Elements')]")).click();

		//Adding 5 delete element
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//button[contains(text(),'Add Element')]")).click();
		}
	}

	@Test
	public void takeScreenShot1(WebElement parameter, String value) throws IOException {


		//While working in windows don't give c: drive. You may face access permision to c drive.
		//you can place it under c drive inside the user folder.

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/mehmetgul/IdeaProjects/MySeleniumLibrary/target/test-output/screenshot.jpg"));


	}

	@Test
	public void takeScreenShotElementWise() throws IOException {
		BrowserUtils.wait(2000);
		WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		WebElement forgetPassword = driver.findElement(By.linkText("Forgot my password"));
		email.sendKeys("serkan");
		password.sendKeys("12345");


		takeElementsScreenshot(email, "email1");
		takeElementsScreenshot(password, "password1");
		takeElementsScreenshot(loginButton, "loginmethod1");
		takeElementsScreenshot(forgetPassword, "forgetpassword");
	}

	public static void takeElementsScreenshot(WebElement element, String filename) throws IOException {


		TakesScreenshot srcShot = ((TakesScreenshot) element);

		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("/Users/mehmetgul/IdeaProjects/MySeleniumLibrary/target/test-output/" + filename + "page.png"));

	}


}
