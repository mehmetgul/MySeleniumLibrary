package mehmetgul.mylib.downloadfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;


public class DownloadPDF {


	static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		String downloadFilePath = "/Users/mehmetgul/Desktop/";

		HashMap<String, Object> chromePref = new HashMap<String, Object>();

		chromePref.put("profile.default_content_settings.popups", 0);

		chromePref.put("download.default_directory", downloadFilePath);
		System.out.println(chromePref);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", chromePref);

		driver = new ChromeDriver(options);

		driver.get("https://www.seleniumhq.org/download/");

		driver.findElement(By.xpath("//tr[2]//td[6]//a[1]")).click();


		Thread.sleep(13000);

		driver.close();

	}

}
