package vasyl.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecutorPractice {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.getDriver("chrome");
	}

	@Test(description = "Scrolling with JavaScriptExecutor")
	public void test1() {
		driver.get("http://practice.cybertekschool.com/infinite_scroll");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 10; i++) {
			//move 500px down
//            Parameters
//            x-coord is the horizontal pixel value that you want to scroll by.
//            y-coord is the vertical pixel value that you want to scroll by.
			js.executeScript("window.scrollBy(0, 500)");
			BrowserUtils.wait(2000);
		}
		BrowserUtils.wait(2000);
	}

	@Test(description = "Scrolling with JSexecutor to specific element")
	public void test2() {
		driver.get("http://practice.cybertekschool.com/large");
		WebElement link = driver.findElement(By.linkText("Cybertek School"));
		BrowserUtils.wait(2000);//for demo
//        js code from the browser
//        var footer = document.getElementById('page-footer');
//        footer.scrollIntoView(true);


		JavascriptExecutor js = (JavascriptExecutor) driver;
		//this script must scroll, until link element is visible
		//once link element will be visible, it will stop scrolling
		//arguments[0] = means first webelement after comma (link)
		//arguments it's an array of webelements after comma
		//arguments[0] = link web element, it can be any web element
		BrowserUtils.wait(2000);
		js.executeScript("arguments[0].scrollIntoView(true)", link);
		BrowserUtils.wait(2000);

//    var btn1 = document.getElementsByTagName('a')[1];
	}

	//    btn1.click()
	@Test(description = "Click with JS executor")
	public void test3() {
		driver.get("http://practice.cybertekschool.com/dynamic_loading");
		//Example 1 is a beginning of the phrase <a href='http:'>Example 1.....</a>
		WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
		BrowserUtils.wait(2000);//wait for demo
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//arguments[0] = link1 web element
		//whenever regular selenium methods are not working, I use js executor
		//or for scrolling
		//arguments[0].click() is an alternative for link1.click()
		js.executeScript("arguments[0].click()", link1);
		BrowserUtils.wait(2000);//wait for demo
	}

	//document.getElementsByName('full_name')[0].setAttribute('value','My name')
	@Test(description = "Enter text with JS executor")
	public void test4() {
		driver.get("http://practice.cybertekschool.com/sign_up");

		WebElement name = driver.findElement(By.name("full_name"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement submitButton = driver.findElement(By.name("wooden_spoon"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		BrowserUtils.wait(2000);
		js.executeScript("arguments[0].setAttribute('value','John Simith')",name);
		BrowserUtils.wait(2000);
		js.executeScript("arguments[0].setAttribute('value','some@email.com')",email);
		BrowserUtils.wait(2000);
		js.executeScript("arguments[0].click()",submitButton);
		BrowserUtils.wait(2000);

	}

	@AfterMethod
	public void after() {
		driver.quit();
	}
}