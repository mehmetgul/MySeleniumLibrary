package tests.mehmetgul.mylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DemoSafariDriver {
	public static void main(String[] args) {

		WebDriver driver = new SafariDriver();
		driver.get("http://www.google.com");
		//To receive the title of the page and print it in console
		String title = driver.getTitle();
		System.out.println(title);

		//Get the current URL and print it on console
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);

		//Print the page source to console
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		// Navigate to another website
		driver.get("http://www.facebook.com");

		//Navigating back amazon.com
		driver.navigate().back();
		//Navgigating the page forward
		driver.navigate().forward();

		//Closing the opened page
		driver.close();
	}
}
