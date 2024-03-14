package mehmetgul.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MyDriver {
    private static ThreadLocal<WebDriver> DriverPool = new ThreadLocal<>();

    private MyDriver() { }

    public static WebDriver get() {
        //if this thread doesn't have a web Driver yet - create it and add to pool
        if (DriverPool.get() == null) {
            System.out.println("TRYING TO CREATE Driver");
            // this line will tell which browser should open based on the value from properties file
            String browserParamFromEnv = System.getProperty("browser");
            String browser = browserParamFromEnv == null ? ConfigurationReader1.getProperty("browser") : browserParamFromEnv;
            switch (browser) {
                case "chrome":

                    WebDriverManager.chromedriver().setup();


                    /**
                     *We have disabled the cookies in below ChromeOptions
                     * You need to add this feature to your configuration.properties
                     * Add cookiesEnableDisable=2  (disable the cookies)
                     * Add cookiesEnableDisable =0  (enable the cookies)
                     */
                   /* DesiredCapabilities caps = new DesiredCapabilities();

                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    Map<String, Object> profile = new HashMap<String, Object>();
                    Map<String, Object> contentSettings = new HashMap<String, Object>();

                    contentSettings.put("cookies",ConfigurationReader.getProperty("cookiesEnableDisable"));
                    profile.put("managed_default_content_settings",contentSettings);
                    prefs.put("profile",profile);
                    options.setExperimentalOption("prefs",prefs);
                    caps.setCapability(ChromeOptions.CAPABILITY,options);

                    DriverPool.set(new ChromeDriver(options));*/


                    DriverPool.set(new ChromeDriver());
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    DriverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    DriverPool.set(new FirefoxDriver());
                    break;
                case "firefox_headless":
                    WebDriverManager.firefoxdriver().setup();
                    DriverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    DriverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    DriverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    DriverPool.set(new SafariDriver());
                    break;
                case "remote_chrome":
                    try {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setCapability("platform", Platform.ANY);
                        DriverPool.set(new RemoteWebDriver(new URL("http://ec2-3-95-173-125.compute-1.amazonaws.com:4444//wd/hub"), chromeOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote_firefox":
                    try {
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setCapability("platform", Platform.ANY);
                        DriverPool.set(new RemoteWebDriver(new URL("http://ec2-54-152-156-255.compute-1.amazonaws.com:4444//wd/hub"), firefoxOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        //return corresponded to thread id webDriver object
        return DriverPool.get();
    }
    public static void close() {
        DriverPool.get().quit();
        DriverPool.remove();
    }
}
