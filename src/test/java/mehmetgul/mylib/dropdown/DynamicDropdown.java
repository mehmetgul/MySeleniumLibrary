package mehmetgul.mylib.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class DynamicDropdown {
	public static void main(String[] args) {

		//If we need to scroll down from and dropdown menu we can use below options.
		//  .senKeys("abcsd");  .sendKeys(Keys.ARROW_DOWN);  .sendKeys(Keys.ENTER);

		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("http://www.makemytrip.com");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//head//link[18]")).click();

		//BrowserUtils.wait(3000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("bang");

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//p[contains(text(),'Bengaluru, India')]")).click();

		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Hyd");


		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//p[contains(text(),'Hyderabad, India')]")).click();







	}
}
