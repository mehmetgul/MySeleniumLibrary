package mehmetgul.mylib.z_mysandbox.cucumberDDT;

import mehmetgul.utils.BrowserFactory;
import mehmetgul.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		//

		int sum = 0;
		WebDriver driver = BrowserFactory.getDriver("chrome");
		driver.get("https://www.megamillions.com/Winning-Numbers/Previous-Drawings.aspx#page3");
		BrowserUtils.wait(2000);
		WebElement button= driver.findElement(By.xpath("//button[contains(text(),'Load More')]"));
		for (int i=0;i<10;i++){
			button.click();
			BrowserUtils.wait(500);
		}

		List<WebElement> list = driver.findElements(By.xpath("//body/form[@id='form']/div[@id='container']/section[@id='main']/div[3]/div[1]/div[3]/a/ul[1]/li"));
		System.out.println("Size:::::" + list.size());
		int i=0;
		for (WebElement list1 : list) {
			String b="";
			if(i<6){
				 b = list1.getText();
				System.out.print(" "+b);
				i++;
			}else {
				i = 1;
				System.out.println();
				b = list1.getText();
				System.out.print(" "+b);

			}

		}
		driver.quit();
	}


		/*
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		BrowserUtils.wait(2000);
		for (int i = 0; i < count - 2; i++) {
			String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int valueinteger = Integer.parseInt(value);
			sum = sum + valueinteger;//103

		}
		//System.out.println(sum);
		BrowserUtils.wait(2000);
		String Extras = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();

		int extrasValue = Integer.parseInt(Extras);
		int TotalSumValue = sum + extrasValue;
		System.out.println(TotalSumValue);

		BrowserUtils.wait(2000);
		String ActualTotal = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int ActualTotalVAlue = Integer.parseInt(ActualTotal);
		if (ActualTotalVAlue == TotalSumValue) {
			System.out.println("Count Matches");
		} else {
			System.out.println("count fails");

		}*/
}

