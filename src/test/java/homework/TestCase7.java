package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestCase7 {
	public static void main(String[] args) {

		//Setting up the chrome driver
		WebDriver driver = new BrowserFactory().getDriver("chrome");

		//opening the url
		driver.get("https://practice-cybertekschool.herokuapp.com");

		BrowserUtils.wait(3000);

		//clicking the registration form link
		driver.findElement(By.xpath("//a[contains(text(),'Registration Form')]")).click();

		//Entering 123 to last name
		driver.findElement(By.xpath("//input[@placeholder='email@email.com']")).sendKeys("tester@email");

		//Receiving the error message
		String actualWarning1 = driver.findElement(By.xpath("//small[contains(text(),'email address is not a valid')]")).getText();
		String actualWarning2 = driver.findElement(By.xpath("//small[contains(text(),'Email format is not correct')]")).getText();
		String actualWarning= actualWarning1 + actualWarning2;

		//Expected message.
		String expectedWarning1 = "email address is not a valid";
		String expectedWarning2="Email format is not correct";
		String expectedWarning= expectedWarning1 + expectedWarning2;

		//comparing the expected and actual message and printing it console...
		if(expectedWarning.equals(actualWarning)){
			System.out.println("Test Passed");

		} else {
			System.out.println("Test Failed");

		}
	}
}
