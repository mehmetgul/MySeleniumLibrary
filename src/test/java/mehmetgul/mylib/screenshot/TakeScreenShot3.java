package mehmetgul.mylib.screenshot;

import mehmetgul.utils.BrowserUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import mehmetgul.utils.BrowserFactory;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenShot3 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.getDriver("chrome");
		//driver.get("http://www.google.com");
		driver = BrowserFactory.getDriver("chrome");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();
	}

	@AfterMethod
	public void teardown() {
		BrowserUtils.wait(3000);
		driver.close();
	}

	@Test
	public void screenShot() throws IOException {
		WebElement table = driver.findElement(By.id("customers"));
		File srcFile=table.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("/Users/mehmetgul/IdeaProjects/MySeleniumLibrary/target/test-output/page.png"));
	}
}
