package tests.myworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
	public static void main(String[] args) throws InterruptedException {


		// WebDriver setup
		WebDriverManager.chromedriver().setup();
		//Creating WebDriver object
		WebDriver obj = new ChromeDriver();
		//Connecting the given url
		obj.get("https://www.instagram.com");
		System.out.println("URL opened");
		//Checking the current url
		System.out.println(obj.getCurrentUrl());
		System.out.println("Current url printed");
		//Given time delay for website to load
		Thread.sleep(3000);
		System.out.println("Time delay given");
		//using css path to locate the sing up button
		obj.findElement(By.cssSelector("div:nth-child(8) > div > button")).click();
		//After clicking the button current url.
		System.out.println("4");
		System.out.println(obj.getCurrentUrl());


	}
}
