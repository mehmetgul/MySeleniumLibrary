package mehmetgul.mylib.dropdown;

import mehmetgul.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import mehmetgul.utils.BrowserFactory;


//Auto suggestive drop down is a drop down which is suggesting based on your entry.
//how can we handle this? This suggestions are dynamic and elements are hidden.
//We need to use javascript DOM to extract the hidden elements.
//Selenium is not identifiyin the hidden elements.
//To identify this hidden elements. We need to invetigate the proporties
// of the objects to see if any hidden text


public class AutoSuggestDropDown {
	public static void main(String[] args) {

		//Setting up the chrome driver
		WebDriver driver = BrowserFactory.getDriver("chrome");

		//Opening the target url
		driver.get("http://www.ksrtc.in");

		//clicking the element
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).click();
		BrowserUtils.wait(1000);

		//entering the keys to the element.
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BANG");
		BrowserUtils.wait(2000);

		//in hidden elements getText() method doesn't work.It will display nothing.
		//driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText();

		//We are using JavaScript DOm to get the value from element.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//using javascripts method to get the element same as selenium.
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		//We are executing the script and getting the value and assigning that value to a string
		String text = (String) js.executeScript(script);

		System.out.println("Text is : "+ text);

		int i=0;

		//putting a while loop t get the desired value and stop it.
		while (!text.equalsIgnoreCase("BANGALORE INTERNATION AIRPORT")) {
			i++;
			BrowserUtils.wait(1000);
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			System.out.println("Inside while loop : " + text);

			//After finding the desired value, click on it.
			if(text.equalsIgnoreCase("BANGALORE INTERNATION AIRPORT")){
				driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
			}

			System.out.println(i);
			// putting if condition incase if the target value not available, to stop the loop
			if(i>10){
				System.out.println("Element not found");
				break;
			}
		}

	}
}

