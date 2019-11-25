package vasyl.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {
	@Test(description = "Drag and drop example")
	public void test1(){
		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		driver.manage().window().maximize();
		//click on accept cookies
		BrowserUtils.wait(3);//for demo
		driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click();
		Actions actions = new Actions(driver);
		WebElement moon = driver.findElement(By.id("draggable"));
		WebElement earth = driver.findElement(By.id("droptarget"));
		BrowserUtils.wait(3);//for demo
//      * @param source element to emulate button down at.
//      * @param target element to move to and release the mouse at.
		actions.dragAndDrop(moon, earth).perform();
		BrowserUtils.wait(3);//for demo
		driver.quit();
	}
}
