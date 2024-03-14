package mehmetgul.mylib.javaalerts;

import mehmetgul.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import mehmetgul.utils.BrowserFactory;

//Handling javaScript Alerts.
//javaScript Alerts are not and html alerts so we need to handle them

public class JavaAlerts {
	public static void main(String[] args) {

		//Setting up chrome driver
		WebDriver driver = new BrowserFactory().getDriver("chrome");

		//opening the target url
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");

		//clicking the button
		driver.findElement(By.xpath("//div[@class='display']//form//input")).click();
		BrowserUtils.wait(2000);
		driver.findElement(By.xpath("//div[@class='display']//form//input")).click();

		//receving the text on javascript alert
		//String alertText= driver.switchTo().alert().getText();
		System.out.println(driver.switchTo().alert().getText());

		BrowserUtils.wait(2000);
		//Accepts =ok button.
		driver.switchTo().alert().accept();
		//dismiss method is to click cancel button.
		//driver.switchTo().alert().dismiss();

	}
}
