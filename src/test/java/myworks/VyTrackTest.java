package myworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VyTrackTest {
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://qa2.vytrack.com/user/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("prependedInput")).sendKeys("storemenager219");
		driver.findElement(By.id("prependedInput2")).sendKeys("User123");
		Thread.sleep(3000);
		driver.findElement(By.id("_submit")).click();
		Thread.sleep(3000);
		WebElement input = driver.findElement(By.xpath("//*[@id=\'login-form\']/fieldset/div[1]/div"));
		System.out.println(input.getText());

		List<WebElement> array = driver.findElements(By.xpath("//*[@id=\'login-form\']/fieldset/div[1]/div"));
		for (WebElement each : array) {
			System.out.println(each.getText());
		}
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i).getText());
			if (array.get(i).getText().equals("Invalid user name or password.")) {
				System.out.println(array.get(i).getText());
			}
		}

		String ExpectingResult = "Invalid user name or password.";
		String ActuallyResult  = "Invalid user name or password.";
		if (ExpectingResult.equals(ActuallyResult)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test fail");
		}
		driver.close();
	}

}

