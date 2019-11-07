package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestCase2 {
	public static void main(String[] args) {

		//Setting up chrome driver
		WebDriver driver = new BrowserFactory().getDriver("chrome");

		//opening the url
		driver.get("https://practice-cybertekschool.herokuapp.com/");

		//counting the listed examples using findElements() metod with size() method...
		int ActualSize = driver.findElements(By.xpath("//div[@class='container']//li")).size();

		int ExpectingSize  = 48;
		if (ExpectingSize==ActualSize) {
			System.out.print(" Test passed " );
		} else {
			System.out.println(" Test fail ");
		}

		//Printing the actual size
		System.out.println(ActualSize);

	}
}
