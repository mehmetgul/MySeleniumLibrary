package mehmetgul.mylib.sendkeys;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//if there are multiple id having same value. if the both elements having same name or same values
// then which fields selenium will choose. Selenium starts scanning from top-left and it will catch
// the first index and will ignore the others.

//if there is space in class name we will get error of Compound class name not permitted.

public class SendKeysMetohd {
	public static void main(String[] args) {


		//Setting up FireFoxDriver via Maven dependencies.
		WebDriverManager.chromedriver().setup();

		//Creating object of FirefoxDriver
		WebDriver driver = new ChromeDriver();

		//Using get method to open the given url
		driver.get("https://login.salesforce.com/");

		//Using findElement method with By.id to locate the element and using sendKeys method to write
		//something in this element.
		driver.findElement(By.id("username")).sendKeys("My text to write inside the box");

		///Using findElement method with By.name to locate the element
		driver.findElement(By.name("pw")).sendKeys("this is my password");

		//Selenium doesn't allow space in class name. we will get error of "Compound class name not permitted."
		//driver.findElement(By.className(" button r4 wide primary")).click();

		driver.findElement(By.id("Login")).click();


	}
}
