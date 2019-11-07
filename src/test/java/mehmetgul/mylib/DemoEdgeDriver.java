package mehmetgul.mylib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

// Edge Driver setup in MAC OS
//As of now it doesn't work.
public class DemoEdgeDriver {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.google.com");
	}
}
