package mehmetgul.mylib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

// I am here from local
public class Test {
	public static String betterCompression(String s) {

		char[] str = s.toCharArray();
		int[] map = new int[26];
		int i = 0;
		int n = s.length();
		while (i < n) {
			char ch = str[i];
			if (ch >= 'a' && ch <= 'z') {
				int start = i + 1;
				int end = start;
				while (end < n && (str[end] >= '0' && str[end] <= '9')) {
					end++;
				}

				int count = Integer.parseInt(s.substring(start, end));

				map[ch - 'a'] += count;
				i = end;
			} else {
				i++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (map[ch - 'a'] > 0) {
				sb.append(ch);
				sb.append(map[ch - 'a']);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(betterCompression("a3c9b2c1"));
	}


	@org.testng.annotations.Test
	public void testNumbers() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://hectorware.com/index.php/trial/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Numarlarin oldugu locator 9+15 gibi.
		WebElement element = driver.findElement(By.xpath("//span[@class='et_pb_contact_captcha_question']"));
		//Web elementi text haline ceviriyoruz
		String numbers = element.getText();

		//Burada 9+15 stringi " " space ile parcalayip array icine koyup.
		// Lazim olan kisimlari aldim.
		String[] arr = numbers.split(" ");

		//Toplama islemini yapabilmek icin Stringi integer a cevirdim.
		int total = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);

		//Burada toplami sendkey icine koymak icin tekrar stringe donusturdum.
		String total1 = String.valueOf(total);

		//Textbox in locator i
		WebElement textbox = driver.findElement(By.xpath("//input[@class='input et_pb_contact_captcha']"));

		//Burada da tekx box icine toplami yazip enter yaptim direk submit butone basmadan.
		//siz isterseniz Keys.Enter i silip birek submut dugmesine click yapabilirsiniz.
		textbox.sendKeys(total1, Keys.ENTER);

	}

	@org.testng.annotations.Test
	public void test14() {
		WebDriver driver = null;
		String browser = "firefox";

		if (browser.equals("chorme")) {
			//web drive setup
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.get("https://www.gobankingrates.com/");

		// I put thread.sleep for just to see the process
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		//I devided the xpath in 2 part to make it dynamic
		// //iframe[@id='google_ads_iframe_/1035677/GBR_homepage_750x111_hometop01_/750x111_desktop_0']
		String a = "//iframe[@id='google_ads_iframe_/1035677/GBR_homepage_750x111_hometop0";
		String b = "_/750x111_desktop_0']";


		WebElement element = driver.findElement(By.xpath("//section[contains(@class, 'advert-under-posts-row')]//aside[@class='col-xs-12']"));
		//dfsdfsdfsdf
		int number = element.findElements(By.tagName("iframe")).size();

		//dsfsdfdsfdsfsdf
		System.out.println("Total number of Frame : " + number);

		//
		for (int i = 1; i <= number; i++) {


			try {
				WebElement mytext = element.findElement(By.xpath(a + i + b));

				driver.switchTo().frame("google_ads_iframe_/1035677/GBR_homepage_750x111_hometop01_/750x111_desktop_0"); //by id or by name
				//driver.switchTo().frame(mytext);  //another way. if id or name is different in all frames

				//second frame was not having any id or name so i used index of that frame
				driver.switchTo().frame(0);

				// getting the infromation of open account locator
				WebElement tek = driver.findElement(By.xpath("//*[contains(text(), 'Open Account')]"));

				if (tek.getText().equals("Open Account")) {
					//for verifiying from console, printed the text
					System.out.println("This is button " + i + " " + tek.getText());

					Assert.assertEquals(tek.getText(), "Open Account");
				}

				//switcinhg to detail page which is element locator..
				driver.switchTo().defaultContent();

			} catch (Exception e) {
				System.out.println("Framework de hata var.. ikinci frame");
				e.printStackTrace();
			}
		}

		//wait added to see.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();

	}

	@org.testng.annotations.Test
	public void test15() {

		WebDriver driver = null;
		String browser = "chorme";

		if (browser.equals("chorme")) {
			//web drive setup
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.get("https://www.gobankingrates.com/");

		// I put thread.sleep for just to see the process
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement all = driver.findElement(By.xpath("/html/body/div[2]/section[@class='row featured-articles']"));
		List<WebElement> aa = all.findElements(By.xpath("//section[@class='row featured-articles']//li"));
		System.out.println("Number of Articles "+ aa.size());

		try {

			for (int i = 1; i <= aa.size(); i++) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'post-list__item--active')]")));
				String futureArticle = all.findElement(By.xpath("//section[@class='row featured-articles']//li["+i+"]")).getText();
				System.out.println(futureArticle);

			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("There is error");
		}

		//wait added to see.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();

	}

	//...

//This is future 2

//....

}
