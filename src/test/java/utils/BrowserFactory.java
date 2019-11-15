package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	private static WebDriver driver;

	//we gonna create a method
	//that will return a webdriver object
	//this method will take one parameter - String browser
	//based on the value of the browser parameter
	//method will return corresponded webdriver object
	// if browser = chrome, then return chromedriver object
	public synchronized static WebDriver getDriver(String browser) {
/*
* In simple words a static synchronized method will lock the class instead of the object,
* and it will lock the class because the keyword static means: "class instead of instance".
* The keyword synchronized means that only one thread can access the method at a time.
* And static synchronized mean:
 */
		if (driver == null) {
			// first we check if the value from xml file is null or not
			// if the value from xml file NOT null we use
			// the value from xml file IS null, we get the browser from properties file

			if ("chrome".equals(browser)) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if ("chromeHeadless".equals(browser)) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
			} else if ("firefox".equals(browser)) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if ("firefoxHeadless".equals(browser)) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
			} else if ("ie".equals(browser)) {
				if (System.getProperty("os.name").toLowerCase().contains("mac"))
					throw new WebDriverException("You are operating Mac OS which doesn't support Internet Explorer");
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else if ("edge".equals(browser)) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if ("safari".equals(browser)) {
				if (System.getProperty("os.name").toLowerCase().contains("windows"))
					throw new WebDriverException("You are operating Windows OS which doesn't support Safari");
				WebDriverManager.getInstance(SafariDriver.class).setup();
				driver = new SafariDriver();
			} else {
				throw new RuntimeException("Illegal browser type!");
			}
		}
		return driver;
	}

	public static WebDriver getDriver() {

		return getDriver(null);
	}

	public  static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}

