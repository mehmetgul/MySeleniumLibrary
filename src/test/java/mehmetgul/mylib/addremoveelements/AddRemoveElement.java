package mehmetgul.mylib.addremoveelements;

import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import mehmetgul.utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AddRemoveElement {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.getDriver("chrome");
		driver.get("http://practice.cybertekschool.com/");

	}

	@Test
	public void addRemoveElement() {
		driver.findElement(By.xpath("//a[contains(text(),'Add/Remove Elements')]")).click();

		//Adding 5 delete element
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//button[contains(text(),'Add Element')]")).click();
		}

		//Deleting the added elements
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='elements']//button"));
		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).click();
		}

	}



	@Test
	public void autoComplete(){


		driver.findElement(By.xpath("//a[contains(text(),'Autocomplete')]")).click();

		WebElement element = driver.findElement(By.xpath("//input[@id='myCountry']"));
		element.click();
		element.sendKeys("a");

		BrowserUtils.wait(1000);
		List<WebElement> elements = driver.findElements(By.xpath("//form[1]/div[1]/div[1]/div")).stream().limit(5).collect(Collectors.toList());
		int i=0;


		try {
			while (!elements.get(i).getText().equalsIgnoreCase("Angola")) {
				i++;
				System.out.println(elements.get(i).getText());

				if (elements.get(i).getText().equalsIgnoreCase("Angola")) {
					elements.get(i).click();
					//if we don't put break,you will get "stale element reference: element is not attached to the page document"
					break;
				}
			}
		}catch(org.openqa.selenium.StaleElementReferenceException ex){
			System.out.println("Catched excetion");

		}
	}


	@Test
	public void BasicAuthozation(){

		driver.findElement(By.xpath("//a[contains(text(),'Basic Auth')]")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());


	}









	@AfterMethod
	public void teardown() {
		BrowserUtils.wait(3000);
		driver.close();
	}
}
