package mehmetgul.mylib.PDFfileReadPrint;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DownloadPdf {

	WebDriver driver = null;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();


		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		//false will not promt to download. it will download
		prefs.put("download.prompt_for_download", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}


	@Test
	public void downloadPdf() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.learningcontainer.com/sample-pdf-files-for-testing");

		//locator to click the pdf download link
		driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[@id='primary']/main[@id='main']/article[@id='post-809']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}