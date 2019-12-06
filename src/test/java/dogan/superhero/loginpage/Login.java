package dogan.superhero.loginpage;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Login {

	public WebDriver driver;
	public String URL = "https://glitchitsystem.com/superhero/index.html";

	//reusable methods
	public void LoginHomePage() throws InterruptedException {
		WebElement email = driver.findElement(By.id("loginEmail"));
		email.sendKeys("justtesting@gmail.com");
		WebElement password = driver.findElement(By.id("loginPassword"));
		password.sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form-login\"]/button")).click();
		String CurrentUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://glitchitsystem.com/superhero/index.html";
		Assert.assertEquals(CurrentUrl, ExpectedUrl, "It's not matching");
		Thread.sleep(3000);
	}



	@BeforeMethod
	public void SetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
	}

	@Test(description = "Log in to Super hero Website", groups = {"smokeTest", "regressionTest"}, priority = 0)
	public void NavigateToHomePage() throws InterruptedException {
		LoginHomePage();
	}


	@Test(description = "Verify the all text appeared in Login Page", groups = {"regressionTest"}, priority = 1)
	public void verifyTextsInLoginPage() throws InterruptedException {

		List<WebElement> texts = driver.findElements(By.xpath("//*[@id=\"form-login\"]/div/label"));
		Assert.assertTrue(texts.get(0).getText().contains("Email address"), "Email not match");
		Assert.assertTrue(texts.get(1).getText().contains("Name "), "Email not match");
		Assert.assertTrue(texts.get(2).getText().contains("Password"), "Password is not match");
		Assert.assertTrue(texts.get(3).getText().contains("Remember Login"), "Remember Login text is not match");

	}

	@AfterMethod
	public void CLose() {
		driver.quit();
	}


}
