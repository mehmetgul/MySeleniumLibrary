package mehmetgul.mylib.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import mehmetgul.utils.BrowserFactory;

//Using explicit wait in specific location
// it waits in given limits until the target loads.

public class ExplicitWait {
	public static void main(String[] args) {


	//Setting up the chrome driver
	WebDriver driver = new BrowserFactory().getDriver("chrome");

	//Opening the target url
		driver.get("https://www.expedia.com/");

	//clicking the hotels tab
		driver.findElement(By.xpath("//span[@class='tab-label'][contains(text(),'Hotels')]")).click();

	//Sending keys to search box
		driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']")).sendKeys("NYC");

	//Hitting Tab to enter
		driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']")).sendKeys(Keys.TAB);

	//Now we can hit to enter to start the search
		driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']")).sendKeys(Keys.ENTER);


		//Explicit wait. this waits 20 sec till the target element visible.
		// you can use different methods like elemenToBeClickable() .. this means it will wait target be in clickable condition
		WebDriverWait d = new WebDriverWait(driver,10);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Click for more information about Salisbury Hotel')]")));


		driver.findElement(By.xpath("//a[contains(text(),'Click for more information about Salisbury Hotel')]")).click();
		}

}
