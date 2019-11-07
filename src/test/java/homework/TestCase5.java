package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestCase5 {
	public static void main(String[] args) {

		//Setting up the chrome driver
		WebDriver driver = new BrowserFactory().getDriver("chrome");

		//opening the url
		driver.get("https://practice-cybertekschool.herokuapp.com");

		BrowserUtils.wait(3000);

		//clicking the registration form link
		driver.findElement(By.xpath("//a[contains(text(),'Registration Form')]")).click();

		//Entering 123 to last name
		driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("123");

		//Receiving the error message
		String actualWarning = driver.findElement(By.xpath("//small[contains(text(),'The last name can only consist of alphabetical let')]")).getText();

		//Expected message.
		String expectedWarning = "The last name can only consist of alphabetical letters and dash";

		//comparing the expected and actual message and printing it console...
		if(expectedWarning.equals(actualWarning)){
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}
}
