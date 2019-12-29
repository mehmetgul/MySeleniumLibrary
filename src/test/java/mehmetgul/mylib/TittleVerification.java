package mehmetgul.mylib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class TittleVerification {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<String > urls = new ArrayList<String>(Arrays.asList("https://www.amazon.com","https://www.google.com","https://www.facebook.com"));
		WebDriverManager.chromedriver().setup();
	for(int i=0; i<urls.size();i++){
			WebDriver driver = new ChromeDriver();
			driver.get(urls.get(i));
			Thread.sleep(3000);
			String title = driver.getTitle().toLowerCase().replaceAll(" ","");
			int firstIndex=urls.get(i).indexOf("www.");
			int lastIndex=urls.get(i).indexOf(".com");
			String domain = urls.get(i).substring(firstIndex +4,lastIndex);
			if(title.contains(domain)){
				System.out.println(urls.get(i)+ "  : Passed the title test");

			}else {
				System.out.println(urls.get(i)+ "  : Failed the title test");
			}
			driver.close();
		}

	}

}
