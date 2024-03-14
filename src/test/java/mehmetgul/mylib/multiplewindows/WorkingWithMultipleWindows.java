package mehmetgul.mylib.multiplewindows;

import mehmetgul.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import mehmetgul.utils.BrowserFactory;


import java.util.Iterator;
import java.util.Set;

//While testing when you open multiple windows/tabs and
// when you want to navigate and retrieve data from this pages.


public class WorkingWithMultipleWindows {
	public static void main(String[] args) {

		//Setting up chrome driver via own created util package
		WebDriver driver = BrowserFactory.getDriver("chrome");

		// opening the target url
		driver.get("http://formy-project.herokuapp.com/switch-window");

		// giving time delay for page to load.
		BrowserUtils.wait(2000);

		//clicking the target link in web page
		driver.findElement(By.xpath("//button[@id='new-tab-button']")).click();
		WebElement element =driver.findElement(By.xpath("//button[@id='new-tab-button']"));
		System.out.println("Element value : " +element);

		//To handle different windows , we are using Set.
		Set<String>  ids = driver.getWindowHandles();

		//For iterating the separate windows we use Iterator
		Iterator<String> it = ids.iterator();

		//To move it next window, we use next() method. First we are moving to parent window.
		String parentId = it.next();

		// We are moving it to the child window.
		String child = it.next();

		//After moving to child window we are switching to the child window.
		driver.switchTo().window(child);

		//We are tryin to be sure that we are in child window. Receving some text from child.
		System.out.println(driver.findElement(By.xpath("//h1[@class='display-3']")).getText());

		BrowserUtils.wait(3000);
		//Moving back to the parent window.
		driver.switchTo().window(parentId);


	}

}
