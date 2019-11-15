package vasyl.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenQuitClose {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver obj = new ChromeDriver();
		obj.get("http://www.amazon.com");
		Thread.sleep(2000);
		System.out.print(obj.getTitle());
		obj.close();
	}

}
