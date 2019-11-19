package mehmetgul.mylib;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class HandleBrowser {
	public static void main(String[] args) {

		WebDriver driver = BrowserFactory.getDriver("chrome");
		//maximizing the browser before loading the page.
		driver.manage().window().maximize();

		//Delete all the cookies
		driver.manage().deleteAllCookies();

		//delete specific cookies
		driver.manage().deleteCookieNamed("examplename");

		driver.get("http://www.google.com");
	}
}
