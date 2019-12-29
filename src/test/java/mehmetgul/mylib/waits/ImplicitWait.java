package mehmetgul.mylib.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;
import java.util.concurrent.TimeUnit;

//Implicit wait till the given time limit to load the page.
// if the page loads early then it will not wait till the given limit.


public class ImplicitWait {
	public static void main(String[] args) {
		//Setting up the chrome driver
		WebDriver driver = new BrowserFactory().getDriver("chrome");

		//Opening the target url
		driver.get("https://www.expedia.com/");

		// Adding implicit wait to page load.
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//clicking the hotels tab
		driver.findElement(By.xpath("//span[@class='tab-label'][contains(text(),'Hotels')]")).click();

		//Sending keys to search box
		driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']")).sendKeys("NYC");

		//Hitting Tab to enter
		driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']")).sendKeys(Keys.TAB);

		//Now we can hit to enter to start the search
		driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']")).sendKeys(Keys.ENTER);


		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Click for more information about Salisbury Hotel')]")).click();


	}
}
