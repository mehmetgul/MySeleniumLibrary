package dogan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormyTest {
	//global (instance) variable
	WebDriver driver;

	//method 1 navigation to button page
	public void Button() throws InterruptedException {
		//Setting up ChromeDriver via Maven dependencies.
		WebDriverManager.chromedriver().setup();
		//Creating object of ChromeDriver
		driver = new ChromeDriver();
		//Using get method to open the given url
		driver.get("http://formy-project.herokuapp.com");
		//To give time delay for page loading or any date.
		Thread.sleep(2000);
		//Locating the target element.
		driver.findElement(By.xpath("/html/body/div/div/li[2]/a")).click();
		//Time delay for elements to load
		//Thread.sleep(3000);
		//Retrieve the page title.
		String title = driver.getTitle();
		//Printing the page title
		System.out.println(title);
	}

	// method button primary

	public void VerifyingPrimaryButton() throws InterruptedException {
		//verify the primary button
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/form/div[1]/div/div/button[1]")).click();
		Thread.sleep(2000);
		String getText = driver.findElement(By.xpath("/html/body/div/form/div[1]/div/div/button[1]")).getText();
		System.out.println(getText);
		String PrimaryButton = "/html/body/div/form/div[1]/div/div/button[1]";
		WebElement element = driver.findElement(By.xpath(PrimaryButton));
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
			System.out.println(element.getText());
		}

	}


	// methods for success button
	public void VerifyingSuccesButton() throws InterruptedException {

		//verify the primary button
		Thread.sleep(2000);
		String SuccessButton = "/html/body/div/form/div[1]/div/div/button[2]";
		WebElement element = driver.findElement(By.xpath(SuccessButton));
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
			Thread.sleep(2000);
			System.out.println(element.getText());
		}

	}


	//method for Verifyin info Button
	public void VerifyingInfoButton() throws InterruptedException {

		Thread.sleep(2000);
		WebElement infoElement = driver.findElement(By.xpath("/html/body/div/form/div[1]/div/div/button[3]"));
		String infoPath = "/html/body/div/form/div[1]/div/div/button[3]";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(infoPath)));
		infoElement.click();
		System.out.println(infoElement.getText());
	}

	//method for Verifyin warning Button
	public void VerifyingWarningButton() throws InterruptedException {

		// WebElement infoElement = driver.findElement(By.xpath("/html/body/div/form/div[1]/div/div/button[3]"));
		String Warningpath = "/html/body/div/form/div[1]/div/div/button[4]";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Warningpath)));
		element2.click();
		System.out.println(element2.getText());
	}


	public void VeriyUsingArraryMiddleSectionButton() throws InterruptedException {
		//This list is for more than one locator and it will store all locator in an array
		List<WebElement> arrayLocator = driver.findElements(By.xpath("/html/body/div/form/div[2]/div/div/div/button"));
		// first way to  for each loop to inside of array element and get
		for (WebElement element : arrayLocator) {
			Thread.sleep(2000);
			element.click();
			System.out.println(element.getText());
		}

	}

	public void VerifyUsingArrayTopSectionButton(String x) throws InterruptedException {
		List<WebElement> topButtons = driver.findElements(By.xpath(x));

		for (int i = 0; i < topButtons.size(); i++) {
			Thread.sleep(2000);
			topButtons.get(i).click();
			System.out.println(topButtons.get(i).getText());
			if (topButtons.get(i).getText().equals("Warning")) {
				topButtons.get(i).click();
				System.out.println(topButtons.get(i).getText());
				break;
			}
		}

	}


	@Test
	public void verifyPrimaryButton() throws InterruptedException {
		//to call the dynamic from our class
		Button();
		VerifyingPrimaryButton();
	}


	@Test
	public void verifySuccessButton() throws InterruptedException {
		//to call the dynamic from our class
		Button();
		VerifyingSuccesButton();
	}


	@Test
	public void verifyInfoButton() throws InterruptedException {
		Button();
		VerifyingInfoButton();
	}


	@Test
	public void verifyWarningButton() throws InterruptedException {
		Button();
		VerifyingWarningButton();
		driver.close();
	}


	@Test
	public void UsingArrayToClickAndGetTextOfButtons() throws InterruptedException {
		Button();
		VeriyUsingArraryMiddleSectionButton();
	}


	@Test
	public void UsingArrayForTopSectionButton() throws InterruptedException {

		Button();
		VerifyUsingArrayTopSectionButton("/html/body/div/form/div[1]/div/div/button");
	}

	@Test
	public void  Sample() throws InterruptedException {
		ArrayList<String > urls = new ArrayList<String>(Arrays.asList(
				"https://www.amazon.com",   // Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
				"https://www.google.com",   // Google
				"https://www.facebook.com")); //
		WebDriverManager.chromedriver().setup();

		for(int i=0; i<urls.size();i++){
			driver = new ChromeDriver();
			driver.get(urls.get(i));
			Thread.sleep(3000);
			String title = driver.getTitle().toLowerCase().replaceAll(" ","");
			int firstIndex=urls.get(i).indexOf("www.");
			int lastIndex=urls.get(i).indexOf(".com");
			String domain = urls.get(i).substring(firstIndex +4,lastIndex);
			if(title.contains(domain)){
				System.out.println(urls.get(i)+ "  : Passed the title test");
			}else {
				System.out.println(urls.get(i)+ "  : Failed the title test");
			}
			driver.close();
		}
	}


}
