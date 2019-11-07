package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.utils.BrowserFactory;

public class TestCase3 {
	public static void main(String[] args) {

		//setting up chromedriver
		WebDriver driver = new BrowserFactory().getDriver("chrome");

		//opening  the url
		driver.get("https://practice-cybertekschool.herokuapp.com/");

		// clicking the given link
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Buttons')]")).click();

		//Clicking button one
		driver.findElement(By.xpath("//button[contains(text(),'Button 1')]")).click();

		//verifying the message displayed
		String actualResult= driver.findElement(By.xpath("//p[@id='result']")).getText();

		//Verifying the result..
		String expectedResult = "Clicked on button one!";
		if(expectedResult.equals(actualResult)){
			System.out.println("Test Passed ");
		}
		else {
			System.out.println("Test Failed");
		}
	}
}
