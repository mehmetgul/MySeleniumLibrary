package myworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {
	public static void main(String[] args) throws InterruptedException {
		//setting up chore diriver
		WebDriverManager.chromedriver().setup();

		//creating webdriver object
		WebDriver driver = new ChromeDriver();
		// opening the target page
		driver.get("http://www.amazon.com");
		Actions a = new Actions(driver);
		// giving 5sec time delay
		Thread.sleep(5000);


		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

		a.moveToElement(move).click().keyDown(Keys.SHIFT).build().perform();
		a.moveToElement(move).build().perform();



	}
}
