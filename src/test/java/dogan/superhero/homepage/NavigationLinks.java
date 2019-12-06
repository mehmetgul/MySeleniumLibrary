package dogan.superhero.homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;



public class NavigationLinks {

	public WebDriver driver;
	public String URL = "https://glitchitsystem.com/superhero/index.html";


	public void LoginWithCredential() throws InterruptedException {
		WebElement email = driver.findElement(By.id("loginEmail"));
		email.sendKeys("justtesting@gmail.com");
		WebElement password = driver.findElement(By.id("loginPassword"));
		password.sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form-login\"]/button")).click();
		Thread.sleep(3000);
	}


	public void ClickOnDesired(String desired) throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='navbar-nav mr-auto']//li/a"));

		for (WebElement each : list) {
			Thread.sleep(2000);
			if(each.getText().contains((desired))){
				each.click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	public void VerifyTopNavigationLinks(){
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='navbar-nav mr-auto']//li/a"));
		for (WebElement each : list) {
			System.out.println(each.getText());
			try{
				WebDriverWait wait = new WebDriverWait(driver, 6);
				Assert.assertTrue(each.isEnabled());
				wait.until(ExpectedConditions.elementToBeClickable(each));
				System.out.println("This link is clickable");
			} catch (Exception e){
				System.out.println("This link is not clickable");
			}
		}
	}

	@BeforeMethod
	public void SetUp2() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
	}


	@Test(description = "Verify the home page links", priority = 0)
	public void NavigationLinks() throws InterruptedException {
		LoginWithCredential();
		VerifyTopNavigationLinks();
	}

	@Test(description = "Verify the home page links", priority = 1)
	public void NavigationDesiredLink() throws InterruptedException {
		LoginWithCredential();
		ClickOnDesired("Link");
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void teardown2(){
		driver.quit();
	}
}
