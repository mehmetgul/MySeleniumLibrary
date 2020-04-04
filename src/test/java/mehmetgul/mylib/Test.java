package mehmetgul.mylib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

	public static void main(String[] args)  {

		System.out.println(betterCompression("a3c9b2c1"));
	}

	@org.testng.annotations.Test
	public void testNumbers(){
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
		String numbers= element.getText();

		//Burada 9+15 stringi " " space ile parcalayip array icine koyup.
		// Lazim olan kisimlari aldim.
		String[] arr=numbers.split(" ");

		//Toplama islemini yapabilmek icin Stringi integer a cevirdim.
		int total= Integer.parseInt(arr[0])+Integer.parseInt(arr[2]);

		//Burada toplami sendkey icine koymak icin tekrar stringe donusturdum.
		String total1= String.valueOf(total);

		//Textbox in locator i
		WebElement textbox= driver.findElement(By.xpath("//input[@class='input et_pb_contact_captcha']"));

		//Burada da tekx box icine toplami yazip enter yaptim direk submit butone basmadan.
		//siz isterseniz Keys.Enter i silip birek submut dugmesine click yapabilirsiniz.
		textbox.sendKeys(total1, Keys.ENTER);

	}
}
