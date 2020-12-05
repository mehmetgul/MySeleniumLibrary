package mehmetgul.mylib.z_mysandbox.cucumberDDT;

import mehmetgul.utils.BrowserFactory;
import mehmetgul.utils.BrowserUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test2 {
	WebDriver driver;

	@Test
	public void test() {


		//setting up chrome driver
		driver = BrowserFactory.getDriver("chrome");

		//opening the target url
		driver.get("https://test.crowdstreet.com/invexp/accounts/create-account/");
		// it will call the reusable method to switch to frame and click that with given parameters.
		int number = findTheNumberOfFrame(driver, By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));

		BrowserUtils.wait(1000);

		driver.switchTo().frame(number);
		WebElement element=driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
		scrollDown(element);
		BrowserUtils.wait(1000);
		element.click();

		// TODO bu asamdan sonra diger buttona tiklicaksaniz yine o button un hangi frame de oldugunu bulmaniz gerekiyor.


	}


	/**
	 *Burada aradigim elementin hangi frame de oldugunu bilmedigim icin
	 * once kac adet frame var ve benim webelementim hangi framde de
	 * oldugunu bulup yukaridaki metod da bu frame i secip gidip click yapiyorum.
	 */
	public static int findTheNumberOfFrame(WebDriver driver, By by) {

		int i = 0;
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Frame count : " + frameCount);

		for (i = 0; i < frameCount; i++) {
			driver.switchTo().frame(i);
			int count = driver.findElements(by).size();

			if (count > 0) {
				driver.switchTo().defaultContent();
				return i;
			} else {
				System.out.println("continue looping");
			}
		}
		// this is to switching back to default page from iframe.
		driver.switchTo().defaultContent();
		return i;
	}

	/**
	 *I am not a robot sayfanin altinda oldugu icin
	 * once sayfanin altina gidiyorum ve elementi buluyorum sonra click yapiyorum.
	 */
	public void scrollDown(WebElement str) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", str);

		//javascriptExecutor.executeScript("window.scrollBy(0,100)");

	}


}
