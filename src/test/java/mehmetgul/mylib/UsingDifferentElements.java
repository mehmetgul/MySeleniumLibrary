package mehmetgul.mylib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Iterator;
import java.util.Set;

/*
1- Counting whole page tags
2- Counting the tags in specific location like in footer area. Limiting the scope of the WebDriver.
3- Count the links of first column in footer section.
4- Click on each link in the column and check if the pages are opening
5- Navigating each tab and retreiving the page title or something to verify the page is correct

 */
public class UsingDifferentElements {
	public static void main(String[] args) {

		//setting up the chrome driver
		WebDriver driver = BrowserFactory.getDriver("chrome");

		//opening target link
		driver.get("http://www.qaclickacademy.com/practice.php");

		//giving 3 sec wait for page loading
		BrowserUtils.wait(3000);

		//1- Counting whole page tags
		//count the number of <a></a> tag links
		int tagCount = driver.findElements(By.tagName("a")).size();
		System.out.println("whole page a TAG count : " + tagCount);

		//2- Counting the tags in specific location like in footer area. Limiting the scope of the WebDriver.
		//counting the number of tags in specific location like footer.
		//created sub section and making available this subsection to be counted.
		//we are limiting the WebDriver scope.
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		//Counting the TAGS in subsection
		int footerCount = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Only footer a TAG count : " + footerCount);

		//3- Count the links of first column in footer section.
		//Using previos footerdriver and minimizing its scope for column
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]//ul"));

		//counting the tags in minimized scope.
		int count = columnDriver.findElements(By.tagName("a")).size();
		System.out.println("Number of a Tags in column : " + count);

		//4- Click on each link in the column and check if the pages are opening
		//This will open each page in new tab. if we don't use new tab then we may need to navigate back everytime
		for (int i = 1; i < count; i++) {
			//in mac we use KEYS.COMMAND and in windows KEYS.CONTROL
			String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			BrowserUtils.wait(5000);


		}

		//5- Navigating each tab and retreiving the page title or something to verify the page is correct
		//abc.iterator() will move to next Tab when it is inside the loop.
		//hasNext() checks that there is a iterator available or not.
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> iter = abc.iterator();

		while (iter.hasNext()) { //iter.hasNext() is boolean.
			driver.switchTo().window(iter.next()); // this will switch the next window
			String title = driver.getTitle();
			System.out.println(title);
			BrowserUtils.wait(2000);

		}


	}
}
