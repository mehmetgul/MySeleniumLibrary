package tests.mehmetgul.mylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class FramesAndDragDrop {
	public static void main(String[] args) {


		//settin up chrome driver
		WebDriver driver = BrowserFactory.getDriver("chrome");

		//opening the target url
		driver.get("https://jqueryui.com/droppable/");

		BrowserUtils.wait(2000);
		//switching to the frame using switchTo
		WebElement wElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(wElement);
		driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]")).click();

		//Creating actions class object to use drag drop
		Actions a = new Actions(driver);

		//Creatin Webelement objects for drag
		WebElement drag = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
		//Creatin Webelement objects for drop
		WebElement drop = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));

		//using draganddrop method and we build and perform this action.
		a.dragAndDrop(drag,drop).build().perform();




	}
}
