package mehmetgul.mylib.framesanddragdrop;

import mehmetgul.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import mehmetgul.utils.BrowserFactory;


//!!!!!!!!!important thing about frames!!!!!
//to deal with frames you need to switch the frame but if there is multiple frame and
// if this frames are not child to each other and when you want to switch to other frame,
//you need to come back to default content back from this content we can switch to other frames.
//for this we need to use driver.defaultContent()
//If frames having child frames then we don't need to go back to default content.
//Directly we can switch to child frames.
/*
This is Default page
 In this page to switch the frames use driver.switchTo().defaultContent()
----------------------------------------------------------------
|			-------------       ---------------------           |
|			|           |       |                   |           |
|			|  Frame 1  |       |   Frame 2         |           |
|			|           |       |                   |           |
|			|           |       |                   |           |
|			|           |       |                   |           |
|			|           |       |                   |           |
|			-------------       ---------------------           |
|                                                               |
|                                                               |
|                                                               |
|                                                               |
-----------------------------------------------------------------

Default Page
This has child frame and we can switch to child normally.
---------------------------------------------
|    ------------------------------         |
|   |       |------------------|  |         |
|   |       |                  |  |         |
|   |       |                  |  |         |
|   |       |                  |  |         |
|   |       |   Frame 2        |  |         |
|   |       |                  |  |         |
|   |       |                  |  |         |
|   |       |                  |  |         |
|   |       |                  |  |         |
|   |       --------------------  |         |
|   |                             |         |
|   |   Frame 1                   |         |
|   |                             |         |
|   --------------------------------        |
|                                           |
|                                           |
|                                           |
---------------------------------------------

*/
public class IamNotARobot {
	public static void main(String[] args) {


		//setting up chrome driver
		WebDriver driver = BrowserFactory.getDriver("chrome");

		//opening the target url
		driver.get("https://recaptcha-demo.appspot.com/recaptcha-v2-checkbox.php");
		// it will call the reusable method to switch to frame and click that with given parameters.
		int number = findTheNumberOfFrame(driver, By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));

		BrowserUtils.wait(2000);

		driver.switchTo().frame(number);
		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();

		//after returning the default content we can switch to another independent frame
		driver.switchTo().defaultContent();

		//this will open the another indepedent frame.
		int number1 = findTheNumberOfFrame(driver, By.xpath("//*[@id=\"recaptcha-verify-button\"]"));
		//BrowserUtils.wait(2000);
		driver.switchTo().frame(number1);
		driver.findElement(By.xpath("//*[@id=\"recaptcha-verify-button\"]")).click();

	}

	public static int findTheNumberOfFrame(WebDriver driver, By by) {

		int i;
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println(frameCount);

		for (i = 0; i < frameCount; i++) {
			driver.switchTo().frame(i);
			int count = driver.findElements(by).size();

			if (count > 0) {
				//driver.findElement(by).click();
				break;
			} else {
				System.out.println("continue looping");
			}


		}
		// this is to switching back to default page from iframe.
		driver.switchTo().defaultContent();
		return i;
	}
}
