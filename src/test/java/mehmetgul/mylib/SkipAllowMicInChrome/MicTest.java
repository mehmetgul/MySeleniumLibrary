package mehmetgul.mylib.SkipAllowMicInChrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import mehmetgul.utils.BrowserUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MicTest {
	WebDriver driver;

	@Test
	public void test() {



		//setting up chrome driver and using fake mic to override the system.
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("use-fake-device-for-media-stream");
		options.addArguments("use-fake-ui-for-media-stream");
		driver = new ChromeDriver(options);




		driver.get("https://www.vidyard.com/mic-test/");
		BrowserUtils.wait(1000);

		WebElement mic=driver.findElement(By.linkText("Grant Mic Access"));
		mic.click();



		BrowserUtils.wait(10000);
		driver.close();


	}
}
/**


	WebDriverManager.chromedriver().setup();
					DesiredCapabilities caps = new DesiredCapabilities();

					/**
					 *We have disabled the cookies in below ChromeOptions
					 * You need to add this feature to your configuration.properties
					 * Add cookiesEnableDisable=2  (disable the cookies)
					 * Add cookiesEnableDisable =0  (enable the cookies)

ChromeOptions options = new ChromeOptions();
	Map<String, Object> prefs = new HashMap<String, Object>();
	Map<String, Object> profile = new HashMap<String, Object>();
	Map<String, Object> contentSettings = new HashMap<String, Object>();

					contentSettings.put("cookies", ConfigurationReader.getProperty("cookiesEnableDisable"));
							profile.put("managed_default_content_settings", contentSettings);
							prefs.put("profile", profile);
							options.setExperimentalOption("prefs", prefs);
							caps.setCapability(ChromeOptions.CAPABILITY, options);

							DriverPool.set(new ChromeDriver(options));

 const webdriver = require('selenium-webdriver'), By = webdriver.By, until = webdriver.until,Builder= webdriver.Builder;

 var chrome = require('selenium-webdriver/chrome');

 var chromeOptions = new chrome.Options()
 .addArguments('allow-file-access-from-files')
 .addArguments('use-fake-device-for-media-stream')
 .addArguments('use-fake-ui-for-media-stream');

 var driver = new webdriver.Builder()
 .forBrowser('chrome')
 .setChromeOptions(chromeOptions);

 driver = driver.build();



 Awesome! Also worked in Java Selenium:
 ChromeOptions options = new ChromeOptions();
 options.addArguments("use-fake-device-for-media-stream");
 options.addArguments("use-fake-ui-for-media-stream");
 driver = new ChromeDriver(options);

 */