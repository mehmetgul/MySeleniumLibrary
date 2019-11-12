package mehmetgul.mylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

//How to deal dynamic calender.
// When the date change after 2 weeks or one month how to deal without changing the xpath.
//when the current date change then xpath will change every time.


public class SelectFutureDateCalendar {
	public static void main(String[] args) {

		// setting up the chrome driver.
		WebDriver driver = BrowserFactory.getDriver("chrome");

		//opening the target url
		driver.get("https://www.path2usa.com/travel-companions");

		//Clicking the calender element to open the calender.
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();

		BrowserUtils.wait(2000);



		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='datepicker-switch']")).getText().contains("May")) {
			//this will click till finding the moth April.
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")).click();
			BrowserUtils.wait(1000);

		}
		//Grab common attribute and put it into list and iterate
		//using List to retrieve the class contains day in it.
		List<WebElement> dates = driver.findElements(By.className("day"));

		//counting the number of days inside the day class.
		int count = driver.findElements(By.className("day")).size();

		// iterating the days to find desired day which is equal to 23
		for (int i = 0; i < count; i++) {
			//We are getting the each day
			String text = driver.findElements(By.className("day")).get(i).getText();

			//comparing the day number with desired one. when it match the 23,
			// it will execute and will break the loop.
			if (text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}

		// targeting 23rd april 2020


	}
}
