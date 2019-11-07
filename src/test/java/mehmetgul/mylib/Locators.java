package tests.mehmetgul.mylib;



	/*
	Selenium WebDriver supports 6 type of locators.
	1- ID
	2- ClassName
	3- Name
	4- linkText
	5- Xpath
	6- CSS
	When we inspect the element in URL. We need to look the unique features to call from our code.
	If it is not unique than it will fail your test.
	example:
	<input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">

	//Every object may not have ID, className or name. Xpath and Css preferred.
	Alpha numeric may vary on every refresh. check it before using it. Example: Facebook Login submit button id.

	 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	public static void main(String[] args) {
		//Setting up FireFoxDriver via Maven dependencies.
		WebDriverManager.chromedriver().setup();

		//Creating object of FirefoxDriver
		WebDriver driver = new ChromeDriver();

		//Using get method to open the given url
		driver.get("http://www.facebook.com");

		//Using findElement method with By.id to locate the element and using sendKeys method to write
		//something in this element.
		driver.findElement(By.id("email")).sendKeys("My text to write inside the box");

		///Using findElement method with By.name to locate the element
		driver.findElement(By.name("pass")).sendKeys("this is my password");

		///Using findElement method with By.linkText to locate the element
		//to click the link we use click() method.
		driver.findElement(By.linkText("Forgot account?")).click();



	}
}
