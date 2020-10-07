package mehmetgul.mylib.javaalerts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import mehmetgul.utils.BrowserFactory;
import utils.BrowserUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class JavaAlertWindowsBased {

/**
Scenario to be automated

Launch the web browser and open the application – “gmail.com”
Enter valid username and password
Click on the sign in button
Click on the compose button
Click on the attach icon
Select the files to be uploaded with the window based pop up.
 */

	WebDriver driver;
	@Before

	public void setUp()
	{
		driver= BrowserFactory.getDriver("chrome");
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
	}

	@Test
	public void testWindowAlert() throws Exception{

// enter a valid email address
		driver.findElement(By.id("Email")).sendKeys("TestSelenium1607@gmail.com");
		driver.findElement(By.id("Email")).sendKeys(Keys.ENTER);

// enter a valid password
		driver.findElement(By.id("Passwd")).sendKeys("TestSelenium");

// click on sign in button
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(30000);

// click on compose button
		driver.findElement(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")).click();

// click on attach files icon
		driver.findElement(By.xpath("//div[contains(@command,'Files')]//div[contains(@class,'aaA')]")).click();
		BrowserUtils.wait(3000);

// creating instance of Robot class (A java based utility)
		Robot rb =new Robot();

// pressing keys with the help of keyPress and keyRelease events
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_SEMICOLON);
		rb.keyRelease(KeyEvent.VK_SEMICOLON);
		rb.keyRelease(KeyEvent.VK_SHIFT);

		rb.keyPress(KeyEvent.VK_BACK_SLASH);
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_P);
		rb.keyRelease(KeyEvent.VK_P);

		rb.keyPress(KeyEvent.VK_I);
		rb.keyRelease(KeyEvent.VK_I);

		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
}
