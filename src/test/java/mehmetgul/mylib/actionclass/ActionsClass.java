package mehmetgul.mylib.actionclass;

// How to MouseOver on object with Selenium
//Performing Mouse and Keyboard interactions with Selenium
//Context click on element
// Double click on elemant
//Drag and Dropping element
//This is added from remote repo .....
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BrowserFactory;

//I added this from remote

public class ActionsClass {
	static WebDriver driver;

	//static WebDriver driver;
	////static WebDriver driver;////
	////static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// setting up the chrome driver
		driver = new BrowserFactory().getDriver("chrome");

		//opening the target url
		driver.get("http://www.ebay.com");


		Thread.sleep(3000);

		//using action class to mousehover on the element
		Actions a = new Actions(driver);

		// moving to specific element. We need to use build().perform()
		WebElement el=driver.findElement(By.xpath("//ul[@class='hl-cat-nav__container']"));
		el.findElement(By.linkText("Motors"));
	//	WebElement element=driver.findElement(By.cssSelector("body.desktop.gh-flex:nth-child(2) div.main-content:nth-child(10) div.hl-cat-nav:nth-child(1) ul.hl-cat-nav__container:nth-child(1) > li.hl-cat-nav__js-tab:nth-child(3)"));
		a.moveToElement(el).build().perform();

		Thread.sleep(5000);

		//opening the target URL
		driver.get("http://www.amazon.com");


		//clicking search box and using shift key to make the letters capital and sending the value and double clicking on the value to make it selected
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().sendKeys(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

		//Creating the object of web element to reuse in other places
		WebElement move = driver.findElement(By.xpath("//span[contains(@class,'nav-line-2')][contains(text(),'Account & Lists')]"));

		//contentClick is used for right click on an element.
		a.moveToElement(move).contextClick().build().perform();



		//driver.close();
	}
}
