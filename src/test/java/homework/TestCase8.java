package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase8 {
	public static void main(String[] args) {

		//Setting up the chrome driver
		WebDriver driver = new BrowserFactory().getDriver("chrome");

		//opening the url
		driver.get("https://practice-cybertekschool.herokuapp.com");

		BrowserUtils.wait(3000);

		//clicking the registration form link
		driver.findElement(By.xpath("//a[contains(text(),'Registration Form')]")).click();

		//Entering 123 to last name
		driver.findElement(By.xpath("//input[@placeholder='571-000-0000']")).sendKeys("5711234354");

		//Receiving the error message
		String actualWarning = driver.findElement(By.xpath("//small[contains(text(),'Phone format is not correct')]")).getText();

		//Expected message.
		String expectedWarning = "Phone format is not correct";

		//comparing the expected and actual message and printing it console...
		if(expectedWarning.equals(actualWarning)){
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}
}
