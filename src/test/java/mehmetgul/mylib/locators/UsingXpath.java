package mehmetgul.mylib.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingXpath {

	public static void main(String[] args) {
		//Setting up FireFoxDriver via Maven dependencies.
		WebDriverManager.chromedriver().setup();

		//Creating object of FirefoxDriver
		WebDriver driver = new ChromeDriver();

		//Using get method to open the given url
		driver.get("https://login.salesforce.com/");

		//using browsers xpath and css tools may not be reliable everytime.
		//Better to create your own
		// //*[@id="username"] xpath from browser tool. We need to change " to ' in xpath
		// Right click on inspected element -> copy->xpath
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("This is username");

		// //*[@id="password"] xpath from browser tool. We need to change " to ' in xpath
		// Right click on inspected element -> copy->xpath
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("This is password part");

		// //*[@id='Login'] xpath from browser tool. We need to change " to ' in xpath
		// Right click on inspected element -> copy->xpath
		driver.findElement(By.xpath("//*[@id='Login']")).click();


	}
}
