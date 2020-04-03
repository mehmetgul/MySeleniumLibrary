package mehmetgul.mylib.suacelab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabTesting {
	public static final String USERNAME = "mehmetgul";
	public static final String ACCESS_KEY = "1808829b-d931-4acb-b58c-92253efdf709";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws MalformedURLException {

			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 7");
			caps.setCapability("version", "51.0");

			WebDriver driver=new RemoteWebDriver(new URL(URL), caps);
			driver.get("http://amazon.com");
			System.out.println(driver.getTitle());

		}
}
