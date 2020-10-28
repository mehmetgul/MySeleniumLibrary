package mehmetgul.mylib.dropdown;

import mehmetgul.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import mehmetgul.utils.BrowserFactory;


public class DropDown {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.getDriver("chrome");
		driver.get("http://practice.cybertekschool.com/");

	}


	@AfterMethod
	public void teardown() {
		BrowserUtils.wait(3000);
		driver.close();
	}


	@Test
	public void dropDownMethod() {

		driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]")).click();
		driver.findElement(By.xpath("//select[@id='dropdown']")).click();

		Select sl = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
		System.out.println(sl.getOptions());
		sl.selectByValue("1");
	}
}
