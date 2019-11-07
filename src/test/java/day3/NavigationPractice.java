package day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class NavigationPractice {
	public static void main(String[] args) {

		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.amazon.com");
		driver.navigate().back();
		driver.navigate().forward();
	}
}
