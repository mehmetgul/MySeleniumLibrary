package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase4 {
	public static void main(String[] args) {

		//Setting up the chrome driver
		WebDriver driver = new BrowserFactory().getDriver("chrome");

		//opening the url
		driver.get("https://practice-cybertekschool.herokuapp.com");

		BrowserUtils.wait(3000);
		//clicking the registration form link
		driver.findElement(By.xpath("//a[contains(text(),'Registration Form')]")).click();

		//Entering 123 to firstt name
		driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("123");

		//Receiving the error message
		String actualWarning = driver.findElement(By.xpath("//small[contains(text(),'first name can only consist of alphabetical letter')]")).getText();

		//Expected message.
		String expectedWarning = "first name can only consist of alphabetical letters";

		//comparing the expected and actual message and printing it console...
		if(expectedWarning.equals(actualWarning)){
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}
}
