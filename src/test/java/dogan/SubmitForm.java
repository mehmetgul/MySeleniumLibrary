package dogan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitForm {

		WebDriver driver;


		//variables
		String basedUrl = "https://formy-project.herokuapp.com/";
		String submitFormUrl = "https://formy-project.herokuapp.com/form";
		String firstName = "Mehmet";
		String lastName = "Sample";
		String jobTitle1 = "Computer Engineer";

	// locators



	// methods

	//Test Execution
	@Test
	public void metodd() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

		//navigate  formy website url
		driver.get(basedUrl);

		//locators of submit form link then clock
		System.out.println("Test");
		WebElement submitFormLink = driver.findElement(By.cssSelector("body > div > div > li:nth-child(18) > a"));
		submitFormLink.click();
		Thread.sleep(5000);
		//Very that title appeared when navigate the submit form....
		WebElement webFormTest = driver.findElement(By.cssSelector("body > div > h1"));
		Assert.assertEquals(webFormTest.getText(),"Complete Web Form");

		//verify that first name text appeared
		WebElement firstNameTest = driver.findElement(By.cssSelector("form > div > div:nth-child(1) > strong > label"));
		String firstNameTitleText = firstNameTest.getText();
		Assert.assertEquals(firstNameTitleText,"First name");

		//verify that last name text appeared...
		WebElement lastNameTest = driver.findElement(By.cssSelector("form > div > div:nth-child(3) > strong > label"));
		String lastNameTitleText = lastNameTest.getText();
		Assert.assertEquals(lastNameTitleText,"Last name");

		//verify that Job Title appeared ....
		WebElement jobTitle = driver.findElement(By.cssSelector("form > div > div:nth-child(5) > strong > label"));
		String jobTitleText = jobTitle.getText();
		Assert.assertEquals("Failed your test ",jobTitleText,"Job title");


		//sendKey

		WebElement firstNameInputBox = driver.findElement(By.cssSelector("#first-name"));
		firstNameInputBox.sendKeys(firstName);

		WebElement lastNameInputBox = driver.findElement(By.cssSelector("#last-name"));
		lastNameInputBox.sendKeys(lastName);

		WebElement jobTitleInputBox = driver.findElement(By.cssSelector("#job-title"));
		jobTitleInputBox.sendKeys(jobTitle1);

		WebElement submitButton = driver.findElement(By.cssSelector("form > div > div:nth-child(15) > a"));
		submitButton.click();

		Thread.sleep(5000);

		WebElement thankYouMessage = driver.findElement(By.cssSelector("body > div > div"));
		String thankyouTitle =thankYouMessage.getText();
		Assert.assertEquals("Alert wrong",thankyouTitle,"The form was successfully submitted!");


	}


}
