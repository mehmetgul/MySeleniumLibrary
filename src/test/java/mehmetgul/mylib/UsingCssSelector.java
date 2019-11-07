package mehmetgul.mylib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingCssSelector {

	public static void main(String[] args) {
		//Setting up FireFoxDriver via Maven dependencies.
		WebDriverManager.chromedriver().setup();

		//Creating object of FirefoxDriver
		WebDriver driver = new ChromeDriver();

		//Using get method to open the given url
		driver.get("https://facebook.com/");

		//using browsers xpath and css tools may not be reliable everytime.
		//Better to create your own
		// //*[@id="username"] xpath from browser tool. We need to change " to ' in xpath
		// Right click on inspected element -> copy->xpath
		driver.findElement(By.cssSelector("#email")).sendKeys("This is email");

		// //*[@id="password"] xpath from browser tool. We need to change " to ' in xpath
		// Right click on inspected element -> copy->xpath
		driver.findElement(By.cssSelector("#pass")).sendKeys("This is password part");

		// //*[@id='Login'] xpath from browser tool. We need to change " to ' in xpath
		// Right click on inspected element -> copy->xpath
		driver.findElement(By.cssSelector("#loginbutton")).click();

		// if you want you can download ChroPath extention to your Chrome browser for xpath and cssselector

	}
}
