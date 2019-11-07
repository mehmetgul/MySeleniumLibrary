package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase1 {
	public static void main(String[] args) {

		// WebDriverManager.chromedriver().setup();

		//Setting up Webdrive Manager
		WebDriver driver = new BrowserFactory().getDriver("chrome");


		//opening the url
		driver.get("https://practice-cybertekschool.herokuapp.com");

		// giving time delay
		BrowserUtils.wait(3000);

		//clicking the given link
		driver.findElement(By.xpath("//a[contains(text(),'Sign Up For Mailing List')]")).click();

		// giving time delay
		BrowserUtils.wait(3000);

		//entering the valid user name.
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Mehmet Gul");

		// giving time delay
		BrowserUtils.wait(3000);

		//entering the valid email
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mehmetgul@blablamail.com");

		// giving time delay
		BrowserUtils.wait(3000);

		//Clicking submit button
		driver.findElement(By.xpath("//button[@name='wooden_spoon']")).submit();

		// giving time delay
		BrowserUtils.wait(3000);

		//getting the result text from browser.
		String ActuallyResult = driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();

		//Comparing the web page result with our expexted result and printing fail or pass...
		String ExpectingResult  = "Thank you for signing up. Click the button below to return to the home page.";
		if (ExpectingResult.equals(ActuallyResult)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test fail");
		}

		// giving time delay
		BrowserUtils.wait(3000);

		//Clicking Home button to go home page.
		driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();

	}
}
