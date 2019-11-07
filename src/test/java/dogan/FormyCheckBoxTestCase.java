package tests.dogan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormyCheckBoxTestCase extends CheckBox  {
	// inheritance
	// extends keyword to connect to class each for using its methods variables ,
	// Test cases only
	//jnuit @Test

	@Test

	public void NavigateToCheckboxLink() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://formy-project.herokuapp.com/");
		Thread.sleep(3000);
		navigateToDesiredLink("Checkbox");

		closeChromeBrowser();


	}

	@Test
	public void clickable() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://formy-project.herokuapp.com/");
		Thread.sleep(3000);
		navigateToDesiredLink("Checkbox");
		clickdesirecheckbox("checkbox1");
		clickdesirecheckbox("checkbox2");

	}
}
