package mehmetgul.mylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ChropathTest {
	public static void main(String[] args) {


		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("merhaba");
		BrowserUtils.wait(3000);

		driver.get("http://www.qaclickacademy.com/interview.php");
		// using the text() method in xpath.
		driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();

		driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();

		System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
	}
}
