package tests.dogan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox {

	// 3 category
	// variables
	public WebDriver driver;
	//locators
	// methods

	public void GoToFormyWebPage() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("http://formy-project.herokuapp.com");

	}

	public void clickdesirecheckbox(String checkbox) {

		List<WebElement> desirebox = driver.findElements(By.xpath("/html/body/div/div/div/div"));
		List<WebElement> inputcheckbox = driver.findElements(By.xpath("/html/body/div/div/div/div/input"));

		for (int i = 0; i < desirebox.size(); i++) {


			if (desirebox.get(i).getText().equalsIgnoreCase(checkbox)) {

				inputcheckbox.get(i).click();

			}
		}


	}




	public void navigateToDesiredLink(String linkName) throws InterruptedException {


		List<WebElement> linksToNavigate = driver.findElements(By.cssSelector("body > div > div > li> a"));

		for (WebElement each : linksToNavigate) {

			if (each.getText().equalsIgnoreCase(linkName)) {

				each.click();

				Thread.sleep(3000);

				break;

			} else {

				System.out.println("it did not find the link to click");

			}
		}
	}


	public void VerifyCheckBoxTestNames() throws InterruptedException {

		List<WebElement> checkboxes = driver.findElements(By.xpath("/html/body/div/div/div/div"));


		for (int i = 0; i < checkboxes.size(); i++) {

			String result = checkboxes.get(i).getText();

			Thread.sleep(3000);

			System.out.println("Result " + " " + (i + 1) + " " + result);

		}

	}


	public void closeChromeBrowser() throws InterruptedException {

		Thread.sleep(2000);

		driver.quit();

	}
}
