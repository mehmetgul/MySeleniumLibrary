package tests.mehmetgul.webui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class WebUiElementsTest {
	public static void main(String[] args) {
		WebDriver driver = new BrowserFactory().getDriver("chrome");
		driver.get("https://www.spicejet.com/");


		//Choose Round Trup Radio Button
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		if(driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style").contains("1")){
			System.out.println("Radio button is enabled");
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Radio button is not enabled");
			Assert.assertTrue(false);
		}

		// Choosing FROM city
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']")).click();

		BrowserUtils.wait(3000);

		//choosing TO city
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),'Chennai (MAA)')]")).click();

		//choosing depart date
		//driver.findElement(By.xpath("//body/form[@id='aspnetForm']/div[@class='maincontainer']/div[@id='wrapper']/div[@id='mainContents']/div[@id='new-homepage']/div[@id='home_banner']/div[@class='home_flight_search']/div[@id='content-change']/div[@class='book']/div[@id='flightSearchContainer']/div[@class='picker-first2']/button[1]")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[@class='ui-state-default'][contains(text(),'14')]")).click();

		BrowserUtils.wait(3000);
		//choosing return date.
		driver.findElement(By.xpath("//div[@id='Div1']//button[@class='ui-datepicker-trigger']")).click();
		driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-week-end')]//a[@class='ui-state-default'][contains(text(),'28')]")).click();


		BrowserUtils.wait(2000);

		//Opens the number of passenger choosing menu
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();

		BrowserUtils.wait(2000);

		//To Choose number of adults
		Select adult = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")));
		adult.selectByValue("3");

		BrowserUtils.wait(2000);

		//Choosing child passenger number.
		Select child = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']")));
		child.selectByValue("4");

		BrowserUtils.wait(3000);

		//Choosing Currency
		Select s = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")));
		s.selectByValue("USD");

		BrowserUtils.wait(3000);

		//Verifying the checkbox is checked or not. if not checked then it will continue the process
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());

		// Clicking the checkbox.
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();

		//Verifying the checkbox is checked or not. if checked then it will continue the process
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());


		//click Search button
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();

		BrowserUtils.wait(2000);
		driver.quit();
	}
}
