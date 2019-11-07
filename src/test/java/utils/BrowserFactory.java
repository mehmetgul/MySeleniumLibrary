package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

	//we gonna create a method
	//that will return a webdriver object
	//this method will take one parameter - String browser
	//based on the value of the browser parameter
	//method will return corresponded webdriver object
	// if browser = chrome, then return chromedriver object
	public static WebDriver getDriver(String browser) {
		WebDriver driver;

		if ("chrome".equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ("firefox".equals("chrome")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if ("opera".equals("chrome")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if ("safari".equals("chrome")) {
			driver = new SafariDriver();
		} else if ("edge".equals("chrome")) {
			WebDriverManager.edgedriver().setup();
			driver = null;
		} else {
			return null;
		}
		return driver;



	}
}
