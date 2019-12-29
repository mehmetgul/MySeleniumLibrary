package mehmetgul.mylib.pagenavigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Using navigate method to navigate between pages.

public class NavigateToOtherPages {
	public static void main(String[] args) {
		//Setting up ChromeDriver via Maven dependencies.
		WebDriverManager.chromedriver().setup();

		//Creating object of ChromeDriver
		WebDriver driver = new ChromeDriver();

		//Using get method to open the given url
		driver.get("http://www.amazon.com");

		//To receive the title of the page and print it in console
		String title = driver.getTitle();
		System.out.println(title);

		//Get the current URL and print it on console
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);

		// Navigate to another website
		driver.get("http://www.facebook.com");

		//Navigating back amazon.com
		driver.navigate().back();
		//Navgigating the page forward
		driver.navigate().forward();

		//Closing the opened page
		driver.close();

		//Quiting from all browsers
		driver.quit();

	}
}