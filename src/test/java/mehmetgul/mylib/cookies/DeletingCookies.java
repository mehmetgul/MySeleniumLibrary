package mehmetgul.mylib.cookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

import java.util.Set;

public class DeletingCookies {
	public static void main(String[] args) {

		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("http://amazon.com");
		//maximizing the browser before loading the page.
		driver.manage().window().maximize();
		Set<Cookie> a = driver.manage().getCookies();
		System.out.println(a);
		//Delete all the cookies
		driver.manage().deleteAllCookies();

		//delete specific cookies
		driver.manage().deleteCookieNamed("examplename");

		driver.get("http://www.google.com");
	}
}
