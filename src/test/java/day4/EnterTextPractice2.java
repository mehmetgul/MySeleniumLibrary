package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.utils.BrowserFactory;

public class EnterTextPractice2 {

	//    ###Test 3, Verify that confirmation message is displayed
//
//1. Go to "http://practice.cybertekschool.com/forgot_password"
//2. Enter any valid email
//3. Click on retrieve password button
//4. Verify that message "Your e-mail's been sent!" is displayed
	public static void main(String[] args) {
		//as usually, we are starting from driver setup
		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("http://practice.cybertekschool.com/forgot_password");
		WebElement input = driver.findElement(By.name("email"));
		//Keys.ENTER will simulate ENTER button press
		input.sendKeys("random@email.com", Keys.ENTER);
		WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
		String expectedMessage = "Your e-mail's been sent!";
		//to get the text from element
		String actualMessage = confirmationMessage.getText();
		if(expectedMessage.equals(actualMessage)){
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
		driver.close();
	}

}
