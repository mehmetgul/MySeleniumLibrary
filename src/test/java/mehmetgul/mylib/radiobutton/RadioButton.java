package mehmetgul.mylib.radiobutton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import mehmetgul.utils.BrowserFactory;

import java.util.List;

public class RadioButton {

	@Test
	public void radioButton() {
		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("http://www.tizag.com/htmlT/htmlradio.php");

		List<WebElement> elements= driver.findElements(By.xpath("//tbody/tr/td/div[4]/input"));
		for (int i = 0; i <elements.size(); i++) {

			Boolean is_selected = elements.get(i).isSelected();

			// If 'is_selected' is true that means the first radio button is
			// selected.
			if (is_selected == true) {
				// If the first radio button is selected by default then,
				// select the second radio button.
				elements.get(i+1).click();
				elements.get(i+1).getText();
			} else {
				// If the first radio button is not selected then, click the first
				// radio button.
				elements.get(i).click();
				System.out.println(elements.get(i).getText());

			}
		}
	}
}
