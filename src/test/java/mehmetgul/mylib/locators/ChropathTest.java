package mehmetgul.mylib.locators;

import mehmetgul.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import mehmetgul.utils.BrowserFactory;


// Downloading the chropath extention to chrome browser and getting the xpath from cropath.

public class ChropathTest {
	public static void main(String[] args) {


		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("https://www.ryanair.com/us/en");
		driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();
		BrowserUtils.wait(3000);
		driver.findElement(By.xpath("//input[@placeholder='email@email.com']")).sendKeys("merhaba");
		BrowserUtils.wait(3000);

		driver.get("http://www.qaclickacademy.com/interview.php");
		// using the text() method in xpath.
		driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();

		driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();

		System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
	}
}
